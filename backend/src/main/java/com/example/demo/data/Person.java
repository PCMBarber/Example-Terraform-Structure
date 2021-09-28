package com.example.demo.data;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.Gender;

@Entity
public class Person {
	
	@Id
	private Long personID;
	
	@Column
	private boolean is_Citizen;
	private String personForename;
	private String personSurname;
	private LocalDate personDOB;
	private String personPOB;
	private String personNationality;
	private Gender personGender;
	
	public Person(Long personID, boolean is_Citizen, String personForename, String personSurname, LocalDate personDOB, String personPOB, String personNationality, Gender personGender) {
		super();
		this.personID = personID;
		this.is_Citizen = is_Citizen;
		this.personForename = personForename;
		this.personSurname = personSurname;
		this.personDOB = personDOB;
		this.personPOB = personPOB;
		this.personNationality = personNationality;
		this.personGender = personGender;
		
	}
	public Person(boolean is_Citizen, String personForename, String personSurname, LocalDate personDOB, String personPOB, String personNationality, Gender personGender) {
		super();
		this.is_Citizen = is_Citizen;
		this.personForename = personForename;
		this.personSurname = personSurname;
		this.personDOB = personDOB;
		this.personPOB = personPOB;
		this.personNationality = personNationality;
		this.personGender = personGender;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(is_Citizen, personDOB, personForename, personGender, personID, personNationality, personPOB,
				personSurname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return is_Citizen == other.is_Citizen && Objects.equals(personDOB, other.personDOB)
				&& Objects.equals(personForename, other.personForename) && personGender == other.personGender
				&& Objects.equals(personID, other.personID)
				&& Objects.equals(personNationality, other.personNationality)
				&& Objects.equals(personPOB, other.personPOB) && Objects.equals(personSurname, other.personSurname);
	}
	public Long getPersonID() {
		return personID;
	}
	public void setPersonID(Long personID) {
		this.personID = personID;
	}
	public boolean isIs_Citizen() {
		return is_Citizen;
	}
	public void setIs_Citizen(boolean is_Citizen) {
		this.is_Citizen = is_Citizen;
	}
	public String getPersonForename() {
		return personForename;
	}
	public void setPersonForename(String personForename) {
		this.personForename = personForename;
	}
	public String getPersonSurname() {
		return personSurname;
	}
	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}
	public LocalDate getPersonDOB() {
		return personDOB;
	}
	public void setPersonDOB(LocalDate personDOB) {
		this.personDOB = personDOB;
	}
	public String getPersonPOB() {
		return personPOB;
	}
	public void setPersonPOB(String personPOB) {
		this.personPOB = personPOB;
	}
	public String getPersonNationality() {
		return personNationality;
	}
	public void setPersonNationality(String personNationality) {
		this.personNationality = personNationality;
	}
	public Gender getPersonGender() {
		return personGender;
	}
	public void setPersonGender(Gender personGender) {
		this.personGender = personGender;
	}
	@Override
	public String toString() {
		return "Person [personID=" + personID + ", is_Citizen=" + is_Citizen + ", personForename=" + personForename
				+ ", personSurname=" + personSurname + ", personDOB=" + personDOB + ", personPOB=" + personPOB
				+ ", personNationality=" + personNationality + ", personGender=" + personGender + "]";
	}
	
	
	

}
