package eduis.infra;

import eduis.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderDetailLists", path="orderDetailLists")
public interface OrderDetailListRepository extends PagingAndSortingRepository<OrderDetailList, Long> {

    

    
}
