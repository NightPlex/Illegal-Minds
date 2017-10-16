package nightplex.services;

import nightplex.model.Account;
import nightplex.services.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * NightPlex
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	// Repository for all users
	private final AccountRepository accountRepository;


	@Autowired
	public UserDetailServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account curruser = accountRepository.getByUsername(username); // Find username with called parameter
		
		return new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
        		AuthorityUtils.createAuthorityList(curruser.getRole())); //create a new authority rule for given user
	}

}
