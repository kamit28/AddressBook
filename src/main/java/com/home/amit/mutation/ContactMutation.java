package com.home.amit.mutation;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.home.amit.request.CreateAddressRequest;
import com.home.amit.request.CreateContactRequest;
import com.home.amit.response.AddressResponse;
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

	public ContactResponse updateContact(CreateContactRequest request) {
		ContactResponse response = null;
		try {
			var contact = mutationService.updateContact(request);
			if (contact.isPresent()) {
				response = new ContactResponse(contact.get());
			}
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Error in Saving Contact data: ", e);
		}
		return response;
	}

	public boolean deleteContact(Long id) {
		return mutationService.deleteContact(id);
	}

	public AddressResponse updateAddress(CreateAddressRequest request) {
		var address = mutationService.updateAddress(request);
		return address.isPresent() ? new AddressResponse(address.get()) : null;
	}

	public boolean deleteAddress(Long contactId) {
		return mutationService.deleteAddress(contactId);
	}

}
