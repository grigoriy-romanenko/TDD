package tdd.task_3_11_2;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static String reverse(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("input string is empty");
        }
        List<String> tempArray = new ArrayList<String>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i + 1));
        }
        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() - 1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }
}
