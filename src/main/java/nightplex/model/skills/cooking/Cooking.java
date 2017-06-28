package nightplex.model.skills.cooking;

import nightplex.model.skills.Skill;

import javax.persistence.*;

/**
 * Created by steven.tihomirov on 28.6.2017.
 */
@Entity
public class Cooking extends Skill{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private int cookingExp;

    @Override
    public int getExp() {
        return cookingExp;
    }

    @Override
    public void setExp(int i) {
        this.cookingExp = i;
    }
}
