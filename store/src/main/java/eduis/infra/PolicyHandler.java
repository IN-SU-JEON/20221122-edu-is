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
    @Autowired FoodRepository foodRepository;
    @Autowired MenuRepository menuRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_OrderListAdd(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener OrderListAdd : " + paid + "\n\n");


        // Comments // 
		//주문 목록 추가

        // Sample Logic //
        Food.orderListAdd(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_RefundReceipt(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener RefundReceipt : " + refunded + "\n\n");


        // Comments // 
		//환불 접수

        // Sample Logic //
        Food.refundReceipt(event);
        

        

    }


}


