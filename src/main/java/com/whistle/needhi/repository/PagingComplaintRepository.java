package com.whistle.needhi.repository;

import com.whistle.needhi.model.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thanga
 */

@Repository
public interface PagingComplaintRepository extends PagingAndSortingRepository<Complaint, Long> {

}
