package com.home.amit.response;

import java.text.SimpleDateFormat;
import java.util.List;

import com.home.amit.model.Contact;

public record ContactResponse(Long id, 
		String firstName, 
		String lastName,
		String fullName,
		String birthDate, 
		String email,
		List<PhoneResponse> phones,
		AddressResponse address,
		Contact contact) {

	private static final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	public ContactResponse(Contact contact) {
		this(
				contact.getId(),
				contact.getFirstName(),
				contact.getLastName(),
				contact.getFirstName() + " " + contact.getLastName(),
				df.format(contact.getBirthDate()),
				contact.getEmail(),
				null,
				new AddressResponse(contact.getAddress()),
				contact
		);
	}
}
