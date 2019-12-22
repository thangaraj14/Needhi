package com.whistle.needhi.controller;

import com.whistle.needhi.dto.ComplaintDTO;
import com.whistle.needhi.model.Complaint;
import com.whistle.needhi.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ComplaintController {

    private static final String URL_PREFIX = "/v1/Complaint";
    private static final String COMPLAINT_ID = "/{ComplaintID}";

    @Autowired
    ComplaintService complaintService;

    @GetMapping(value = URL_PREFIX)
    @ResponseStatus(HttpStatus.OK)
    public List<Complaint> getAllComplaints(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return complaintService.getAllComplaints(pageNo, pageSize);
    }

    @GetMapping(value = URL_PREFIX + COMPLAINT_ID)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Complaint> getComplaintById(@PathVariable("ComplaintID") long id) {
        return complaintService.getComplaint(id);
    }

    @DeleteMapping(value = URL_PREFIX + COMPLAINT_ID)
    @ResponseStatus(HttpStatus.OK)
    public void deleteComplaint(@PathVariable("ComplaintID") long id) {
        complaintService.delete(id);
    }

    @PostMapping(value = URL_PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus saveComplaint(@RequestBody ComplaintDTO complaintDTO) {
        return complaintService.saveOrUpdate(complaintDTO);
    }

    @PutMapping(value = URL_PREFIX + COMPLAINT_ID)
    public HttpStatus updatePost(@PathVariable Long complaintId, @Valid @RequestBody Complaint postRequest) {
        return complaintService.updatePost(complaintId,postRequest);
    }
}
