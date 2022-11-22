package eduis.domain;

import eduis.domain.CookingStarted;
import eduis.domain.CookingFinished;
import eduis.domain.Refunded;
import eduis.domain.RefundRejected;
import eduis.domain.OrderCanceled;
import eduis.domain.Orderaccepted;
import eduis.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Food_table")
@Data

public class Food  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String options;

    @PostPersist
    public void onPostPersist(){


        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.publishAfterCommit();



        CookingFinished cookingFinished = new CookingFinished(this);
        cookingFinished.publishAfterCommit();



        Refunded refunded = new Refunded(this);
        refunded.publishAfterCommit();



        RefundRejected refundRejected = new RefundRejected(this);
        refundRejected.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();



        Orderaccepted orderaccepted = new Orderaccepted(this);
        orderaccepted.publishAfterCommit();

    }

    public static FoodRepository repository(){
        FoodRepository foodRepository = StoreApplication.applicationContext.getBean(FoodRepository.class);
        return foodRepository;
    }




    public static void orderListAdd(Paid paid){

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

        
    }
    public static void refundReceipt(Refunded refunded){

        /** Example 1:  new item 
        Food food = new Food();
        repository().save(food);

        */

        /** Example 2:  finding and process
        
        repository().findById(refunded.get???()).ifPresent(food->{
            
            food // do something
            repository().save(food);


         });
        */

        
    }


}
