package com.example.demo.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Passport;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Long> {

}
