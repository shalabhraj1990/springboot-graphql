package com.pluralsight.entity;

import lombok.Data;

@Data
public class CreateBankAccountRequest {
    private String firstName;
    private int age;
}
