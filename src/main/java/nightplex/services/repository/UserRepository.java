package nightplex.services.repository;

import nightplex.model.User;
import org.springframework.data.repository.CrudRepository;

/*
 * Repository for storing user authentication related information
 * 
 * Uses h2 in-memory for dev purpose.
 * Change to JpaRepository for mysql
 * 
 * */
public interface UserRepository extends CrudRepository<User, Long>{ // JpaRepository for mysql connection. Simp+le change

	User findByUsername(String username);
	
}
