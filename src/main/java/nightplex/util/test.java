package nightplex.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by steven.tihomirov on 14.6.2017.
 */
public class test {
    public static void main(String args[]) {

        Map<String, Integer> maps = new HashMap<>();

        maps.put("tea" , 12);
        maps.put("lego", 56);
        print(maps);
        maps.put("tea",32);
        print(maps);
        System.out.println(maps.get("ll"));

    }

    public static void print(Map<String, Integer> d) {
        for(String l : d.keySet()) {
            System.out.println("String: " + l + " integer: " + d.get(l));
        }
    }
}
