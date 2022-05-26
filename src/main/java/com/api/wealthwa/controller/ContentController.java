package com.api.wealthwa.controller;

import com.api.wealthwa.model.Contents;
import com.api.wealthwa.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 12/05/22
 **/
@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestPart(required = true) UUID categoryId,
                                    @RequestPart(required = true) String description,
                                    @RequestPart MultipartFile file) {
        return new ResponseEntity<>(contentService.create(new Contents(categoryId, description), file), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllContents() {
        return new ResponseEntity<>(contentService.getAllContents(), HttpStatus.OK);
    }
}
