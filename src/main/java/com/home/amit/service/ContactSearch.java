package com.home.amit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.amit.dao.ContactRepository;
import com.home.amit.model.Contact;

@Service
public class ContactSearch {

	ContactRepository contactRepository;
	
	@Autowired
	public ContactSearch(ContactRepository repo) {
		this.contactRepository = repo;
	}
	
	public Contact getContactById(long id) {
		return contactRepository.findById(id).orElse(null);
	}
	
	public List<Contact> getContactsByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName).get();
	}
	
	public List<Contact> getContactsByLastName(String lastName) {
		return contactRepository.findByLastName(lastName).get();
	}
}
