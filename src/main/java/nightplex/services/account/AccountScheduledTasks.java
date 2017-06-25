package nightplex.services.account;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import nightplex.model.Account;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by NightPlex
 * Github: https://github.com/NightPlex
 *
 * Scheduling tasks for Account, eg: selling drinks and so on.
 *
 * @author NightPlex
 */
@Component
public class AccountScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private BarKeepingService barKeepingService;

    private int nextCustomers;

    @Scheduled(fixedRate = 1000)
    public void oneSecondCounter() {
        nextCustomers++;
    }

    /**
     * Every 15 minutes new batch of customers come.
     * */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        //Check and calculate drinks and profit.

        //System.out.println(dateFormat.format(new Date()) + " time");
    }

    @Scheduled(fixedRate = 10000)
    public void updateDrinks() {
        //Check and calculate drinks and profit.
        System.out.println("STARTING DRINK UPDATE");
        for(Account account : accountInformationService.getAll()) {
            if(!account.getBarkeeping().isBarIsClosed()) {
                barKeepingService.sellDrinks(account);
                accountInformationService.saveAccount(account);
            }
        }

        nextCustomers = 0;
    }

    public int getNextCustomers() {
        return nextCustomers;
    }

    public void setNextCustomers(int nextCustomers) {
        this.nextCustomers = nextCustomers;
    }
}
