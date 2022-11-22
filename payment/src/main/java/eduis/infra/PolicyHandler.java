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
    @Autowired PaymentinformationRepository paymentinformationRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_PaymentCancel(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener PaymentCancel : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        Paymentinformation.paymentCancel(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_PaymentCancel(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener PaymentCancel : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        Paymentinformation.paymentCancel(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_Refund(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener Refund : " + refunded + "\n\n");


        

        // Sample Logic //
        Paymentinformation.refund(event);
        

        

    }


}


