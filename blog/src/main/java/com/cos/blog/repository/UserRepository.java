package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}



/*
 * User findByUsernameAndPassword(String username, String password);
 */
/*
 * @Query(value="select * from user where username =?1 and passowrd =?2",
 * nativeQuery = true) User login(String username, String password);
 */