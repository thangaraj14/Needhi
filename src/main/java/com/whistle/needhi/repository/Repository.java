package com.whistle.needhi.repository;

import com.whistle.needhi.model.Complaint;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface Repository extends PagingAndSortingRepository<Complaint, Long> {
    List<Complaint> findTop50ByOrderByIdDesc();
}