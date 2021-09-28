package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.Gender;

import java.time.*;
import java.util.Objects;

@Entity
public class Citizen {
	
	
	@Id
	private Long id;
	
	@Column
	private String forename;
	private String surname;
	private String address;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	private Gender gender;
	
	public Citizen(Long id, String forename, String surname, String address, LocalDate dateOfBirth, String placeOfBirth, Gender gender) {
		super();
		this.id=id;
		this.forename=forename;
		this.surname=surname;
		this.address=address;
		this.dateOfBirth=dateOfBirth;
		this.placeOfBirth=placeOfBirth;
		this.gender=gender;
	}
	public Citizen(String forename, String surname, String address, LocalDate dateOfBirth, String placeOfBirth, Gender gender) {
		super();
		this.forename=forename;
		this.surname=surname;
		this.address=address;
		this.dateOfBirth=dateOfBirth;
		this.placeOfBirth=placeOfBirth;
		this.gender=gender;
	}
	public Citizen() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, dateOfBirth, forename, gender, id, placeOfBirth, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		return Objects.equals(address, other.address) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(forename, other.forename) && gender == other.gender && Objects.equals(id, other.id)
				&& Objects.equals(placeOfBirth, other.placeOfBirth) && Objects.equals(surname, other.surname);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		
		return "Citizen [ID = " + id + ", Forename(s) = " + forename + ", Surname = " + surname + ", Address = " + address + ", DOB = " + dateOfBirth + ", POB = " + placeOfBirth + ", Gender = " + gender + "]";
	}
	

}
