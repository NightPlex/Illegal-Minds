package nightplex.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nightplex.model.Account;
import nightplex.model.User;

/*
 * Repository for storing user authentication related information
 * 
 * Uses h2 in-memory for dev purpose.
 * Change to JpaRepository for mysql
 * 
 * */

@Repository
public interface UserRepository extends CrudRepository<User, Long>{ // JpaRepository for mysql connection. Simp+le change

	User findByUsername(String username);
	
}
