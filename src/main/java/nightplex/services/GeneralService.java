package nightplex.services;


import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.util.json.JsonDrinkDataParser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
@Service
public class GeneralService {
    private Map<Integer, DrinkData> drinks;

    public GeneralService() {
        populateDrinks();
    }

    /**
     * Get drinks from json and populate them to Map
     *
     * */
    private void populateDrinks() {

        List<DrinkData> drinkData = JsonDrinkDataParser.getDrinks();
        drinks = new HashMap<>();
        if (drinkData != null) {
            for (DrinkData d : drinkData) {
                drinks.put(d.getId(), d);
            }
        }

    }

    public DrinkData getDrink(int id) {
        DrinkData drinkData = drinks.get(id);
        if(drinkData != null) {
            return drinkData;
        }
        return null;
    }

    public Map<Integer, DrinkData> getDrinks() {
        return drinks;
    }
}
