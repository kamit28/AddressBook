package com.home.amit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
	@SequenceGenerator(name = "contact_generator", sequenceName = "contact_seq", allocationSize = 1)
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;

	@OneToMany(mappedBy = "contact", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Phone> phones;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	public Contact() {
		this.birthDate = new Date();
	}

	public Contact(String firstName, String lastName, Date birthDate, String email, String phone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.address = address;
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

	@JsonSerialize(using = DateSerializer.class)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		if (phones == null) {
			phones = new ArrayList<>();
		}
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		if (this.phones == null) {
			this.phones = new ArrayList<>();
		}

		if (!CollectionUtils.isEmpty(phones)) {
			this.phones.addAll(phones);
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}