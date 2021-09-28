package com.example.demo.other;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Gender;
import com.example.demo.data.Person;
import com.example.demo.service.PersonService;


public class PersonController {
	
	private PersonService service;
	
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAllPeople")
	public ResponseEntity<List<Person>> getAllPeople(){
		List<Person> created = this.service.getAllPerson();
		return new ResponseEntity<>(created,HttpStatus.OK);
	}
	
	@GetMapping("/getByFirstName/{forename}")
	public ResponseEntity<List<Person>> getByPersonFirstName(@PathVariable String forename){
		return new ResponseEntity<>(this.service.getByPersonFirstName(forename),HttpStatus.OK);
	}
	@GetMapping("/getByLastName/{surname}")
	public ResponseEntity<List<Person>> getByPersonLastName(@PathVariable String surname){
		return new ResponseEntity<>(this.service.getByPersonLastName(surname),HttpStatus.OK);
	}
	@GetMapping("/getByNationality/{nationality}")
	public ResponseEntity<List<Person>> getByPersonNationality(@PathVariable String nationality){
		return new ResponseEntity<>(this.service.getByPersonNationality(nationality),HttpStatus.OK);
	}
	@GetMapping("/getByDOB/{dateOfBirth}")
	public ResponseEntity<List<Person>> getByPersonDOB(@PathVariable LocalDate dateOfBirth){
		return new ResponseEntity<>(this.service.getByPersonDOB(dateOfBirth),HttpStatus.OK);
	}
	@GetMapping("/getByPOB/{placeOfBirth}")
	public ResponseEntity<List<Person>> getByPersonPOB(@PathVariable String placeOfBirth){
		return new ResponseEntity<>(this.service.getByPersonPOB(placeOfBirth),HttpStatus.OK);
	}
	@GetMapping("/getByGender/{gender}")
	public ResponseEntity<List<Person>> getByPersonGender(@PathVariable Gender gender){
		return new ResponseEntity<>(this.service.getByPersonGender(gender),HttpStatus.OK);
	}
	@GetMapping("/getByID/{id}")
	public ResponseEntity<Person> getByPersonID(@PathVariable Long id){
		return new ResponseEntity<>(this.service.getByPersonID(id),HttpStatus.OK);
	}

}
