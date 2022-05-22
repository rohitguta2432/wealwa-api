package com.api.wealthwa.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.api.wealthwa.exception.WealthwaException;
import com.api.wealthwa.model.Contents;
import com.api.wealthwa.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AwsServiceImpl implements AwsService {

    @Value("${wealth.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private ContentRepository contentRepository;

    @Value("${goblin.s3.endpointUrl}")
    private String endPointUrl;

    @Override
    public void uploadImage(MultipartFile file, Contents contents) {
        log.info("upload to s3 [{}]");
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            amazonS3.putObject(new PutObjectRequest(bucketName, contents.getContentId() + File.separator + file.getOriginalFilename(), file.getInputStream(), objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));

            contents.setImgUrl(fileUrl(endPointUrl, bucketName, contents.getContentId().toString(), file.getOriginalFilename()));

            contentRepository.save(contents);
        } catch (AmazonS3Exception | IOException e) {
            throw new WealthwaException("Failed to upload the file ", e);
        }
    }

    private String fileUrl(String endpointUrl, String bucketName, String folderName, String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(endpointUrl);
        sb.append("/");
        sb.append(bucketName);
        sb.append("/");
        sb.append(folderName);
        sb.append("/");
        sb.append(fileName);
        return sb.toString();
    }

}
