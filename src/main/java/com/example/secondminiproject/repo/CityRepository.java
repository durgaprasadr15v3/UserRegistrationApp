package com.example.secondminiproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondminiproject.entity.CIty_master;

@Repository
public interface CityRepository extends JpaRepository<CIty_master, Long>{

	List<CIty_master> findByStateName(String statename);

}
