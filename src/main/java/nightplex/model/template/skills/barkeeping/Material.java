package nightplex.model.template.skills.barkeeping;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class Material {
    private String name;

    private int amount;

    public Material() {
    }

    public Material(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Material(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
