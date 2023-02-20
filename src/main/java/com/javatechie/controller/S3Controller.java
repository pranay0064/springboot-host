package com.javatechie.controller;

import com.javatechie.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/localstack")
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @PostMapping(value="create",consumes = {"application/json"})
    public String createBucket(@RequestParam(name="bucketName") String bucketName){
        System.out.println("bucketName = " + bucketName);
        s3Service.createBucket(bucketName);
        return "succesfully created bucket";
    }

    @DeleteMapping(value="delete",consumes = {"application/json"})
    public String deleteBucket(@RequestParam(name="bucketName") String bucketName){
        s3Service.deleteBucket(bucketName);
        return "succesfully deleted bucket";
    }
    @GetMapping("/download/{fileName}")
    public ByteArrayResource downloadFile(@PathVariable String fileName) {
        byte[] data = s3Service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return resource;
    }


    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return s3Service.uploadFile(file);
    }
}
