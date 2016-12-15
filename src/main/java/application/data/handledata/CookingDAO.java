package application.data.handledata;

import java.util.List;

import application.data.character.skills.Cooking;

public interface CookingDAO {
	
	public void addCooking(Cooking c);
	public void updateCooking(Cooking c);
	public List<Cooking> listCooking();
	public Cooking getPersonByUsername(String name);
	public void removeCooking(String name);

}
