package nightplex.util.json;

import com.google.gson.Gson;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.DrinkJson;

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
            File file = new File("src/main/java/drinkData.json");
            FileReader fileReader = new FileReader(file);
            DrinkJson drinks = gson.fromJson(fileReader,DrinkJson.class);
            return drinks.getData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

}
