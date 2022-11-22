package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private String orderId;
    private String foodId;
    private String customerId;

    public OrderCanceled(Order aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
}
