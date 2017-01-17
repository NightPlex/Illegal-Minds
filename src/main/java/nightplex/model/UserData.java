package nightplex.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * User basic data informations for example: money, money in bank, chips , fame, energy and so on.
 * 
 * NightPlex :)
 * 
 * */



@Entity
public class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	private int credits;
	
	private int money;
	
	private int moneyInBank;
	
	private int chips;

	private int fame;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoneyInBank() {
		return moneyInBank;
	}

	public void setMoneyInBank(int moneyInBank) {
		this.moneyInBank = moneyInBank;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public int getFame() {
		return fame;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	
	
	public UserData(int credits, int money, int moneyInBank, int chips, int fame) {
		super();
		this.credits = credits;
		this.money = money;
		this.moneyInBank = moneyInBank;
		this.chips = chips;
		this.fame = fame;
	}

	public UserData() {
		
	}
	
	
	
	
	
	
	

}
