import java.util.*;

public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        String[] strings = new String[]{"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(strings));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] mos = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
                "-..-", "-.--", "--.."};
        Set<String> res = new HashSet<>(10);
        for (String w : words) {
            StringBuilder result = new StringBuilder();
            char[] chars = w.toCharArray();
            for (char c : chars) {
                result.append(mos[c - 'a']);
            }
//            System.out.println("result = " + result);
            res.add(result.toString());
        }
//        System.out.println("res = " + res);
        return res.size();
    }
}




