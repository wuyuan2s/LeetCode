import java.util.HashMap;
import java.util.Map;

public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("((()))"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("(("));
    }

    public static boolean isValid(String s) {
        while (s.contains("[]") || s.contains("{}") || s.contains("()")) {
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            s = s.replace("()", "");
        }
        return "".equals(s);
    }
}
