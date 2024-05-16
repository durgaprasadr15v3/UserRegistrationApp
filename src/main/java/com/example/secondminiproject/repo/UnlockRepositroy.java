package com.example.secondminiproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondminiproject.entity.User;


@Repository
public interface UnlockRepositroy  extends JpaRepository<User, Long>{

	User findByEmail(String email);


}
