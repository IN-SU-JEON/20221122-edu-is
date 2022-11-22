package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Deliveryfinished extends AbstractEvent {

    private String riderId;
    private String customerId;
    private String address;
    private String foodId;
    private String status;
}


