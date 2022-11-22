package eduis.domain;

import eduis.domain.*;
import eduis.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuChanged extends AbstractEvent {

    private String menuId;
    private String menuNm;

    public MenuChanged(Menu aggregate){
        super(aggregate);
    }
    public MenuChanged(){
        super();
    }
}
