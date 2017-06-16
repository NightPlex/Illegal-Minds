package nightplex.model.skills.barkeeping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitchenStorage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	private int filteredWater; // Requires water


	public KitchenStorage(int filteredWater) {
		super();
		this.filteredWater = filteredWater;
	}

	public KitchenStorage() {
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
