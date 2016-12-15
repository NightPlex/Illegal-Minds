package application.data.character.skills.barkeeping;

public enum WineCellar {
	
	LIGHT_HOME_BREW(new String[] {"Barley", "Water", "Yeast", "Sugar"}, 2, 30, "Light homebrew"),
	HONEY_WINE(new String[] {"Water", "Honey"}, 14, 100, "Honey wine");

	
	private String[] requiredItems;
	private int levelRequired, xpGiven;
	private String name;
	
	
	private WineCellar(String[] requiredItems, int levelRequired, int xpGiven, String name) {
		this.requiredItems = requiredItems;
		this.levelRequired = levelRequired;
		this.xpGiven = xpGiven;
		this.name = name;
	}


	public String[] getRequiredItems() {
		return requiredItems;
	}


	public void setRequiredItems(String[] requiredItems) {
		this.requiredItems = requiredItems;
	}


	public int getLevelRequired() {
		return levelRequired;
	}


	public void setLevelRequired(int levelRequired) {
		this.levelRequired = levelRequired;
	}


	public int getXpGiven() {
		return xpGiven;
	}


	public void setXpGiven(int xpGiven) {
		this.xpGiven = xpGiven;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	


}
