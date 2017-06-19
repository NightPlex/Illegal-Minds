package nightplex.model.skills.barkeeping;

import javax.persistence.*;

/**
 * Created by steven.tihomirov on 19.6.2017.
 */
@Entity
public class DrinkStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private int filteredWater; // Requires water


    public DrinkStorage(int filteredWater) {
        super();
        this.filteredWater = filteredWater;
    }

    public DrinkStorage() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFilteredWater() {
        return filteredWater;
    }

    public void setFilteredWater(int filteredWater) {
        this.filteredWater = filteredWater;
    }


}
