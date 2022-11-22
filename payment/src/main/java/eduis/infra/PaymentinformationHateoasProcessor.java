package eduis.infra;
import eduis.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PaymentinformationHateoasProcessor implements RepresentationModelProcessor<EntityModel<Paymentinformation>>  {

    @Override
    public EntityModel<Paymentinformation> process(EntityModel<Paymentinformation> model) {

        
        return model;
    }
    
}
