package com.pluralsight.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@Component
public class CustomeGraphQLErrorHandler implements GraphQLErrorHandler {

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		List<CustomeGraphQLError> errorMessageList = errors.stream().map(error -> new CustomeGraphQLError(error.getMessage(),1001L))
				.collect(Collectors.toList());
		return errors;
	}

}
