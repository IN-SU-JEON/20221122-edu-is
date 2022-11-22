package eduis.domain;

import eduis.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class Ordered extends AbstractEvent {

    private String orderId;
    private String foodId;
    private String customerId;
    private String address;
    private String qty;
    private String options;
}
