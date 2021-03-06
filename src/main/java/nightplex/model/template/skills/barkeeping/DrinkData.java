package nightplex.model.template.skills.barkeeping;

import java.util.List;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class DrinkData {

    private int id;
    private String drinkName;
    private int experience;
    private int level;
    private List<Material> material;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DrinkData() {
    }

    public DrinkData(int id, String drinkName, int experience, List<Material> material, int level) {
        this.id = id;
        this.drinkName = drinkName;
        this.experience = experience;
        this.material = material;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }
}
