package com.example.jobportal_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal_backend.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	 List<Application> findByJobId(Long jobId);
	 long countByJobId(Long jobId);
	long countByStatus(String string);
}