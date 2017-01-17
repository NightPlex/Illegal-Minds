package nightplex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import nightplex.services.UserDetailServiceImpl;


/*This class is to customize Spring Web Security configuration
 * 
 * Will later SessionRegistry
 * 
 * NightPlex--)

*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserDetailServiceImpl userDetailsService;
	
	// Declare and manipulate the permissions 
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		
		http.authorizeRequests()
		.antMatchers("/css/**", "/", "/fonts/**", "/icons/**", "/img/**", "/vendor/**","/js/**", "/public/**", "/register").permitAll() // Do i need to write this all ? Is there shorter way
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/").successForwardUrl("/game")
			.permitAll()
			.and()
		.logout().logoutSuccessUrl("/")
		.permitAll()
		
		
		;
		
		
		
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		
		; // This is just a test will be changed later
		
		
	}

}
