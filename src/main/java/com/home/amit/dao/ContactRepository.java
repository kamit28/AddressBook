package com.home.amit.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.amit.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	Optional<Contact> findByFirstName(String firstName);
}
