package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private Long id;

    public Refunded(Food aggregate){
        super(aggregate);
    }
    public Refunded(){
        super();
    }
}
