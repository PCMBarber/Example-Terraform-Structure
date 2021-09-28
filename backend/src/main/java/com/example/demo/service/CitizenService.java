package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.Gender;
import com.example.demo.data.Citizen;

public interface CitizenService {

	public Citizen getByCitizenID(Long id);

	public List<Citizen> getAllCitizens();

	public List<Citizen> getByCitizenFirstName(String forename);

	public List<Citizen> getByCitizenLastName(String surname);

	public List<Citizen> getByCitizenAddress(String address);

	public List<Citizen> getByCitizenDOB(LocalDate dateOfBirth);

	public List<Citizen> getByCitizenPOB(String placeOfBirth);

	public List<Citizen> getByCitizenGender(Gender gender);

}
