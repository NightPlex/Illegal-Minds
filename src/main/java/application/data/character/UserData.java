package application.data.character;

public class UserData {
	
	private int credits, money, moneyInBank, chips;
	
	


	public UserData(int credits, int money, int moneyInBank, int chips) {
		this.credits = credits;
		this.money = money;
		this.moneyInBank = moneyInBank;
		this.chips = chips;
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
	
	
	
	

}
