package nightplex.service.barkeeping.data;

/**
 * Created by steven.tihomirov on 19.6.2017.
 */

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DrinkDataTest {


    @Autowired
    private GeneralService generalService;

    @Autowired
    AccountInformationService accountInformationService;
    private Account account;

    @Before
    public void populate() {
        account = accountInformationService.getCurrentUserWithOutDb();

    }

    @Test
    public void testRawMaterialData() {
        DrinkData drinkData = generalService.getDrink(1337);
        assertThat(drinkData.getDrinkName()).isEqualTo("test");
        assertThat(drinkData.getId()).isEqualTo(1337);
        assertThat(drinkData.getMaterial().get(0).getName()).isEqualTo("test");
    }

}
