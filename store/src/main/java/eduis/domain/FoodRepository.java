package eduis.domain;

import eduis.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="foods", path="foods")
public interface FoodRepository extends PagingAndSortingRepository<Food, String>{

}
