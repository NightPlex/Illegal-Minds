package application.data.handledata;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import application.data.character.skills.Cooking;

public class CookingServiceImpl implements CookingService{
	
	private CookingDAO cookingDAO;

	public void setCookingDAO(CookingDAO cookingDAO) {
		this.cookingDAO = cookingDAO;
	}
	
	@Transactional
	public void addCooking(Cooking c) {
		this.cookingDAO.addCooking(c);
		
	}
	@Transactional
	public void updateCooking(Cooking c) {
		this.cookingDAO.updateCooking(c);
		
	}
	@Transactional
	public List<Cooking> listCooking() {
		return this.cookingDAO.listCooking();
	}
	@Transactional
	public Cooking getPersonByUsername(String name) {
		return this.cookingDAO.getPersonByUsername(name);
	}
	@Transactional
	public void removeCooking(String name) {
		this.cookingDAO.removeCooking(name);
		
	}
	
	
	

}
