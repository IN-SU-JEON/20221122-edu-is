package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Paid extends AbstractEvent {

    private String payId;
    private String orderId;
}


