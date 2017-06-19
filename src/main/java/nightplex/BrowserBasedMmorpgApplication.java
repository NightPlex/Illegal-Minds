package nightplex;

import nightplex.model.Account;
import nightplex.model.User;
import nightplex.model.UserData;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableScheduling // adding some interaction with schedule
public class BrowserBasedMmorpgApplication {

    @Autowired
    private AccountRepository repo;

    @Autowired
    private UserRepository repou;

    //@Autowired
    //private BarKeepingService serv;


    public static void main(String[] args) {
        SpringApplication.run(BrowserBasedMmorpgApplication.class, args);
    }


    @Bean
    public Account getAccount() {

        //System.out.println(repo.getByUsername("steven").toString() + " this error");
        return repo.getByUsername("steven");

    }

    @Bean
    public CommandLineRunner studentDemo(AccountRepository repo) {
        return (args) -> {

            UserData d = new UserData(56, 212000000, 27, 277, 2666);
            Barkeeping b = new Barkeeping(1, 0, 0, false, false, 30000);
            Map<Integer, Integer> drinks = new HashMap<>();

            drinks.put(1, 20);

            b.setReadyDrinks(drinks);

            Account l = new Account("steven", d, b);

            repo.save(l);

            repou.save(new User("steven", "test", "USER"));

            Account account = repo.getByUsername("steven");

            System.out.println(account.getBarkeeping().getReadyDrinks().get(1));


            //Here comes System.out tests


        };
    }
}
