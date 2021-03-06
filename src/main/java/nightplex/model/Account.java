package nightplex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.model.skills.cooking.Cooking;

import javax.persistence.*;


/**
 * Main Table to hold all references to user related data.
 * <p>
 * NightPlex
 */


@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "email", nullable = false)
    private String email;
	/*
     * Will add all the skill,user,etc related tables to this Account Table.
	 * 
	 * Later just call with Account.getUserData(). etc... And use set methods to change. So only one Query needed per action :)
	 * 
	 * */


    @ManyToOne(cascade = CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private UserData userData; // User related general data.

    @ManyToOne(cascade = CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private Barkeeping barkeeping; // BarKeeping skill related data.

    @ManyToOne(cascade = CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private Cooking cooking;

    public Cooking getCooking() {
        return cooking;
    }

    public void setCooking(Cooking cooking) {
        this.cooking = cooking;
    }

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


    /**
     * Initial account creation constructor
     */
    public Account(boolean yes) {

    }

    public Account(String username, String password, String email, String role, UserData userData, Barkeeping barkeeping, Cooking cooking) {
        super();
        this.username = username;
        this.userData = userData;
        this.barkeeping = barkeeping;
        this.password = password;
        this.email = email;
        this.role = role;
        this.cooking = cooking;
    }

    public Account() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "";
    }


}
