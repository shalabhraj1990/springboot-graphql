package com.pluralsight.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
	String firstName;
	List<String> middleName;
	String lastName;
}
