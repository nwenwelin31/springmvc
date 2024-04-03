package com.springboot.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.springbootapp.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	@Query("SELECT u.username FROM UserModel u")
	List<String> findAllUserNames();

	@Query("SELECT u FROM UserModel u WHERE u.id = :userId")
	UserModel getUserById(@Param("userId") int userId);

}
