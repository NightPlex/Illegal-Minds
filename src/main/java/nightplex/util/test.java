package nightplex.util;

import com.google.gson.Gson;
import nightplex.model.template.skills.barkeeping.DrinkJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by steven.tihomirov on 14.6.2017.
 */
public class test {
    public static void main(String args[]) {

        Gson gson = new Gson();

        try {
            File file = new File("src/main/java/drinkData.json");
            System.out.println(file.getPath());
            FileReader fileReader = new FileReader(file);

            DrinkJson drinks = gson.fromJson(fileReader,DrinkJson.class);
            System.out.println(drinks.getData().get(0).getDrinkName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
