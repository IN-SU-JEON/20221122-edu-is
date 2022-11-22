package eduis.domain;

import eduis.domain.Deliverystarted;
import eduis.domain.Deliveryfinished;
import eduis.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String riderId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String qty;
    
    
    
    
    
    private String options;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Deliverystarted deliverystarted = new Deliverystarted(this);
        deliverystarted.publishAfterCommit();



        Deliveryfinished deliveryfinished = new Deliveryfinished(this);
        deliveryfinished.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void receiveDeliveryFood(CookingFinished cookingFinished){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingFinished.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
