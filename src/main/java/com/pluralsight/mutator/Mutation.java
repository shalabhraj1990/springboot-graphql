package com.pluralsight.mutator;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.entity.Application;
import com.pluralsight.entity.BankAccount;
import com.pluralsight.entity.CreateBankAccountRequest;
import com.pluralsight.exception.CustomeGraphQLError;
import com.pluralsight.repository.ApplicationRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
	private ApplicationRepository applicationRepository;

	public BankAccount createBankAccount(CreateBankAccountRequest request) {
		return BankAccount.builder().id(UUID.randomUUID()).build();
	}

	public Mutation(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public Application newApplication(String name, String owner, String description) {
		Application app = new Application(name, owner, description);
		applicationRepository.save(app);
		return app;
	}

	public boolean deleteApplication(Long id) {
		applicationRepository.deleteById(id);
		return true;
	}

	public Application updateApplicationOwner(String newOwner, Long id) {
		Optional<Application> optionalApplication = applicationRepository.findById(id);

		if (optionalApplication.isPresent()) {
			Application application = optionalApplication.get();
			application.setOwner(newOwner);
			applicationRepository.save(application);
			return application;
		} else {
			throw new CustomeGraphQLError("Application Not Found", id);
		}
	}
}
