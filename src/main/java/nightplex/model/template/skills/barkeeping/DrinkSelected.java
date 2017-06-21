package nightplex.model.template.skills.barkeeping;

/**
 * Created by steven.tihomirov on 21.6.2017.
 */
public class DrinkSelected {
    private int drinkId;

    public DrinkSelected(int drinkId) {
        this.drinkId = drinkId;
    }

    public DrinkSelected() {
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }
}
