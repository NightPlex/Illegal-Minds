package nightplex.services.skills.barkeeping;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;

import java.util.List;

public interface BarKeepingService {

	void toggleBar();
	void sellDrinks(Account account);
	boolean makeDrink(int id);
	boolean buyRawMaterial(int amount, String ingredients);
	boolean removeRawMaterial(int amount, String ingredients);
	List<DrinkData> getAllDrinks();
	List<Material> getAllMaterial();
	List<Material> getPlayersMaterial();

	boolean buyBar();
	
	
}
