package com.example.jobportal_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jobportal_backend.dto.RecruiterRequest;
import com.example.jobportal_backend.entity.Recruiter;
import com.example.jobportal_backend.repository.RecruiterRepository;
import com.example.jobportal_backend.service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    private final RecruiterService service;
    private final RecruiterRepository recruiterRepository;

    public RecruiterController(RecruiterService service, RecruiterRepository recruiterRepository) {
        this.service = service;
        this.recruiterRepository = recruiterRepository;
    }

    // CREATE RECRUITER
    @PostMapping
    public Recruiter create(@RequestBody RecruiterRequest request) {

        Recruiter recruiter = new Recruiter();
        recruiter.setName(request.getName());
        recruiter.setDescription(request.getDescription());
        recruiter.setLocation(request.getLocation());
        recruiter.setWebsite(request.getWebsite());

        return service.createCompany(recruiter);
    }

    // GET ALL
    @GetMapping
    public List<Recruiter> getAll() {
        return service.getCompanies();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) {

        Optional<Recruiter> recruiter = recruiterRepository.findById(id);

        return recruiter.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Recruiter> updateRecruiter(
            @PathVariable Long id,
            @RequestBody RecruiterRequest request) {

        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);

        if (optionalRecruiter.isPresent()) {

            Recruiter recruiter = optionalRecruiter.get();

            recruiter.setName(request.getName());
            recruiter.setDescription(request.getDescription());
            recruiter.setLocation(request.getLocation());
            recruiter.setWebsite(request.getWebsite());

            recruiterRepository.save(recruiter);

            return ResponseEntity.ok(recruiter);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecruiter(@PathVariable Long id) {

        if (recruiterRepository.existsById(id)) {
            recruiterRepository.deleteById(id);
            return ResponseEntity.ok("Recruiter deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}