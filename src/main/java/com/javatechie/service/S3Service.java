package com.javatechie.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class S3Service {

    @Autowired
    AmazonS3 amazonS3;

    public String createBucket(String name){
        if(!amazonS3.doesBucketExistV2(name)){
            amazonS3.createBucket(name);
        }
        return name;
    }

    public String deleteBucket(String name){
        if(amazonS3.doesBucketExistV2(name)){
            amazonS3.deleteBucket(name);
        }
        return name;
    }

    public String uploadFile(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        amazonS3.putObject(new PutObjectRequest("test1", fileName, fileObj));
        fileObj.delete();
        return "File uploaded : " + fileName;
    }

    public byte[] downloadFile(String fileName) {
        S3Object s3Object = amazonS3.getObject("test1", fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return convertedFile;
    }
}