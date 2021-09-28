package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.data.Passport;
import com.example.demo.data.repo.PassportRepo;

@Service
@Primary
public class PassportService {

	private PassportRepo repo;

	public PassportService(PassportRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Passport> getAllPassports() {
		return this.repo.findAll();
	}

	@Transactional
	public Passport getbyPassportNumber(Long id) {
		Passport found = this.repo.findById(id).get();
		return found;
	}

}
