public class StrStr {

    public static void main(String[] args) {

//       String haystack = "hello", needle = "ll";
       String haystack = "", needle = "";
//       String haystack = "aaaaa", needle = "bba";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
