package nightplex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nightplex.services.barkeeping.BarKeepingService;
import nightplex.services.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarKeepingTest {
	
	
	@Autowired
	private BarKeepingService barServ;
	
	@Autowired
	private AccountRepository aRepo;
	
	@Test
	public void testBarkeepingDrinks() {
		
		
		assertThat(barServ.buyBar()).isEqualTo(true);
		assertThat(barServ.makeFilteredWater()).isEqualTo(false);
		assertThat(barServ.buyWaterRawMaterial(40)).isEqualTo(true);
		assertThat(barServ.makeFilteredWater()).isEqualTo(true);
		barServ.makeFilteredWater();
		barServ.makeFilteredWater();
		barServ.makeFilteredWater();
		
		assertThat(aRepo.getById(1L).getBarkeeping().getBarkeepingExp()).isEqualTo(ServerCONF.FILTERED_WATER_EXP * 4);
		assertThat(aRepo.getById(1L).getBarkeeping().getBarkeepingLevel()).isEqualTo(2);
		

		
		
	}

}
