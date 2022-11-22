package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Paid extends AbstractEvent {

    private String payId;
    private String orderId;

    public Paid(Paymentinformation aggregate){
        super(aggregate);
    }
    public Paid(){
        super();
    }
}
