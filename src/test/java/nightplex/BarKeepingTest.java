package nightplex;

import nightplex.services.repository.AccountRepository;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarKeepingTest {
	
	
	@Autowired
	private BarKeepingService barServ;
	
	@Autowired
	private AccountRepository aRepo;
	
	@Test
	public void testBarkeepingDrinks() {

	}

}
