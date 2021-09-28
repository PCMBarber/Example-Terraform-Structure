package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Gender;
import com.example.demo.data.Citizen;

@Service
public class CitizenServiceList implements CitizenService{
	
	private List<Citizen> citizens = new ArrayList<>();

	@Override
	public Citizen getByCitizenID(Long id) {
		
		return null;
	}

	@Override
	public List<Citizen> getAllCitizens() {
		
		for(Citizen citizen: citizens) {
			System.out.println(citizen);
		}
		return citizens;
	}

	@Override
	public List<Citizen> getByCitizenFirstName(String forename) {
		
		return null;
	}

	@Override
	public List<Citizen> getByCitizenLastName(String surname) {
		
		return null;
	}

	@Override
	public List<Citizen> getByCitizenAddress(String address) {
		
		return null;
	}

	@Override
	public List<Citizen> getByCitizenDOB(LocalDate dateOfBirth) {
		
		return null;
	}

	@Override
	public List<Citizen> getByCitizenPOB(String placeOfBirth) {
		
		return null;
	}

	@Override
	public List<Citizen> getByCitizenGender(Gender gender) {
		
		return null;
	}
	
	

}
