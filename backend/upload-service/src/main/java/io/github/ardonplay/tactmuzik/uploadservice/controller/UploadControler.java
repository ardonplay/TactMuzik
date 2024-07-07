package io.github.ardonplay.tactmuzik.uploadservice.controller;

import io.github.ardonplay.tactmuzik.uploadservice.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.apache.tika.exception.TikaException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class UploadControler {

    private final UploadService uploadService;

    @PostMapping()
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
            uploadService.upload(file);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
