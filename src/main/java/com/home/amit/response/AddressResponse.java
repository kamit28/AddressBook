package com.home.amit.response;

import com.home.amit.model.Address;

public record AddressResponse(String street, String suburb, String state, String postCode) {
	public AddressResponse(Address address) {
		this(address.getStreet(), address.getSuburb(), address.getState(), address.getPostCode());
	}
}
