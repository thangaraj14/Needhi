package com.whistle.needhi.service;

import com.whistle.needhi.dto.ComplaintDTO;
import com.whistle.needhi.model.Complaint;
import com.whistle.needhi.repository.ComplaintRepository;
import com.whistle.needhi.repository.PagingComplaintRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    PagingComplaintRepository repository;

    Logger logger = LoggerFactory.getLogger(ComplaintService.class);

    public List<Complaint> getAllComplaints(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        // repository.findTop50ByOrderByIdDesc().forEach(complaintList::add);

        Page<Complaint> pagedResult = repository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public HttpStatus saveOrUpdate(ComplaintDTO complaintDTO) {
        Complaint complaint = complaintRepository.save(toEntity(complaintDTO));
        if (complaint != null) {
            return HttpStatus.CREATED;
        }
        return HttpStatus.BAD_REQUEST;
    }

    public Optional<Complaint> getComplaint(long id) {
        return complaintRepository.findById(id);
    }

    public void delete(long id) {
        complaintRepository.deleteById(id);
    }

    private Complaint toEntity(ComplaintDTO dto) {
        Complaint complaint = new Complaint();
        complaint.setDescription(dto.getDescription());
        complaint.setStatus(dto.getStatus());
        complaint.setLocation(dto.getLocation());
        complaint.setPlace(dto.getPlace());
        complaint.setImage(dto.getImage());
        complaint.setDate(dto.getDate());
        complaint.setPerson(dto.getPerson());
        return complaint;
    }

    public HttpStatus updatePost(Long complaintId, Complaint postRequest) {
        Optional<Complaint> complaint = complaintRepository.findById(complaintId).map(post -> {
            post.setDescription(postRequest.getDescription());
            post.setPlace(postRequest.getPlace());
            post.setLikes(postRequest.getLikes());
            post.setLocation(postRequest.getLocation());
            return complaintRepository.save(post);
        });
        if (complaint != null) {
            return HttpStatus.ACCEPTED;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}