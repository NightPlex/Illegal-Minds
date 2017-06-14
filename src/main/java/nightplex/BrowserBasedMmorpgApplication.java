package nightplex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import nightplex.model.Account;
import nightplex.model.User;
import nightplex.model.UserData;
import nightplex.model.skills.barkeeping.BarStorage;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.model.skills.barkeeping.KitchenStorage;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

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
            BarStorage s = new BarStorage(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            KitchenStorage k = new KitchenStorage(0);
            Barkeeping b = new Barkeeping(1, 0, 0, false, false, 30000, s, k);

            Account l = new Account("steven", d, b);

            repo.save(l);
            //System.out.println(serv.buyBar("steven"));

            //System.out.println(repo.getById(1L).getUserData().getMoney());

            repou.save(new User("steven", "test", "USER"));


            //Here comes System.out tests


        };
    }
}
