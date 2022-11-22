package eduis.domain;

import eduis.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="paymentinformations", path="paymentinformations")
public interface PaymentinformationRepository extends PagingAndSortingRepository<Paymentinformation, String>{

}
