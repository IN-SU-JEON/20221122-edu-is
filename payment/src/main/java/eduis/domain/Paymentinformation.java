package eduis.domain;

import eduis.domain.Paid;
import eduis.domain.PaymentCanceled;
import eduis.domain.Refunded;
import eduis.domain.RefundRejected;
import eduis.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Paymentinformation_table")
@Data

public class Paymentinformation  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String payId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String customerId;

    @PostPersist
    public void onPostPersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();



        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();



        Refunded refunded = new Refunded(this);
        refunded.publishAfterCommit();



        RefundRejected refundRejected = new RefundRejected(this);
        refundRejected.publishAfterCommit();

    }

    public static PaymentinformationRepository repository(){
        PaymentinformationRepository paymentinformationRepository = PaymentApplication.applicationContext.getBean(PaymentinformationRepository.class);
        return paymentinformationRepository;
    }




    public static void paymentCancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Paymentinformation paymentinformation = new Paymentinformation();
        repository().save(paymentinformation);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(paymentinformation->{
            
            paymentinformation // do something
            repository().save(paymentinformation);


         });
        */

        
    }
    public static void paymentCancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Paymentinformation paymentinformation = new Paymentinformation();
        repository().save(paymentinformation);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(paymentinformation->{
            
            paymentinformation // do something
            repository().save(paymentinformation);


         });
        */

        
    }
    public static void refund(Refunded refunded){

        /** Example 1:  new item 
        Paymentinformation paymentinformation = new Paymentinformation();
        repository().save(paymentinformation);

        */

        /** Example 2:  finding and process
        
        repository().findById(refunded.get???()).ifPresent(paymentinformation->{
            
            paymentinformation // do something
            repository().save(paymentinformation);


         });
        */

        
    }


}
