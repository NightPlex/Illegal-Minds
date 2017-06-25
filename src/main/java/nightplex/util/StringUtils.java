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
        String newName = name.replace(" ", "_");
        newName.toLowerCase();
        return newName;
    }
}
