package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Gender;
import com.example.demo.data.Person;
import com.example.demo.data.repo.PersonRepo;

@Service
@Primary
public class PersonServiceDB implements PersonService{
	
	private PersonRepo repo;
	
	public PersonServiceDB(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Person getByPersonID(Long personID) {
		Person found = this.repo.findById(personID).get();
		return found;
	}

	@Override
	public List<Person> getAllPerson() {
		return this.repo.findAll();
	}

	@Override
	public List<Person> getByPersonFirstName(String forename) {
		return this.repo.findByForenameIgnoreCase(forename);
	}

	@Override
	public List<Person> getByPersonLastName(String surname) {
		return this.repo.findBySurnameIgnoreCase(surname);
	}

	@Override
	public List<Person> getByPersonNationality(String nationality) {
		return this.repo.findByNationalityIgnoreCase(nationality);
	}

	@Override
	public List<Person> getByPersonDOB(LocalDate dateOfBirth) {
		return this.repo.findByDOB(dateOfBirth);
	}

	@Override
	public List<Person> getByPersonPOB(String placeOfBirth) {
		return this.repo.findByPOBIgnoreCase(placeOfBirth);
	}

	@Override
	public List<Person> getByPersonGender(Gender gender) {
		return this.repo.findByGenderIgnoreCase(gender);
	}
	

}
