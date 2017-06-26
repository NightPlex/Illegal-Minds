package nightplex.util.json;

import com.google.gson.Gson;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.DrinkJson;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.model.template.skills.barkeeping.MaterialJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class JsonDrinkDataParser {

    public static List<DrinkData> getDrinks() {
        Gson gson = new Gson();

        try {
            File file = new File("data/barkeeping/drinkData.json");
            FileReader fileReader = new FileReader(file);
            DrinkJson drinks = gson.fromJson(fileReader, DrinkJson.class);
            return drinks.getData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Material> getMaterials() {
        Gson gson = new Gson();

        try {
            File file = new File("data/barkeeping/rawmaterial.json");
            FileReader fileReader = new FileReader(file);
            MaterialJson materials = gson.fromJson(fileReader, MaterialJson.class);
            return materials.getData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
