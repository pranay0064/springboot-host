package com.pranay.config;

import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.s3.AmazonS3;

@Configuration
public class AppConfiguration {
    @Bean
    public AmazonS3 getAmazonS3(){

        try {
            AWSCredentialsProvider provider = new DefaultAWSCredentialsProviderChain();
            AWSCredentials credentials = provider.getCredentials();
            if(credentials != null) {
                System.out.println("credentials.getAWSAccessKeyId() = " + credentials.getAWSAccessKeyId());
                System.out.println("credentials.getAWSSecretKey() = " + credentials.getAWSSecretKey());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        BasicAWSCredentials awsCreds = new BasicAWSCredentials("aaaaaaaa", "kkkkkkkk");

        AmazonS3 s3= AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566/","us-west-2"))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withPathStyleAccessEnabled(true)
                .build();
        return s3;
    }
}
