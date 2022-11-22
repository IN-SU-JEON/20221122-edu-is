package eduis.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="IntegratedOrderInformation_table")
@Data
public class IntegratedOrderInformation {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private String orderId;
        private String menuId;
        private String foodId;
        private String payId;
        private String status;
        private String customerId;
        private String address;
        private String qty;
        private String options;


}