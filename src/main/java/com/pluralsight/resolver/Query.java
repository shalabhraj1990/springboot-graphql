package com.pluralsight.resolver;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.entity.Application;
import com.pluralsight.entity.BankAccount;
import com.pluralsight.entity.Client;
import com.pluralsight.entity.Currency;
import com.pluralsight.repository.ApplicationRepository;

@Component
public class Query implements GraphQLQueryResolver {
	private ApplicationRepository applicationRepository;

	public Query(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public Iterable<Application> findAllApplications() {
		return applicationRepository.findAll();
	}

	public long countApplications() {

		return applicationRepository.count();
	}

	public BankAccount bankAccount(UUID id) {

		return BankAccount.builder().id(id).currency(Currency.CHF)
				.build();
	}
}
