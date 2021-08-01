package com.home.amit.resolver;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.home.amit.response.ContactResponse;
import com.home.amit.response.PhoneResponse;

@Service
public class ContactResponseResolver implements GraphQLResolver<ContactResponse> {

	public List<PhoneResponse> getPhones(ContactResponse contactResponse, String phoneType) {
		List<PhoneResponse> phoneResponses = contactResponse.contact().getPhones()
		.stream()
		.filter(p -> phoneType == null || phoneType.isBlank() || p.getPhoneType().equals(phoneType))
		.map(PhoneResponse::new)
		.collect(Collectors.toList());
		
		return phoneResponses;
	}

	public String getFullName(ContactResponse contactResponse) {
		return contactResponse.firstName() + " " + contactResponse.lastName();
	}
}
