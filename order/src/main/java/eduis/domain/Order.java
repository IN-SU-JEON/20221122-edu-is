package eduis.domain;

import eduis.domain.Ordered;
import eduis.domain.OrderCanceled;
import eduis.domain.Refunded;
import eduis.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String options;

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

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void orderSttausUpdate(CookingStarted cookingStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderSttausUpdate(CookingFinished cookingFinished){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderSttausUpdate(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderSttausUpdate(RefundRejected refundRejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(refundRejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderSttausUpdate(Refunded refunded){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(refunded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderCancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderCancel(Refunded refunded){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(refunded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
