package com.pluralsight.entity;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class BankAccount {
	private UUID id;
	private Client client;
	private Currency currency;
}

