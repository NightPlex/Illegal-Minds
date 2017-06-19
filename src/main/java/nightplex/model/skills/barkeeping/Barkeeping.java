package nightplex.model.skills.barkeeping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nightplex.model.skills.Skill;

import javax.persistence.*;
import java.util.Map;

/*
 * First skill is bar keeping. Which includes everything needed to hold your bar.
 * 
 * */

@Entity
public class Barkeeping extends Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Primary values::

    private int drinks; // amount of drinks available for sale. DONT NEED


    private int barkeepingExp; // exp

    private int reputation;  // Your bar's reputation, of which popularity depends.

    //Eager meaning that all data is loaded to master Account. Lazy not efficent here.
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "barkeeping_ingredients")
    @MapKeyColumn(name = "ingredient_name")
    @Column(name = "amount")
    private Map<String, Integer> ingredients;

    private boolean hasBoughtBar; // When you login, you have no bar. You need to pay  to get it.

    private boolean barIsClosed; // false - closed, no customers. True: Open and ready to server

    //Product storage -- raw materials for making drinks.. Need to order them in order to make drinks.

    private int storageCapacity; // Maximum amount of raw materials that can be stored

    @ManyToOne(cascade = CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
    private BarStorage barStorage; // All stored products.

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public boolean isHasBoughtBar() {
        return hasBoughtBar;
    }

    public void setHasBoughtBar(boolean hasBoughtBar) {
        this.hasBoughtBar = hasBoughtBar;
    }

    public boolean isBarIsClosed() {
        return barIsClosed;
    }

    public void setBarIsClosed(boolean barIsClosed) {
        this.barIsClosed = barIsClosed;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public BarStorage getBarStorage() {
        return barStorage;
    }

    public void setBarStorage(BarStorage barStorage) {
        this.barStorage = barStorage;
    }

    public Barkeeping(int barkeepingLevel, int barkeepingExp, int reputation, boolean hasBoughtBar, boolean barIsClosed,
                      int storageCapacity, BarStorage barStorage) {
        super();
        this.drinks = drinks;
        this.reputation = reputation;
        this.hasBoughtBar = hasBoughtBar;
        this.barIsClosed = barIsClosed;
        this.storageCapacity = storageCapacity;
        this.barStorage = barStorage;
        this.barkeepingExp = barkeepingExp;
    }

    public Barkeeping() {
        super();
    }

    @Override
    public String toString() {
        return "Barkeeping [id=" + id + ", drinks=" + drinks + ", barkeepingLevel=" + ", reputation="
                + reputation + ", hasBoughtBar=" + hasBoughtBar + ", barIsClosed=" + barIsClosed + ", storageCapacity="
                + storageCapacity + ", barStorage=" + barStorage + ", kitchenStorage="  + "]";
    }

    @Override
    public int getExp() {
        return barkeepingExp;
    }

    @Override
    public void setExp(int i) {
        barkeepingExp = i;
    }

    public void addIngredient(String ingredient, int amount) {
        Map<String, Integer> temp = getIngredients();
        if(temp.get(ingredient) != null) {
            temp.put(ingredient, temp.get(ingredient) + amount);
        } else {
            temp.put(ingredient, amount);
        }
    }

    public boolean removeIngredient(String ingredient, int amount) {
        Map<String, Integer> temp = getIngredients();
        if(temp.get(ingredient) == null || temp.get(ingredient) - amount < 0) {
            return false;
        }

        temp.put(ingredient, temp.get(ingredient) - amount);
        return true;
    }
}
