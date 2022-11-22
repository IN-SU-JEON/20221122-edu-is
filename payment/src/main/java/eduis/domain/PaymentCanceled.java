package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private String payId;
    private String orderId;

    public PaymentCanceled(Paymentinformation aggregate){
        super(aggregate);
    }
    public PaymentCanceled(){
        super();
    }
}
