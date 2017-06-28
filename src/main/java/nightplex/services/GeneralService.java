package nightplex.services;


import nightplex.ServerCONF;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;
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

    private Map<String, Material> materials;

    public GeneralService() {
        populateDrinks();
        populateMaterials();
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
                d.setExperience(d.getExperience() * ServerCONF.EXP_MULTIPLIER);
                drinks.put(d.getId(), d);
            }
        }

    }

    private void populateMaterials() {
        materials = new HashMap<>();
        List<Material> materialsList = JsonDrinkDataParser.getMaterials();
        if(materialsList != null) {
            for(Material material : materialsList) {
                materials.put(material.getName(), material);
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

    public Material getMaterial(String name) {
        return materials.get(name);
    }

    public Map<Integer, DrinkData> getDrinks() {
        return drinks;
    }

    public List<Material> getMaterials() {
        return JsonDrinkDataParser.getMaterials();
    }

}
