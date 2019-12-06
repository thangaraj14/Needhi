package com.whistle.needhi.controller;

import com.whistle.needhi.dto.ComplaintDTO;
import com.whistle.needhi.model.Complaint;
import com.whistle.needhi.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ComplaintController {

    private static final String URL_PREFIX = "/v1/Complaint";
    private static final String COMPLAINT_ID = "/{ComplaintID}";

    @Autowired
    ComplaintService complaintService;

    @GetMapping(value = URL_PREFIX)
    @ResponseStatus(HttpStatus.OK)
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
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
    public ResponseEntity<Map<String, URI>> saveComplaint(@RequestBody ComplaintDTO complaintDTO) {
        long complaintId = complaintService.saveOrUpdate(complaintDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(COMPLAINT_ID).buildAndExpand(complaintId)
                .toUri();
        return ResponseEntity.created(location)
                .body(Collections.singletonMap("Complaint successfully got created", location));
    }
}
