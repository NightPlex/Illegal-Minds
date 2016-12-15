package application.data.character.skills;

import application.data.character.ExperienceHandler;
import application.data.character.PlayerStat;

public class Mining implements PlayerStat{
	
	private int level, exp;

	public Mining(int level, int exp) {
		super();
		this.level = level;
		this.exp = exp;
	}
	
	
	public void addExp(int amount) {
		exp += amount;
		 ExperienceHandler h = new ExperienceHandler();
		 
		 level = h.checkForLevel(exp, level);
		 
		 
		
	}
	
	
	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}




	
	
	

}
