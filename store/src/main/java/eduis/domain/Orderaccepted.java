package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderaccepted extends AbstractEvent {

    private String foodId;
    private String orderId;

    public Orderaccepted(Food aggregate){
        super(aggregate);
    }
    public Orderaccepted(){
        super();
    }
}
