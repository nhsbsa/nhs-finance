package com.nhsbsa.repos;

import com.nhsbsa.reports.rft1.RFT1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * Created by mhood on 16/11/2016.
 *
 */

@RepositoryRestResource(collectionResourceRel = "rft1_file", path = "rft1_file")
public interface RFT1Repository extends JpaRepository<RFT1, Long> {
    RFT1 findByCsvFileID(int csvFileID);
}
