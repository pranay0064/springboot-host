package com.javatechie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UsersRequest {
    private String name;
    private String email;
    private String location;
}
