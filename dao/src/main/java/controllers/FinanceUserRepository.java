package controllers;

import com.nhsbsa.model.FinanceUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by jeffreya on 16/08/2016.
 *
 */

@RepositoryRestResource(collectionResourceRel = "finance_user", path = "finance_user")
public interface FinanceUserRepository extends PagingAndSortingRepository<FinanceUser, Long> {

    FinanceUser findByUuid(String uuid);
}
