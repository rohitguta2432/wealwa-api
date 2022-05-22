package com.api.wealthwa.service;

import com.api.wealthwa.model.Contents;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ContentService {
    Map<String, String> create(Contents contents, MultipartFile file);
    List<Contents> getAllContents();
}
