package com.example.jobportal_backend.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobportal_backend.repository.ApplicationRepository;
import com.example.jobportal_backend.repository.JobRepository;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/stats")
    public Map<String, Long> getDashboardStats() {

        long totalJobs = jobRepository.count();
        long totalApplicants = applicationRepository.count();
        long selectedCandidates = applicationRepository.countByStatus("SELECTED");

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalJobs", totalJobs);
        stats.put("totalApplicants", totalApplicants);
        stats.put("selectedCandidates", selectedCandidates);

        return stats;
    }
}
