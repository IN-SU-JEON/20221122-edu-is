package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RefundRejected extends AbstractEvent {

    private String payId;
    private String orderId;

    public RefundRejected(Paymentinformation aggregate){
        super(aggregate);
    }
    public RefundRejected(){
        super();
    }
}
