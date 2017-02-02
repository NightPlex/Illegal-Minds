package nightplex.services.barkeeping;

import nightplex.model.Account;

public interface BarKeepingService {

	boolean toggleBar();
	boolean makeFilteredWater();
	boolean buyWaterRawMaterial(int amount);
	boolean buyBar();
	
	
}
