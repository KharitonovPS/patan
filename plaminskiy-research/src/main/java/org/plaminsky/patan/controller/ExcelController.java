package org.plaminsky.patan.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.plaminsky.patan.service.ExcelProcessingService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ExcelController {

    private final ExcelProcessingService service;

    @GetMapping()
    public ResponseEntity<byte[]> loadMigrationPage() {
        byte[] content = UPLOAD_FORM_HTML.getBytes();

        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_TYPE, "text/html");

        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        log.info("Uploading file: {}", file.getOriginalFilename());
        return service.uploadExcel(file);
    }

    static final String UPLOAD_FORM_HTML = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8">
            <title>ms-auth миграция</title>
            <style>
                body {
                    background: #ccc;
                    padding-top: 50px;
                }

                .example {
                    width: 760px;
                    background: #fff;
                    border: 1px solid #666;
                    padding: 20px;
                    margin: 10px auto;
                }

                input[type=file] {
                    width: 100%;
                    padding: 12px 20px;
                    margin: 8px 0;
                    display: inline-block;
                    border: 1px solid #ccc;
                    border-radius: 4px;
                    box-sizing: border-box;
                }

                input[type=submit] {
                    width: 100%;
                    background-color: #4CAF50;
                    color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                }

                input[type=submit]:hover {
                    background-color: #45a049;
                }
            </style>
        </head>
        <body>
        <div class="example">
            <h2>Загрузить файл для базы данных (xlsx)</h2>
            <form action="/upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file" id="file">
                <input type="submit" value="Загрузить файл" name="submit">
            </form>
        </div>
        
        </body>
        </html>
        """;

}
