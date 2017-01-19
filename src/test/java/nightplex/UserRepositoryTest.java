package nightplex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import nightplex.model.Account;
import nightplex.model.User;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

/*
 * Spring authentication repository test
 * 
 * */


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository uRepo; // account repository
	
	@Test
	public void findLastName() {
		
		User user = uRepo.findOne(1L);
		
		assertThat(user.getPassword()).isEqualTo("test");
		
		
		
	}
	
	@Test
	public void findUserAuthRights() {
		
		User user = uRepo.findOne(1L);
		
		assertThat(user.getRole()).isEqualTo("USER");
		
		
		
	}
	
	
	
	

}
