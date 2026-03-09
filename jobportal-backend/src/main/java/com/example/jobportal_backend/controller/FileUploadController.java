package com.example.jobportal_backend.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.jobportal_backend.util.FileUploadUtil;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    // Resume Upload API
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String uploadResume(@RequestParam("file") MultipartFile file) throws IOException {

        String uploadDir = "uploads/resumes";

        String fileName = FileUploadUtil.uploadFile(uploadDir, file);

        return "File uploaded successfully: " + fileName;
    }

    // Resume Download API
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadResume(@PathVariable String fileName) throws IOException {

        Path filePath = Paths.get("uploads/resumes").resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if(!resource.exists()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewResume(@PathVariable String fileName) {

        try {

            Path path = Paths.get("uploads/resumes").resolve(fileName);
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists()) {

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }

            return ResponseEntity.notFound().build();

        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }
    }
}