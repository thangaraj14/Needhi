package com.whistle.needhi.repository;

import com.whistle.needhi.model.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
}
