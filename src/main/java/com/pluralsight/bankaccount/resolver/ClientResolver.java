package com.pluralsight.bankaccount.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pluralsight.entity.BankAccount;
import com.pluralsight.entity.Client;

import graphql.GraphQLException;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
	public Client client(BankAccount bankAccount) {
		System.out.println("BankAccount :" + bankAccount.toString());
		throw new RuntimeException("cleint not found");
		//return Client.builder().firstName("shalabh").lastName("raj").build();
	}
}
