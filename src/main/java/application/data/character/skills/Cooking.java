package application.data.character.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import application.data.character.ExperienceHandler;
import application.data.character.PlayerStat;


@Entity
@Table(name="Cooking")
public class Cooking implements PlayerStat{
	@Id
	@Column(name="username")
	private String username;
	private int level;
	private int exp;

	public Cooking(int level, int exp) {
		super();
		this.level = level;
		this.exp = exp;
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
