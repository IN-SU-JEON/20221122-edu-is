package eduis.infra;
import eduis.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class NoticeInfoHateoasProcessor implements RepresentationModelProcessor<EntityModel<NoticeInfo>>  {

    @Override
    public EntityModel<NoticeInfo> process(EntityModel<NoticeInfo> model) {

        
        return model;
    }
    
}
