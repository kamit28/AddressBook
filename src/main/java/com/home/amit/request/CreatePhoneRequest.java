package com.home.amit.request;

public class CreatePhoneRequest {
	private String phoneType;
	private String phoneNumber;

	public CreatePhoneRequest() {
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return String.format("CreatePhoneRequest [phoneType=%s, phoneNumber=%s]", phoneType, phoneNumber);
	}
}
