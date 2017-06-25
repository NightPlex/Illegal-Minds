package nightplex;

import nightplex.model.Account;
import nightplex.model.UserData;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.services.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // adding some interaction with schedule
public class BrowserBasedMmorpgApplication {

    @Autowired
    private AccountRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(BrowserBasedMmorpgApplication.class, args);
    }


    @Bean
    public CommandLineRunner studentDemo(AccountRepository repo) {
        return (args) -> {

            UserData d = new UserData(56, 0, 555, 277, 2666);
            Barkeeping b = new Barkeeping(1, 0, 5000, false, false, 30000);

            Account l = new Account("steven", "test", "test@test.com", "USER", d, b);

            repo.save(l);

        };
    }
}
