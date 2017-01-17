package nightplex;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nightplex.model.Account;
import nightplex.model.User;
import nightplex.model.UserData;
import nightplex.model.skills.barkeeping.BarStorage;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

@SpringBootApplication
public class BrowserBasedMmorpgApplication {
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private UserRepository repou;

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
				
			UserData d = new UserData(56,212000000,27,277,2666);
			BarStorage s = new BarStorage(3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3);
			Barkeeping b = new Barkeeping(3,3,3,false,false,3,s);
			Account l = new Account("steven", d, b);
			
			repo.save(l);
			
			repou.save(new User("steven", "test", "USER"));
			
			
			
			

		};
	} 
}
