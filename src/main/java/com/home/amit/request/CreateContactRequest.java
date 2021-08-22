package com.home.amit.request;

import java.util.List;

public class CreateContactRequest {
	private Long id;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String email;
	private CreateAddressRequest address;
	private List<CreatePhoneRequest> phones;

	public CreateContactRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CreateAddressRequest getAddress() {
		return address;
	}

	public void setAddress(CreateAddressRequest address) {
		this.address = address;
	}

	public List<CreatePhoneRequest> getPhones() {
		return phones;
	}

	public void setPhones(List<CreatePhoneRequest> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return String.format(
				"CreateContactRequest [firstName=%s, lastName=%s, birthDate=%s, email=%s, address=%s, phones=%s]",
				firstName, lastName, birthDate, email, address, phones);
	}
}
