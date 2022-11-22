package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private String foodId;
    private String orderId;

    public CookingStarted(Food aggregate){
        super(aggregate);
    }
    public CookingStarted(){
        super();
    }
}
