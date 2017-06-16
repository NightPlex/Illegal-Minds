package nightplex.model.template.skills.barkeeping;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class Material {
    private int id;
    private String name;

    public Material() {
    }

    public Material(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
