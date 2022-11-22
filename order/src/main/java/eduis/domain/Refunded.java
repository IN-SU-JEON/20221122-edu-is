package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private String orderId;
    private String foodId;
    private String customerId;

    public Refunded(Order aggregate){
        super(aggregate);
    }
    public Refunded(){
        super();
    }
}
