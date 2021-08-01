package com.home.amit.response;

import com.home.amit.model.Phone;

public record PhoneResponse(Long id, String phoneType, String phoneNumber) {
	public PhoneResponse(Phone phone) {
		this(phone.getId(), phone.getPhoneType(), phone.getPhoneNumber());
	}
}
