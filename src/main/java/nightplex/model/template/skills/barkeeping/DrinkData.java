package nightplex.model.template.skills.barkeeping;

import java.util.List;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class DrinkData {

    private int id;
    private String drinkName;
    private int experience;
    private List<Material> material;

    public DrinkData() {
    }

    public DrinkData(int id, String drinkName, int experience, List<Material> material) {
        this.id = id;
        this.drinkName = drinkName;
        this.experience = experience;
        this.material = material;
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
