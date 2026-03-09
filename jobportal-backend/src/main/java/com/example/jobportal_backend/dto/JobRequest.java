package com.example.jobportal_backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class JobRequest {

    private String title;
    private String description;
    private String location;
    private Double salary;
    private Integer experience;

    // Skill IDs
    private List<Long> skillIds;
}