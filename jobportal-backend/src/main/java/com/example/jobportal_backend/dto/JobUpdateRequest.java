package com.example.jobportal_backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class JobUpdateRequest {

    private String title;
    private String description;
    private String location;
    private Double salary;

    private List<Long> skillIds;

}