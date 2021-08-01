package com.home.amit.mutation;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.home.amit.request.CreateContactRequest;
import com.home.amit.response.ContactResponse;
import com.home.amit.service.ContactMutationService;

@Service
public class ContactMutation implements GraphQLMutationResolver {

	private static final Logger log = Logger.getLogger(ContactMutation.class.getName());

	private ContactMutationService mutationService;

	@Autowired
	public ContactMutation(ContactMutationService service) {
		this.mutationService = service;
	}

	public ContactResponse createContact(CreateContactRequest request) {
		ContactResponse response = null;
		try {
			response = new ContactResponse(mutationService.createContact(request));

		} catch (ParseException e) {
			log.log(Level.SEVERE, "Error in Saving Contact data: ", e);
		}
		return response;
	}
}
