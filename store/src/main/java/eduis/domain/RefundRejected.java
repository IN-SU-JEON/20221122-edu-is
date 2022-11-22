package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RefundRejected extends AbstractEvent {

    private Long id;

    public RefundRejected(Food aggregate){
        super(aggregate);
    }
    public RefundRejected(){
        super();
    }
}
