package nightplex.services.skills.barkeeping;

import nightplex.model.Account;

public interface BarKeepingService {

	void toggleBar();
	void sellDrinks(Account account);
	boolean makeDrink(int id);
	boolean buyRawMaterial(int amount, String ingredients);
	boolean removeRawMaterial(int amount, String ingredients);

	boolean buyBar();
	
	
}
