package nightplex.util;

import java.util.Map;

/**
 * Created by steven.tihomirov on 14.6.2017.
 */
public class test {
    public static void main(String args[]) {

        System.out.println(StringUtils.transferIntToStringTime(187));

    }

    public static void print(Map<String, Integer> d) {
        for(String l : d.keySet()) {
            System.out.println("String: " + l + " integer: " + d.get(l));
        }
    }
}
