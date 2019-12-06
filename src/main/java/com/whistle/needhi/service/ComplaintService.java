package com.whistle.needhi.service;

import com.whistle.needhi.dto.ComplaintDTO;
import com.whistle.needhi.model.Complaint;
import com.whistle.needhi.repository.ComplaintRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    Logger logger = LoggerFactory.getLogger(ComplaintService.class);

    public List<Complaint> getAllComplaints() {
        List<Complaint> complaintList = new ArrayList<>();
        complaintRepository.findAll().forEach(complaintList::add);
        return complaintList;
    }

    public long saveOrUpdate(ComplaintDTO complaintDTO) {
        Complaint complaint = complaintRepository.save(toEntity(complaintDTO));
        return complaint.getId();
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
        complaint.setAttachment(dto.getAttachment());
        complaint.setDate(dto.getDate());
        complaint.setPerson(dto.getPerson());
        return complaint;
    }
}
