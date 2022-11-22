package eduis.domain;

import eduis.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="noticeInfos", path="noticeInfos")
public interface NoticeInfoRepository extends PagingAndSortingRepository<NoticeInfo, String>{

}
