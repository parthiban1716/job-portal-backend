package com.example.jobportal_backend.dto;

import lombok.Data;

@Data
public class RecruiterRequest {

    private String name;
    private String description;
    private String location;
    private String website;

}