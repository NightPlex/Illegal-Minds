package nightplex.service.barkeeping.logic;

/**
 * Created by steven.tihomirov on 19.6.2017.
 */

import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DrinkTaskServiceTest {


    @Autowired
    private BarKeepingService barServ;

    @Autowired
    AccountInformationService accountInformationService;
    private Account account;

    @Before
    public void populate() {
        account = accountInformationService.getCurrentUserWithOutDb();

    }

    @Test
    public void testOrderingNewRawMaterial() {
        barServ.buyRawMaterial(20, "pears");
        account = accountInformationService.getCurrentUserWithOutDb();
        assertThat(account.getBarkeeping().getIngredients().get("pears")).isEqualTo(20);
        barServ.buyRawMaterial(20, "pears");
        account = accountInformationService.getCurrentUserWithOutDb();

        assertThat(account.getBarkeeping().getIngredients().get("pears")).isEqualTo(40);

        barServ.buyRawMaterial(20, "apples");
        account = accountInformationService.getCurrentUserWithOutDb();

        assertThat(account.getBarkeeping().getIngredients().get("apples")).isEqualTo(20);
    }

    @Test
    public void testRemovingRawMaterial() {
        barServ.buyRawMaterial(20, "water");
        barServ.removeRawMaterial(5, "water");
        account = accountInformationService.getCurrentUserWithOutDb();
        assertThat(account.getBarkeeping().getIngredients().get("water")).isEqualTo(15);
    }

    @Test
    public void testMakingDrink() {
        account.getBarkeeping().getIngredients().clear();
       accountInformationService.saveAccount(account);
       barServ.buyRawMaterial(3, "water");
       barServ.makeDrink(1);
        account = accountInformationService.getCurrentUserWithOutDb();
        assertThat(account.getBarkeeping().getIngredients().get("water")).isEqualTo(2);
        assertThat(account.getBarkeeping().getDrinks()).isEqualTo(1);
        assertThat(account.getBarkeeping().storageAmount()).isEqualTo(2);
        assertThat(account.getBarkeeping().getReadyDrinks().get(1)).isEqualTo(1);
    }

}
