package com.example.secondminiproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondminiproject.entity.Country_master;

@Repository
public interface CountryRepository extends JpaRepository<Country_master,Long> {

}
