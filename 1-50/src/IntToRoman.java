public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        int[] array;
        String[] strs;
        array = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        strs = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        StringBuilder result = new StringBuilder();
        String string;

            for (int i = 0; i < array.length; i++) {
                while (num >= array[i]) {
                    num -= array[i];
                    // string += strs[i]  // 效率低
                    result.append(strs[i]);
                }
            }

        return result.toString();
    }
}
