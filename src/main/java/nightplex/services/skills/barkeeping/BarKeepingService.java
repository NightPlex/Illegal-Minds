package nightplex.services.skills.barkeeping;

public interface BarKeepingService {

	boolean toggleBar();
	boolean makeDrink(int id);
	boolean buyRawMaterial(int amount, int id);
	boolean buyBar();
	
	
}
