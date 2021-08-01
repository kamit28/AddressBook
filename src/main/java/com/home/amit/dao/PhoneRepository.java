package com.home.amit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.amit.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
