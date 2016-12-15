package application.data.character;

public class ExperienceHandler {
	
	
	public int checkForLevel(int xp, int level) {
		
		if (xp >= expRequiredForLevel(level + 1)) {
			
			return level + 1;
			
		}
		return level;
		
	}
	
	public int expRequiredForLevel(int level) {
		
		double total = 0;
		
		
		for (int i = 0; i < level; i++) {
			
			total += Math.floor(i + 300*Math.pow(2, i/7.0));
			
		}
		
		return (int)Math.floor(total / 4);
		
	}
	

}
