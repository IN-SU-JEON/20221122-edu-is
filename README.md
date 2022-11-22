![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)

# 서비스 시나리오

배달의 민족 커버하기 - https://1sung.tistory.com/106

기능적 요구사항
1. 고객이 메뉴를 선택하여 주문한다.
1. 고객이 선택한 메뉴에 대해 결제한다.
1. 주문이 되면 주문 내역이 입점 상점 주인에게 주문정보가 전달된다
1. 상점주는 주문을 수락하거나 거절할 수 있다
1. 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다
1. 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다
1. 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다
1. 라이더가 해당 요리를 pick 한후, pick했다고 앱을 통해 통보한다.
1. 고객이 주문상태를 중간중간 조회한다
1. 주문상태가 바뀔 때 마다 카톡과 앱으로 알림을 보낸다
1. 고객이 요리를 배달 받으면 배송확인 버튼을 탭하여, 모든 거래가 완료된다
1. 고객이 배달 후 환불 요청을 할 수 있다.
1. 상점주는 고객의 환불 요청을 수락하거나 거절할 수 있다.



비기능적 요구사항
1. 장애격리
    1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다  Async (event-driven), Eventual Consistency
    1. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다  Circuit breaker, fallback
1. 성능
    1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다  CQRS
    1. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다  Event driven

# 소스경로

# 체크포인트

- Saga (Pub / Sub)
![image](https://user-images.githubusercontent.com/117341052/203219302-4cefb7dc-490f-4dd4-b66b-65dfafd66730.png)
  - CQRS
```
package eduis.infra;

import eduis.config.kafka.KafkaProcessor;
import eduis.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailListViewHandler {

    @Autowired
    private OrderDetailListRepository orderDetailListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            OrderDetailList orderDetailList = new OrderDetailList();
            // view 객체에 이벤트의 Value 를 set 함
            orderDetailList.setOrderId(String.valueOf(ordered.getOrderId()));
            // view 레파지 토리에 save
            orderDetailListRepository.save(orderDetailList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
  - Compensation / Correlation
```
    public static void orderListAdd(Paid paid) {
        /** Example 1:  new item 
        Food food = new Food();
        repository().save(food);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(food->{
            
            food // do something
            repository().save(food);


         });
        */
        repository().findById(paid.get???()).ifPresent(food->{
            
            food.setStatus("status:결제됨") // do something
            repository().save(food);


         });
    }
```
  - Request / Response
```
# (app) PaymentinformationService.java

package eduis.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "payment", url = "http://localhost:8082")
public interface PaymentinformationService {
    @RequestMapping(method= RequestMethod.POST, path="/paymentinformations")
    public void payment(@RequestBody Paymentinformation paymentinformation);
}

```
```
# Order.java (Entity)

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        eduis.external.Paymentinformation paymentinformation = new eduis.external.Paymentinformation();
        // mappings goes here
        OrderApplication.applicationContext.getBean(eduis.external.PaymentinformationService.class)
            .payment(paymentinformation);


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();



        Refunded refunded = new Refunded(this);
        refunded.publishAfterCommit();

    }
```
  - Circuit Breaker
```

feign:
  hystrix:
    enabled: true

hystrix:
  command:
    # 전역설정
    default:
      execution.isolation.thread.timeoutInMilliseconds: 610

```
  - Gateway / Ingress
```

spring:
  profiles: default
  cloud:
    gateway:
      routes:
        - id: order
          uri: http://localhost:8081
          predicates:
            - Path=/orders/**, /menuLists/**, /integratedOrderInformations/**
        - id: store
          uri: http://localhost:8082
          predicates:
            - Path=/foods/**, /menus/**, /orderDetailLists/**, /menuLists/**
        - id: delivery
          uri: http://localhost:8083
          predicates:
            - Path=/deliveries/**, /deliveryFoodLists/**
        - id: payment
          uri: http://localhost:8084
          predicates:
            - Path=/paymentinformations/**, 
        - id: notice
          uri: http://localhost:8085
          predicates:
            - Path=/noticeInfos/**, /noticeInfos/**
        - id: frontend
          uri: http://localhost:8080
          predicates:
            - Path=/**  

```







