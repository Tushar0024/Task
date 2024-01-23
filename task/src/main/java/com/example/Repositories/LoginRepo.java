package com.example.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.*;


@Repository
@Transactional
public interface LoginRepo extends JpaRepository<Login,Integer>{

	
	@Query(value = "SELECT * FROM Login l WHERE l.EmailID = :EmailID", nativeQuery = true)
	Optional<Login> getUserByEmailID(@Param("EmailID") String EmailID);
}
