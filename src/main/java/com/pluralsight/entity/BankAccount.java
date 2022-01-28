package com.pluralsight.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
public class BankAccount {
	private UUID id;
	private Client client;
	private Currency currency;
	private LocalDate createdOn;
	private ZonedDateTime createdAt;
}

