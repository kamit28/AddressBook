package com.home.amit.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.home.amit.response.ContactResponse;
import com.home.amit.service.ContactSearch;

@Component
public class ContactQuery implements GraphQLQueryResolver {

	private ContactSearch searchService;

	@Autowired
	public ContactQuery(ContactSearch service) {
		this.searchService = service;
	}

	public String firstQuery() {
		return "First ContactQuery Result";
	}

	public ContactResponse contact(long id) {
		return new ContactResponse(searchService.getContactById(id));
	}

}
