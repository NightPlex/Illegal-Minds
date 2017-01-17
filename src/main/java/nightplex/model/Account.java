package nightplex.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nightplex.model.skills.barkeeping.Barkeeping;


/* 
 * Main Table to hold all references to user related data.
 * 
 * NightPlex
 * 
 * */


@Entity
@Table(name = "Account")
public class Account {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	
	@Column(unique = true)
	private String username;
    
	
	/*
	 * Will add all the skill,user,etc related tables to this Account Table.
	 * 
	 * Later just call with Account.getUserData(). etc... And use set methods to change. So only one Query needed per action :)
	 * 
	 * */
	
	
	
    @ManyToOne(cascade=CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private UserData userData; // User related general data.
    
    @ManyToOne(cascade=CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private Barkeeping barkeeping; // BarKeeping skill related data.
    
    

	public Barkeeping getBarkeeping() {
		return barkeeping;
	}

	public void setBarkeeping(Barkeeping barkeeping) {
		this.barkeeping = barkeeping;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	

	public Account(String username, UserData userData, Barkeeping barkeeping) {
		super();
		this.username = username;
		this.userData = userData;
		this.barkeeping = barkeeping;
	}

	public Account() {
		
	}
	
	
    
    
    
	
	

}
