package com.api.wealthwa.service;

import com.api.wealthwa.exception.WealthwaException;
import com.api.wealthwa.model.Contents;
import com.api.wealthwa.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AwsService awsService;

    @Override
    public Map<String, String> create(Contents contents, MultipartFile file) {
        log.info("create content {}", contents);

        if (ObjectUtils.isEmpty(contents)) {
            throw new WealthwaException("mandatory fields cannot be null or empty");
        }

        Map<String, String> map = new HashMap<>();

        if (ObjectUtils.isEmpty(file)) {
            throw new WealthwaException("images cannot be null");
        }

        Contents content = contentRepository.save(contents);

        awsService.uploadImage(file, content);
        map.put("msg", "contents created successfull");

        return map;
    }

    @Override
    public List<Contents> getAllContents() {
        return contentRepository.findAll().stream()
                .peek(c -> c.setCategoryName(categoryService.getCategoryById(c.getCategoryId()).get().getName())).collect(Collectors.toList());
    }

}
