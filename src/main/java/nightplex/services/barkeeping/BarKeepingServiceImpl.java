package nightplex.services.barkeeping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.other.ExperienceHandler;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

/*
 * "Busines logic" for barkeeping skill
 * 
 * 
 * */
@Service
public class BarKeepingServiceImpl implements BarKeepingService {

	@Autowired
	private AccountRepository repo;

	public Account getAccount() {

		// String username =
		// SecurityContextHolder.getContext().getAuthentication().getName(); //
		// Uncomment if not testing application

		try {

			// return repo.getByUsername(username); Use this for multiple users
			return repo.getById(1L); // This is just for test purposes

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	

	public boolean buyBar() {

		try {

			Account account = getAccount();

			if (account.getUserData().getMoney() >= ServerCONF.BAR_PRICE) {

				account.getUserData().setMoney(account.getUserData().getMoney() - ServerCONF.BAR_PRICE);
				account.getBarkeeping().setHasBoughtBar(true);
				repo.save(account);
				return true;

			} else {

				return false;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean buyWaterRawMaterial(int amount) {

		try {

			Account account = getAccount();

			if ((amount + account.getBarkeeping().getBarStorage().getWater()) <= account.getBarkeeping()
					.getStorageCapacity()) {

				account.getBarkeeping().getBarStorage()
						.setWater(account.getBarkeeping().getBarStorage().getWater() + amount);

				repo.save(account);

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean makeFilteredWater() {

		try {

			Account account = getAccount();

			if (account.getBarkeeping().getBarStorage().getWater() > 0) {

				account.getBarkeeping().getBarStorage()
						.setWater(account.getBarkeeping().getBarStorage().getWater() - 1);

				account.getBarkeeping().getKitchenStorage()
						.setFilteredWater(account.getBarkeeping().getKitchenStorage().getFilteredWater() + 1);
				// check for xp and lvl change.
				account.getBarkeeping().setBarkeepingExp(account.getBarkeeping().getBarkeepingExp() + ServerCONF.FILTERED_WATER_EXP);
				account.getBarkeeping().setBarkeepingLevel(ExperienceHandler.checkForLevel(account.getBarkeeping().getBarkeepingExp(), account.getBarkeeping().getBarkeepingLevel()));
				
				repo.save(account);

				return true;

			} else {

				return false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}



	@Override
	public boolean toggleBar() {
		try {

			Account account = getAccount();

				if (!account.getBarkeeping().isBarIsClosed()) {
					
					account.getBarkeeping().setBarIsClosed(true);
					
					return true;
					
					
				} else {
					
					account.getBarkeeping().setBarIsClosed(false);
					return true;
					
				}

			

			

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		}
	}
	
	

}
