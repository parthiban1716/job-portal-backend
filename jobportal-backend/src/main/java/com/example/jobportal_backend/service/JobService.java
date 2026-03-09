package com.example.jobportal_backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.jobportal_backend.dto.JobRequest;
import com.example.jobportal_backend.entity.Job;
import com.example.jobportal_backend.entity.Skill;
import com.example.jobportal_backend.repository.JobRepository;
import com.example.jobportal_backend.repository.SkillRepository;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;

    public JobService(JobRepository jobRepository, SkillRepository skillRepository) {
        this.jobRepository = jobRepository;
        this.skillRepository = skillRepository;
    }

    // CREATE JOB
    public Job postJob(JobRequest request) {

        List<Skill> skills = skillRepository.findAllById(request.getSkillIds());

        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setExperience(request.getExperience());
        job.setSkills(skills);

        return jobRepository.save(job);
    }

    // GET ALL JOBS
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    // GET JOB BY ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    // UPDATE JOB
    public Job updateJob(Long id, JobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setExperience(request.getExperience());

        List<Skill> skills = skillRepository.findAllById(request.getSkillIds());
        job.setSkills(skills);

        return jobRepository.save(job);
    }

    // DELETE JOB
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // PAGINATION
    public Page<Job> getJobsWithPagination(int page, int size, String sortBy) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return jobRepository.findAll(pageable);
    }

    // SORT JOBS
    public List<Job> sortJobs(String field) {

        return jobRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // SEARCH JOB
    public List<Job> searchJobs(String keyword) {

        return jobRepository.findByTitleContainingIgnoreCase(keyword);
    }

    // FILTER JOB
    public List<Job> filterJobs(String location, Double salary) {

        return jobRepository.findByLocationAndSalary(location, salary);
    }

    // JOBS BY SKILL
    public List<Job> getJobsBySkill(String skill) {

        return jobRepository.findBySkillsName(skill);
    }
}