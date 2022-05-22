package com.api.wealthwa.service;

import com.api.wealthwa.model.Contents;
import org.springframework.web.multipart.MultipartFile;

public interface AwsService {
    void uploadImage(MultipartFile file, Contents contents);
}
