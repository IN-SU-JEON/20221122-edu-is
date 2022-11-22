package eduis.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="DeliveryFoodList_table")
@Data
public class DeliveryFoodList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String riderId;
        private String customerId;
        private String address;


}