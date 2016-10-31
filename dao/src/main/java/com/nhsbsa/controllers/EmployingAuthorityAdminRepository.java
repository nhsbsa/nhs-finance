package com.nhsbsa.controllers;

import com.nhsbsa.model.EmployingAuthorityAdmin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Mark Lishman on 31/10/2016.
 */

@RepositoryRestResource(collectionResourceRel = "employingAuthorityAdmin", path = "employingAuthorityAdmin")
public interface EmployingAuthorityAdminRepository extends PagingAndSortingRepository<EmployingAuthorityAdmin, Long> {
    EmployingAuthorityAdmin findByUsername(String username);

    EmployingAuthorityAdmin findById(Long id);

    EmployingAuthorityAdmin findByUuid(String uuid);
}