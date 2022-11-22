package eduis.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="OrderDetailList_table")
@Data
public class OrderDetailList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String foodId;
        private String orderId;
        private String status;
        private String customerId;
        private String address;


}