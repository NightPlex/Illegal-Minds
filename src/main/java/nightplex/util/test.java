package nightplex.util;

import nightplex.applogic.CollectiveReward;

/**
 * Created by steven.tihomirov on 14.6.2017.
 */
public class test {
    public static void main(String args[]) {

        print();

    }

    public static void print() {
        CollectiveReward collectiveReward = CollectiveReward.getInstance();
        collectiveReward.addReward(34);
        System.out.println(collectiveReward.getRewardAmount());
    }
}
