package nightplex.util;

/**
 * Created by NightPlex
 * Github: https://github.com/NightPlex
 *
 * @author NightPlex
 */
public class StringUtils {
    public static String convertFromIdToName(String name) {
        String newName = name.replace("_", " ");
        StringBuilder stringBuilder = new StringBuilder(newName);
        stringBuilder.setCharAt(0, Character.toUpperCase(newName.charAt(0)));
        return stringBuilder.toString();
    }

    public static String convertFromNameToId(String name) {
        return name.replace(" ", "_").toLowerCase();
    }

    public static String transferIntToStringTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return minutes + " minutes " + seconds + " seconds";
    }
}
