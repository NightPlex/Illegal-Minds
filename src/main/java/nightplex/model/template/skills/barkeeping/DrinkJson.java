package nightplex.model.template.skills.barkeeping;

import java.util.List;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */
public class DrinkJson {
    private List<DrinkData> data;

    public DrinkJson() {
    }

    public DrinkJson(List<DrinkData> data) {
        this.data = data;
    }

    public List<DrinkData> getData() {
        return data;
    }

    public void setData(List<DrinkData> data) {
        this.data = data;
    }
}

