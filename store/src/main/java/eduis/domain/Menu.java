package eduis.domain;

import eduis.domain.MenuChanged;
import eduis.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Menu_table")
@Data

public class Menu  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String menuId;
    
    
    
    
    
    private String menuNm;

    @PostPersist
    public void onPostPersist(){


        MenuChanged menuChanged = new MenuChanged(this);
        menuChanged.publishAfterCommit();

    }

    public static MenuRepository repository(){
        MenuRepository menuRepository = StoreApplication.applicationContext.getBean(MenuRepository.class);
        return menuRepository;
    }






}
