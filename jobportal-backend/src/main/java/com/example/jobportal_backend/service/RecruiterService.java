package com.example.jobportal_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jobportal_backend.entity.Recruiter;
import com.example.jobportal_backend.repository.RecruiterRepository;

@Service
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    public Recruiter createCompany(Recruiter company) {
        return recruiterRepository.save(company);
    }

    public List<Recruiter> getCompanies() {
        return recruiterRepository.findAll();
    }
}
