public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord(String s) {
        String sub = s;
        // 可以简化为 s = s.trim()
        // 删除头尾空白字符
        while (sub.lastIndexOf(" ") == sub.length() - 1) {
            sub = s.substring(0, sub.length() -1);
        }
        int i = sub.lastIndexOf(" ");
        return sub.substring(i + 1).length();
    }
}
