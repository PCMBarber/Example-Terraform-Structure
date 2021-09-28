package com.example.demo.data.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Gender;
import com.example.demo.data.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {
	
	List<Person> findByForenameIgnoreCase(String forename);
	List<Person> findBySurnameIgnoreCase(String Surname);
	List<Person> findByNationalityIgnoreCase(String nationality);
	List<Person> findByPOBIgnoreCase(String placeOfBirth);
	List<Person> findByGenderIgnoreCase(Gender gender);
	List<Person> findByDOB(LocalDate dateOfBirth);
	List<Person> findAllCitizensIgnoreCase(boolean is_Citizen);
	

}
