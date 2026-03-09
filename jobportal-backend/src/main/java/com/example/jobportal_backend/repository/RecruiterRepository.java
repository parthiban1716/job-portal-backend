package com.example.jobportal_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal_backend.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
}