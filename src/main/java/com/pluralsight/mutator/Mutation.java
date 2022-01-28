package com.pluralsight.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.entity.Application;
import com.pluralsight.entity.BankAccount;
import com.pluralsight.entity.CreateBankAccountRequest;
import com.pluralsight.exception.CustomeGraphQLError;
import com.pluralsight.repository.ApplicationRepository;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private Clock clock;

    public BankAccount createBankAccount(CreateBankAccountRequest request, DataFetchingEnvironment env) {
        System.out.println(env.toString());
        return BankAccount.builder().id(UUID.randomUUID()).createdAt(ZonedDateTime.now(clock)).createdOn(LocalDate.now(clock)).build();
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

    public UUID uploadFile(DataFetchingEnvironment env) {
//		GraphQLContext context = env.getContext();
//		context.getFiles().stream().forEach(file -> {
//			List<Part> parts = file.get(0);
//			parts.forEach(part -> {
//
//				log.info("uploading {} size {}", part.getSubmittedFileName(), part.getSize());
//
//			});
//
//		});

        return UUID.randomUUID();
    }
}
