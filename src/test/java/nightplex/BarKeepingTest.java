package nightplex;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
import nightplex.services.repository.AccountRepository;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarKeepingTest {
	
	
	@Autowired
	private BarKeepingService barServ;
	
	@Autowired
	private AccountRepository aRepo;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private AccountInformationService accountInformationService;
	
	@Test
	public void testBarkeepingDrinks() {

		DrinkData data = generalService.getDrinks().get(1);
		System.out.println(data.getDrinkName());
		assertThat(data.getDrinkName()).contains("Filtered");

	}

	@Test
	public void testBarkeepingDrinksMkse() {

		Account account = accountInformationService.getCurrentUserWithOutDb();
		account.getUserData().setMoney(10000);
		barServ.buyBar();
		account = accountInformationService.getCurrentUserWithOutDb();
		assertThat(account.getBarkeeping().isHasBoughtBar()).isEqualTo(true);
		barServ.buyRawMaterial(100, 1);
		account = accountInformationService.getCurrentUserWithOutDb();
		assertThat(account.getBarkeeping().getBarStorage().getWater()).isEqualTo(100);
		barServ.makeDrink(1);
		account = accountInformationService.getCurrentUserWithOutDb();
		assertThat(account.getBarkeeping().getDrinks()).isEqualTo(1);
		assertThat(account.getBarkeeping().getBarStorage().getWater()).isEqualTo(99);
		assertThat(barServ.makeDrink(2)).isEqualTo(false);


	}
}
