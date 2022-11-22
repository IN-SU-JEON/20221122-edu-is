package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingFinished extends AbstractEvent {

    private String foodId;
    private String orderId;

    public CookingFinished(Food aggregate){
        super(aggregate);
    }
    public CookingFinished(){
        super();
    }
}
