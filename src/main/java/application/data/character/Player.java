package application.data.character;

import application.data.character.skills.Cooking;
import application.data.character.skills.Defence;
import application.data.character.skills.Gardening;
import application.data.character.skills.Mining;
import application.data.character.skills.Smithing;
import application.data.character.skills.Speed;
import application.data.character.skills.Stamina;
import application.data.character.skills.Strength;
import application.data.character.skills.Thieving;
import application.data.character.skills.barkeeping.Barkeeping;

public class Player {
	
	
	
	private String playerUsername;	
	private House playerHouse; // house part of player
	private PlayerStat playerData; // the money, credits and so on
	// Here are all the skills
	private Barkeeping playerBarkeeping;
	private Cooking playerCooking;
	private Defence playerDefence;
	private Gardening playerGardening;
	private Mining playerMining;
	private Smithing playerSmithing;
	private Speed playerSpeed;
	private Stamina playerStamina;
	private Strength playerStrength;
	private Thieving playerThieving;
	
	//States:
	
	
	
	
	
	//Constructor
	public Player(String playerUsername, House playerHouse, PlayerStat playerData, Barkeeping playerBarkeeping,
			Cooking playerCooking, Defence playerDefence, Gardening playerGardening, Mining playerMining,
			Smithing playerSmithing, Speed playerSpeed, Stamina playerStamina, Strength playerStrength,
			Thieving playerThieving) {
		super();
		this.playerUsername = playerUsername;
		this.playerHouse = playerHouse;
		this.playerData = playerData;
		this.playerBarkeeping = playerBarkeeping;
		this.playerCooking = playerCooking;
		this.playerDefence = playerDefence;
		this.playerGardening = playerGardening;
		this.playerMining = playerMining;
		this.playerSmithing = playerSmithing;
		this.playerSpeed = playerSpeed;
		this.playerStamina = playerStamina;
		this.playerStrength = playerStrength;
		this.playerThieving = playerThieving;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
