package nightplex.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nightplex.model.Account;


/*
 * user account related storing
 * 
 * Uses h2 in-memory for dev purpose.
 * Change to JpaRepository for mysql
 * 
 * */



@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{ //JpaRepository here for mysql
	
	Account getByUsername(String username); // Custom Query for getting The Account class with username.
	
	Account getById(Long id);

}
