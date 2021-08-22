package com.home.amit.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.amit.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	Optional<Address> findByOwnerFirstName(String firstName);
	Optional<Address> findByOwnerId(Long id);
}
