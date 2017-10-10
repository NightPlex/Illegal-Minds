package nightplex.applogic;

/**
 * Created by steven.tihomirov on 12.7.2017.
 */
public class CollectiveReward {

    private static CollectiveReward collectiveReward = new CollectiveReward();

    private CollectiveReward() {}

    private int rewardAmount;

    public static CollectiveReward getInstance() {
        return collectiveReward;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void addReward(int amount) {
        setRewardAmount(getRewardAmount() + amount);
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
}
