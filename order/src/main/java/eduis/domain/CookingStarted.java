package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private String foodId;
    private String orderId;
}


