package com.home.amit.request;

public class CreateAddressRequest {
	private Long id;
	private String street;
	private String suburb;
	private String state;
	private String postCode;
	private Long contactId;

	public CreateAddressRequest() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return String.format("CreateAddressRequest [street=%s, suburb=%s, state=%s, postCode=%s]", street, suburb,
				state, postCode);
	}
}
