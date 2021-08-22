package com.home.amit.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.home.amit.dao.AddressRepository;
import com.home.amit.dao.ContactRepository;
import com.home.amit.dao.PhoneRepository;
import com.home.amit.model.Address;
import com.home.amit.model.Contact;
import com.home.amit.model.Phone;
import com.home.amit.request.CreateAddressRequest;
import com.home.amit.request.CreateContactRequest;
import com.home.amit.request.CreatePhoneRequest;

@Service
public class ContactMutationService {

	private ContactRepository contactRepository;
	private AddressRepository addressRepository;
	private PhoneRepository phoneRepository;

	private static final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	public ContactMutationService(ContactRepository contactRepository, AddressRepository addressRepository,
			PhoneRepository phoneRepository) {
		this.contactRepository = contactRepository;
		this.addressRepository = addressRepository;
		this.phoneRepository = phoneRepository;
	}

	public Contact createContact(CreateContactRequest request) throws ParseException {
		Contact contact = new Contact();
		contact.setFirstName(request.getFirstName());
		contact.setLastName(request.getLastName());
		contact.setBirthDate(df.parse(request.getBirthDate()));
		contact.setEmail(request.getEmail());
		Address address = new Address();
		address.setStreet(request.getAddress().getStreet());
		address.setSuburb(request.getAddress().getSuburb());
		address.setState(request.getAddress().getState());
		address.setPostCode(request.getAddress().getPostCode());
		address = addressRepository.save(address);
		contact.setAddress(address);
		final Contact savedContact = contactRepository.save(contact);
		List<Phone> phones = new ArrayList<>();
		if (!CollectionUtils.isEmpty(request.getPhones())) {
			phones = request.getPhones().stream().map(p -> toPhone.apply(p, savedContact)).collect(Collectors.toList());

			phoneRepository.saveAll(phones);
		}
		savedContact.setPhones(phones);
		return savedContact;
	}

	public Optional<Contact> updateContact(CreateContactRequest request) throws ParseException {
		Optional<Contact> contact = contactRepository.findById(request.getId());
		Contact c = null;
		if (contact.isPresent()) {
			c = contact.get();
			if (request.getBirthDate() != null) {
				c.setBirthDate(df.parse(request.getBirthDate()));
			}
			c.setEmail(request.getEmail());
			c = contactRepository.saveAndFlush(c);
		}
		return Optional.ofNullable(c);
	}

	public boolean deleteContact(Long contactId) {
		Optional<Contact> contact = contactRepository.findById(contactId);
		if (contact.isPresent()) {
			contactRepository.delete(contact.get());
			return true;
		}
		return false;
	}

	public Optional<Address> updateAddress(CreateAddressRequest request) {
		Optional<Address> address = addressRepository.findByOwnerId(request.getContactId());
		Address a = null;
		if (address.isPresent()) {
			a = address.get();
			a.setStreet(request.getStreet());
			a.setSuburb(request.getSuburb());
			a.setState(request.getState());
			a.setPostCode(request.getPostCode());
			a = addressRepository.saveAndFlush(a);
		}
		return Optional.ofNullable(a);
	}

	public boolean deleteAddress(Long contactId) {
		Optional<Address> address = addressRepository.findByOwnerId(contactId);
		if (address.isPresent()) {
			addressRepository.delete(address.get());
			return true;
		}
		return false;
	}

	private BiFunction<CreatePhoneRequest, Contact, Phone> toPhone = (request, contact) -> {
		Phone phone = new Phone();
		phone.setPhoneType(request.getPhoneType());
		phone.setPhoneNumber(request.getPhoneNumber());
		phone.setContact(contact);
		return phone;
	};
}
