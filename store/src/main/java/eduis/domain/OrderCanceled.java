package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private String foodId;
    private String orderId;

    public OrderCanceled(Food aggregate){
        super(aggregate);
    }
    public OrderCanceled(){
        super();
    }
}
