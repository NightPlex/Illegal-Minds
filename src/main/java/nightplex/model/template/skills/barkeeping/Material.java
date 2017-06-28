package nightplex.model.template.skills.barkeeping;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class Material {
    private String name;

    private int amount;

    private int price;

    public Material() {
    }

    public Material(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public Material(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    public Material(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
