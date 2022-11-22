package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliverystarted extends AbstractEvent {

    private String riderId;
    private String customerId;
    private String address;
    private String foodId;
    private String status;

    public Deliverystarted(Delivery aggregate){
        super(aggregate);
    }
    public Deliverystarted(){
        super();
    }
}
