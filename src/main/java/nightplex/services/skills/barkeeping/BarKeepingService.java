package nightplex.services.skills.barkeeping;

public interface BarKeepingService {

	void toggleBar();
	boolean makeDrink(int id);
	boolean buyRawMaterial(int amount, String ingredients);
	boolean removeRawMaterial(int amount, String ingredients);

	boolean buyBar();
	
	
}
