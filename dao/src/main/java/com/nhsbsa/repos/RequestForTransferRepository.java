package com.nhsbsa.repos;

import com.nhsbsa.model.RequestForTransfer;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Mark Lishman on 7/11/2016.
 *
 */

public interface RequestForTransferRepository extends PagingAndSortingRepository<RequestForTransfer, Long> {
    public RequestForTransfer findByRftUuid (String rftUuid);

}
