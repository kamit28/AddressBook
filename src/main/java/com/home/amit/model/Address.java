package com.home.amit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name="address_generator", sequenceName = "address_seq", allocationSize=1)
	@Column(name = "id")
	private Long Id;

	private String street;
	private String suburb;
	private String state;
	private String postCode;

	@OneToOne(mappedBy = "address")
	private Contact owner;

	public Address() {
	}

	public Address(String street, String suburb, String state, String postCode) {
		this.street = street;
		this.suburb = suburb;
		this.state = state;
		this.postCode = postCode;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * @param suburb
	 *            the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
