package com.pluralsight.bankaccount.resolver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pluralsight.entity.BankAccount;
import com.pluralsight.entity.Client;

import graphql.GraphQLError;
import graphql.execution.DataFetcherResult;
import graphql.servlet.GenericGraphQLError;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    private final ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount) {
        System.out.println("BankAccount :" + bankAccount.toString());
        // throw new RuntimeException("cleint not found");
        // return ;
        // return new DataFetcherResult<>(data, errors, localContext);
        return CompletableFuture.supplyAsync(() -> {
            Client data = Client.builder().firstName("shalabh").lastName("raj").build();
            GenericGraphQLError error = new GenericGraphQLError("middle name not found");
            List<GraphQLError> errorList = new ArrayList<GraphQLError>();
            errorList.add(error);

            DataFetcherResult<Client> result = new DataFetcherResult<Client>(data, errorList);
            return result;
        }, es);

    }
}
