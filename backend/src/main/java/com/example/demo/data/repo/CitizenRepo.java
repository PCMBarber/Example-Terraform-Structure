package com.example.demo.data.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Gender;
import com.example.demo.data.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long> {

	List<Citizen> findByForenameIgnoreCase(String forename);

	List<Citizen> findBySurnameIgnoreCase(String surname);

	List<Citizen> findByAddressIgnoreCase(String address);

	List<Citizen> findByPOBIgnoreCase(String placeOfBirth);

	List<Citizen> findByGenderIgnoreCase(Gender gender);

	List<Citizen> findByDOB(LocalDate dateOfBirth);

}
