package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private String payId;
    private String orderId;

    public Refunded(Paymentinformation aggregate){
        super(aggregate);
    }
    public Refunded(){
        super();
    }
}
