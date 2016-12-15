package application.data.handledata;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import application.data.character.skills.Cooking;

public class CookingImpl implements CookingDAO{
	
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCooking(Cooking c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		System.out.println("Successfully added a Cooking");
		
	}

	public void updateCooking(Cooking c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		System.out.println("Successfully updated a Cooking");
		
	}

	@SuppressWarnings("unchecked")
	public List<Cooking> listCooking() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cooking> cookingList = session.createQuery("from Cooking").list();
		System.out.println("Successfully updated a Cooking");
		return cookingList;
	}

	public Cooking getPersonByUsername(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Cooking c = (Cooking) session.load(Cooking.class, new String(name));
		System.out.println("Successfully updated a Cooking");
		return c;
	}

	public void removeCooking(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Cooking c = (Cooking) session.load(Cooking.class, new String(name));
		System.out.println("Successfully updated a Cooking");
		
		if (null != c) {
			
			session.delete(c);
			
		}
		
	}

}
