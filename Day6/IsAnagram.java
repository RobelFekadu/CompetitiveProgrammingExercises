import java.util.*;
public class IsAnagram{

    public boolean isAnagram(String s, String t) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        s = new String(temp);

        temp = t.toCharArray();
        Arrays.sort(temp);
        t = new String(temp);

        return s.equals(t);
    }
}