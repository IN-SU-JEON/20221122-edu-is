package eduis.infra;

import eduis.domain.*;
import eduis.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailListViewHandler {


    @Autowired
    private OrderDetailListRepository orderDetailListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderDetailList orderDetailList = new OrderDetailList();
            // view 객체에 이벤트의 Value 를 set 함
            orderDetailList.setOrderId(String.valueOf(ordered.getOrderId()));
            // view 레파지 토리에 save
            orderDetailListRepository.save(orderDetailList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

