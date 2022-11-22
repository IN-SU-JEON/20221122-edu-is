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
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CookingFinished'")
    public void wheneverCookingFinished_ReceiveDeliveryFood(@Payload CookingFinished cookingFinished){

        CookingFinished event = cookingFinished;
        System.out.println("\n\n##### listener ReceiveDeliveryFood : " + cookingFinished + "\n\n");


        // Comments // 
		//배달요리접수

        // Sample Logic //
        Delivery.receiveDeliveryFood(event);
        

        

    }

}


