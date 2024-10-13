package org.plaminsky.research.controller;

import lombok.RequiredArgsConstructor;
import org.plaminsky.research.service.ExcelProcessingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/upload")
public class ExcelController {

    private final ExcelProcessingService service;

    @PostMapping
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        return service.uploadExcel(file);
    }
}
