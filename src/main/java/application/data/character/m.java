package application.data.character;

import java.util.concurrent.CancellationException;

import application.data.character.skills.Cooking;
import application.data.character.skills.Mining;
import application.data.character.skills.barkeeping.Barkeeping;

public class m {

	public static void main(String[] args) {
		
		
		
		 Mining mining = new Mining(98, 12300000);
		 mining.addExp(2000000);
		 System.out.println(mining.getLevel());
		 
		 
		 ExperienceHandler h = new ExperienceHandler();
		 System.out.println(h.expRequiredForLevel(99));
		 
		 Cooking c = new Cooking(1, 0);
		 
		 
	
		 
		
		 
		 
	}

}
