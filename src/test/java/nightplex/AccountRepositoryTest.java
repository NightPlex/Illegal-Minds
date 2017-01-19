package nightplex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nightplex.model.Account;
import nightplex.services.repository.AccountRepository;

/*
 * Test the account repository..
 * 
 * */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository aRepo; // account repository
	
	@Test
	public void findUserData() {
		
		Account account = aRepo.findOne(1L);
		
		assertThat(account.getUserData()).isNotNull();
		
		
		
	}
	
	@Test
	public void findUserBarkeepingStats() {
		
		Account account = aRepo.findOne(1L);
		
		assertThat(account.getBarkeeping()).isNotNull();
		
		
		
	}
	
	
	

}
