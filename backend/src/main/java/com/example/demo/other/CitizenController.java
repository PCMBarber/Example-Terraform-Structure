package com.example.demo.other;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Gender;
import com.example.demo.data.Citizen;
import com.example.demo.service.CitizenService;

@RestController
@CrossOrigin
public class CitizenController {
	
		private CitizenService service;
		
		public CitizenController(CitizenService service) {
			super();
			this.service = service;
		}
		
		@GetMapping("/getAllCitizens")
		public ResponseEntity<List<Citizen>> getAllCitizens(){
			List<Citizen> created = this.service.getAllCitizens();
			return new ResponseEntity<>(created,HttpStatus.OK);
		}
		
		@GetMapping("/getByFirstName/{forename}")
		public ResponseEntity<List<Citizen>> getByCitizenFirstName(@PathVariable String forename){
			return new ResponseEntity<>(this.service.getByCitizenFirstName(forename),HttpStatus.OK);
		}
		@GetMapping("/getByLastName/{surname}")
		public ResponseEntity<List<Citizen>> getByCitizenLastName(@PathVariable String surname){
			return new ResponseEntity<>(this.service.getByCitizenFirstName(surname),HttpStatus.OK);
		}
		@GetMapping("/getByAddress/{address}")
		public ResponseEntity<List<Citizen>> getByCitizenAddress(@PathVariable String address){
			return new ResponseEntity<>(this.service.getByCitizenFirstName(address),HttpStatus.OK);
		}
		@GetMapping("/getByDOB/{dateOfBirth}")
		public ResponseEntity<List<Citizen>> getByCitizenDOB(@PathVariable LocalDate dateOfBirth){
			return new ResponseEntity<>(this.service.getByCitizenDOB(dateOfBirth),HttpStatus.OK);
		}
		@GetMapping("/getByPOB/{placeOfBirth}")
		public ResponseEntity<List<Citizen>> getByCitizenPOB(@PathVariable String placeOfBirth){
			return new ResponseEntity<>(this.service.getByCitizenFirstName(placeOfBirth),HttpStatus.OK);
		}
		@GetMapping("/getByGender/{gender}")
		public ResponseEntity<List<Citizen>> getByCitizenGender(@PathVariable Gender gender){
			return new ResponseEntity<>(this.service.getByCitizenGender(gender),HttpStatus.OK);
		}
		@GetMapping("/getByID/{id}")
		public ResponseEntity<Citizen> getByCitizenID(@PathVariable Long id){
			return new ResponseEntity<>(this.service.getByCitizenID(id),HttpStatus.OK);
		}
		

}
