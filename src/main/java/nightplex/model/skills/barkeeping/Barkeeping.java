package nightplex.model.skills.barkeeping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * First skill is bar keeping. Which includes everything needed to hold your bar.
 * 
 * */

@Entity
public class Barkeeping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	// Primary values::
	
	private int drinks; // amount of drinks available for sale.
	
	private int barkeepingLevel; // Skill level
	
	private int reputation;  // Your bar's reputation, of which popularity depends.
	
	
	
	//Bar keeping booleans.
	
	private boolean hasBoughtBar; // When you login, you have no bar. You need to pay  to get it.
	
	private boolean barIsClosed; // false - closed, no customers. True: Open and ready to server
	
	//Product storage -- raw materials for making drinks.. Need to order them in order to make drinks.
	
	private int storageCapacity; // Maximum amount of raw materials that can be stored
	
	@ManyToOne(cascade=CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
	private BarStorage barStorage; // All stored products.
	
	
	@ManyToOne(cascade=CascadeType.ALL) // Simply declaring that children table to be made also,  otherwise error.
    @JsonIgnore
	private KitchenStorage kitchenStorage; // Kitchen drinks stored here. 
	
	

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

	public int getBarkeepingLevel() {
		return barkeepingLevel;
	}

	public void setBarkeepingLevel(int barkeepingLevel) {
		this.barkeepingLevel = barkeepingLevel;
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

	public Barkeeping(int drinks, int barkeepingLevel, int reputation, boolean hasBoughtBar, boolean barIsClosed,
			int storageCapacity, BarStorage barStorage) {
		super();
		this.drinks = drinks;
		this.barkeepingLevel = barkeepingLevel;
		this.reputation = reputation;
		this.hasBoughtBar = hasBoughtBar;
		this.barIsClosed = barIsClosed;
		this.storageCapacity = storageCapacity;
		this.barStorage = barStorage;
	}

	public Barkeeping() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
