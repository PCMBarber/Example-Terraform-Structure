package com.example.demo.data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.Gender;

@Entity
public class Passport {

	@Id
	private Long passportNumber;

	@Column
	private String passportSurname;
	private String passportForename;
	private String passportNationality;
	private LocalDate passportDateOfBirth;
	private Gender passportGender;
	private String passportPlaceOfBirth;
	private String passportIssuingCountry;
	private LocalDate passportDateOfIssue;
	private LocalDate passportDateOfExpiry;

	public Passport(Long passportNumber, String passportSurname, String passportForename, String passportNationality,
			LocalDate passportDateOfBirth, Gender passportGender, String passportPlaceOfBirth,
			String passportIssuingCountry, LocalDate passportDateOfIssue, LocalDate passportDateOfExpiry) {
		super();
		this.passportNumber = passportNumber;
		this.passportSurname = passportSurname;
		this.passportForename = passportForename;
		this.passportNationality = passportNationality;
		this.passportDateOfBirth = passportDateOfBirth;
		this.passportGender = passportGender;
		this.passportPlaceOfBirth = passportPlaceOfBirth;
		this.passportIssuingCountry = passportIssuingCountry;
		this.passportDateOfIssue = passportDateOfIssue;
		this.passportDateOfExpiry = passportDateOfExpiry;
	}

	public Passport(String passportSurname, String passportForename, String passportNationality,
			LocalDate passportDateOfBirth, Gender passportGender, String passportPlaceOfBirth,
			String passportIssuingCountry, LocalDate passportDateOfIssue, LocalDate passportDateOfExpiry) {
		super();
		this.passportSurname = passportSurname;
		this.passportForename = passportForename;
		this.passportNationality = passportNationality;
		this.passportDateOfBirth = passportDateOfBirth;
		this.passportGender = passportGender;
		this.passportPlaceOfBirth = passportPlaceOfBirth;
		this.passportIssuingCountry = passportIssuingCountry;
		this.passportDateOfIssue = passportDateOfIssue;
		this.passportDateOfExpiry = passportDateOfExpiry;
	}

	public Passport() {
		// TODO Auto-generated constructor stub
	}

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportSurname() {
		return passportSurname;
	}

	public void setPassportSurname(String passportSurname) {
		this.passportSurname = passportSurname;
	}

	public String getPassportForename() {
		return passportForename;
	}

	public void setPassportForename(String passportForename) {
		this.passportForename = passportForename;
	}

	public String getPassportNationality() {
		return passportNationality;
	}

	public void setPassportNationality(String passportNationality) {
		this.passportNationality = passportNationality;
	}

	public LocalDate getPassportDateOfBirth() {
		return passportDateOfBirth;
	}

	public void setPassportDateOfBirth(LocalDate passportDateOfBirth) {
		this.passportDateOfBirth = passportDateOfBirth;
	}

	public Gender getPassportGender() {
		return passportGender;
	}

	public void setPassportGender(Gender passportGender) {
		this.passportGender = passportGender;
	}

	public String getPassportPlaceOfBirth() {
		return passportPlaceOfBirth;
	}

	public void setPassportPlaceOfBirth(String passportPlaceOfBirth) {
		this.passportPlaceOfBirth = passportPlaceOfBirth;
	}

	public String getPassportIssuingCountry() {
		return passportIssuingCountry;
	}

	public void setPassportIssuingCountry(String passportIssuingCountry) {
		this.passportIssuingCountry = passportIssuingCountry;
	}

	public LocalDate getPassportDateOfIssue() {
		return passportDateOfIssue;
	}

	public void setPassportDateOfIssue(LocalDate passportDateOfIssue) {
		this.passportDateOfIssue = passportDateOfIssue;
	}

	public LocalDate getPassportDateOfExpiry() {
		return passportDateOfExpiry;
	}

	public void setPassportDateOfExpiry(LocalDate passportDateOfExpiry) {
		this.passportDateOfExpiry = passportDateOfExpiry;
	}

	@Override
	public String toString() {
		return "Passport [passportNumber=" + passportNumber + ", passportSurname=" + passportSurname
				+ ", passportForename=" + passportForename + ", passportNationality=" + passportNationality
				+ ", passportDateOfBirth=" + passportDateOfBirth + ", passportGender=" + passportGender
				+ ", passportPlaceOfBirth=" + passportPlaceOfBirth + ", passportIssuingCountry="
				+ passportIssuingCountry + ", passportDateOfIssue=" + passportDateOfIssue + ", passportDateOfExpiry="
				+ passportDateOfExpiry + "]";
	}

}
