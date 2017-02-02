package nightplex.other;

public class ExperienceHandler {

	public static int checkForLevel(int xp, int level) {

		if (xp >= expRequiredForLevel(level + 1)) {

			return level + 1;

		}
		return level;

	}

	public static int expRequiredForLevel(int level) {

		double total = 0;

		for (int i = 1; i < level; i++) {

			total += Math.floor(i + 300 * Math.pow(2, i / 7.0));

		}

		return (int) Math.floor(total / 4);

	}
	

	
	
	
	public static int expRequiredUntilNextLevel(int xp, int level) {
		
		
		return expRequiredForLevel(level + 1) - xp;
		
		
	}

}
