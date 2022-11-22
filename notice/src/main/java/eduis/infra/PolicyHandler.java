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
    @Autowired NoticeInfoRepository noticeInfoRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentCanceled'")
    public void wheneverPaymentCanceled_NoticeRequest(@Payload PaymentCanceled paymentCanceled){

        PaymentCanceled event = paymentCanceled;
        System.out.println("\n\n##### listener NoticeRequest : " + paymentCanceled + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_NoticeRequest(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener NoticeRequest : " + refunded + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RefundRejected'")
    public void wheneverRefundRejected_NoticeRequest(@Payload RefundRejected refundRejected){

        RefundRejected event = refundRejected;
        System.out.println("\n\n##### listener NoticeRequest : " + refundRejected + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_NoticeRequest(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener NoticeRequest : " + paid + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Deliveryfinished'")
    public void wheneverDeliveryfinished_NoticeRequest(@Payload Deliveryfinished deliveryfinished){

        Deliveryfinished event = deliveryfinished;
        System.out.println("\n\n##### listener NoticeRequest : " + deliveryfinished + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='RefundRejected'")
    public void wheneverRefundRejected_NoticeRequest(@Payload RefundRejected refundRejected){

        RefundRejected event = refundRejected;
        System.out.println("\n\n##### listener NoticeRequest : " + refundRejected + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Orderaccepted'")
    public void wheneverOrderaccepted_NoticeRequest(@Payload Orderaccepted orderaccepted){

        Orderaccepted event = orderaccepted;
        System.out.println("\n\n##### listener NoticeRequest : " + orderaccepted + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingStarted'")
    public void wheneverCookingStarted_NoticeRequest(@Payload CookingStarted cookingStarted){

        CookingStarted event = cookingStarted;
        System.out.println("\n\n##### listener NoticeRequest : " + cookingStarted + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingFinished'")
    public void wheneverCookingFinished_NoticeRequest(@Payload CookingFinished cookingFinished){

        CookingFinished event = cookingFinished;
        System.out.println("\n\n##### listener NoticeRequest : " + cookingFinished + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_NoticeRequest(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener NoticeRequest : " + orderCanceled + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Deliverystarted'")
    public void wheneverDeliverystarted_NoticeRequest(@Payload Deliverystarted deliverystarted){

        Deliverystarted event = deliverystarted;
        System.out.println("\n\n##### listener NoticeRequest : " + deliverystarted + "\n\n");


        // Comments // 
		//카카오톡 알림 요청

        // Sample Logic //
        NoticeInfo.noticeRequest(event);
        

        

    }

}


