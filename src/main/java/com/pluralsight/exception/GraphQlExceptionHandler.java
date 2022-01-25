package com.pluralsight.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;

@Component
public class GraphQlExceptionHandler {
	@ExceptionHandler(GraphQLException.class)
	public ThrowableGraphQLError handler(GraphQLException ex) {
		return new ThrowableGraphQLError("Error happened in graphQL resolver");
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ThrowableGraphQLError handler(RuntimeException ex) {
		return new ThrowableGraphQLError("Internal server errror!!");
	}
}
