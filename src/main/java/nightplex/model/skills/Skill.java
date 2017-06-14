package nightplex.model.skills;

import nightplex.util.ExperienceHandler;

/**
 * Created by steven.tihomirov on 14.6.2017.
 * Highest level of skill to have common data.
 */
public abstract class Skill {

    public abstract int getExp();

    public abstract void setExp(int i);

    public void addExp(int amount) {
        setExp(getExp() + amount);
    }

    public int getLevel() {
        return ExperienceHandler.getLevel(getExp());
    }
}
