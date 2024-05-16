package com.example.secondminiproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondminiproject.entity.State_master;

@Repository
public interface StateRepository extends JpaRepository<State_master, Long>{


	List<State_master> findByCountryId(int countryid);

	

   
}
