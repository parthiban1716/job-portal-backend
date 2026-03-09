package com.example.jobportal_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobportal_backend.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
