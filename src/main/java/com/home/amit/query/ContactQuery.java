package com.home.amit.query;

import java.util.List;
import java.util.stream.Collectors;

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

	public ContactResponse contact(long id) {
		var contact = searchService.getContactById(id);
		if (contact == null) {
			return null;
		}
		return new ContactResponse(contact);
	}

	public List<ContactResponse> contactsByLastName(String lastName) {
		var contacts = searchService.getContactsByLastName(lastName);
		var contactResponses = contacts.stream().map(c -> new ContactResponse(c)).collect(Collectors.toList());
		return contactResponses;
	}
}
