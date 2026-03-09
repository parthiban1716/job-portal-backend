package com.example.jobportal_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendApplicationEmail(String recruiterEmail,
                                     String candidateName,
                                     String jobTitle){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(recruiterEmail);
        message.setSubject("New Job Application");

        message.setText(
                "Hello Recruiter,\n\n" +
                "Candidate " + candidateName +
                " applied for the job: " + jobTitle +
                "\n\nCheck your job portal for details."
        );

        mailSender.send(message);
    }
}