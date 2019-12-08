package com.whistle.needhi.repository;

import com.whistle.needhi.model.Complaint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComplaintRepository extends CrudRepository<Complaint, Long> {
    List<Complaint> findTop2ByOrderByIdDesc();
}
