package eduis.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import eduis.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import eduis.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingStarted'")
    public void wheneverCookingStarted_OrderSttausUpdate(@Payload CookingStarted cookingStarted){

        CookingStarted event = cookingStarted;
        System.out.println("\n\n##### listener OrderSttausUpdate : " + cookingStarted + "\n\n");


        // Comments // 
		//상태변경

        // Sample Logic //
        Order.orderSttausUpdate(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingFinished'")
    public void wheneverCookingFinished_OrderSttausUpdate(@Payload CookingFinished cookingFinished){

        CookingFinished event = cookingFinished;
        System.out.println("\n\n##### listener OrderSttausUpdate : " + cookingFinished + "\n\n");


        // Comments // 
		//상태변경

        // Sample Logic //
        Order.orderSttausUpdate(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_OrderSttausUpdate(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener OrderSttausUpdate : " + orderCanceled + "\n\n");


        // Comments // 
		//상태변경

        // Sample Logic //
        Order.orderSttausUpdate(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RefundRejected'")
    public void wheneverRefundRejected_OrderSttausUpdate(@Payload RefundRejected refundRejected){

        RefundRejected event = refundRejected;
        System.out.println("\n\n##### listener OrderSttausUpdate : " + refundRejected + "\n\n");


        // Comments // 
		//상태변경

        // Sample Logic //
        Order.orderSttausUpdate(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_OrderSttausUpdate(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener OrderSttausUpdate : " + refunded + "\n\n");


        // Comments // 
		//상태변경

        // Sample Logic //
        Order.orderSttausUpdate(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_OrderCancel(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener OrderCancel : " + orderCanceled + "\n\n");


        // Comments // 
		//주문취소

        // Sample Logic //
        Order.orderCancel(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_OrderCancel(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener OrderCancel : " + refunded + "\n\n");


        // Comments // 
		//주문취소

        // Sample Logic //
        Order.orderCancel(event);
        

        

    }

}


