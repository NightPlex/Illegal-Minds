package nightplex.util;

import nightplex.model.template.skills.barkeeping.DrinkSelected;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by steven.tihomirov on 14.6.2017.
 */
public class test {
    public static void main(String args[]) {

        DrinkSelected drinkSelected = new DrinkSelected();
        System.out.println(drinkSelected.getDrinkId());

    }

    public static void print(Map<String, Integer> d) {
        for(String l : d.keySet()) {
            System.out.println("String: " + l + " integer: " + d.get(l));
        }
    }
}
