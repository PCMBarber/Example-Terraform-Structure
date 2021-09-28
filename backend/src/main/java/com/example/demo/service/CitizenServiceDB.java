package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.Gender;
import com.example.demo.data.Citizen;
import com.example.demo.data.repo.CitizenRepo;

@Service
@Primary
public class CitizenServiceDB implements CitizenService{
	
	private CitizenRepo repo;
	
	public CitizenServiceDB(CitizenRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Citizen> getAllCitizens(){
		return this.repo.findAll();
	}
	
	@Override
	public List<Citizen> getByCitizenFirstName(String forename){
		return this.repo.findByForenameIgnoreCase(forename);
	}
	@Override
	public List<Citizen> getByCitizenLastName(String surname){
		return this.repo.findBySurnameIgnoreCase(surname);
	}
	@Override
	public List<Citizen> getByCitizenAddress(String address){
		return this.repo.findByAddressIgnoreCase(address);
	}
	@Override
	public List<Citizen> getByCitizenPOB(String placeOfBirth){
		return this.repo.findByPOBIgnoreCase(placeOfBirth);
	}
	@Override
	public List<Citizen> getByCitizenGender(Gender gender){
		return this.repo.findByGenderIgnoreCase(gender);
	}
	@Override
	public List<Citizen> getByCitizenDOB(LocalDate dateOfBirth){
		return this.repo.findByDOB(dateOfBirth);
	}
	
	@Transactional
	public Citizen getByCitizenID(Long id) {
		Citizen found = this.repo.findById(id).get();
		return found;
	}
	

}
