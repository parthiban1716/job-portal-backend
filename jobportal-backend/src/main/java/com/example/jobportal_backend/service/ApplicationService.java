package com.example.jobportal_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal_backend.dto.ApplicationRequest;
import com.example.jobportal_backend.entity.Application;
import com.example.jobportal_backend.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;
    private final EmailService emailService;

    public ApplicationService(ApplicationRepository repository,
                              EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    // APPLY JOB
    public Application apply(ApplicationRequest request) {

        Application application = new Application();

        application.setUserId(request.getUserId());
        application.setJobId(request.getJobId());
        application.setStatus(request.getStatus());

        Application savedApplication = repository.save(application);

        // 📧 SEND EMAIL TO RECRUITER
        String recruiterEmail = "recruiter@email.com"; // later DB-லிருந்து fetch பண்ணலாம்

        emailService.sendApplicationEmail(
                recruiterEmail,
                "Candidate " + request.getUserId(),
                "Job ID " + request.getJobId()
        );

        return savedApplication;
    }

    // GET ALL APPLICATIONS
    public List<Application> getApplications() {
        return repository.findAll();
    }

    // GET APPLICANTS BY JOB
    public List<Application> getApplicantsByJob(Long jobId) {
        return repository.findByJobId(jobId);
    }

    // UPDATE STATUS
    public Application updateStatus(Long id, String status) {

        Application application = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));

        application.setStatus(status);

        return repository.save(application);
    }
}