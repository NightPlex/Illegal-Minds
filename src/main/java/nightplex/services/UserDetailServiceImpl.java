package nightplex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import nightplex.model.User;
import nightplex.services.repository.UserRepository;


/*
 * 
 * Custom implementation of UserDetails's. Meaning own auth system.
 * Grab account in present from database and give roles.
 * 
 * NightPlex--
 * 
 * 
 * 
 * */


@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	// Repository for all users
	private final UserRepository repository;

	
	//Provide repository automatically
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

	
	//Own auth system
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username); // Find username with called parameter
		
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole())); //create a new authority rule for given user
		
		
		
			
		return user;
	}

}
