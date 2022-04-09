import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wuyuan
 * @since 2022-03-26 23:19
 *
 * 681
 *
 * @deprecated
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 * 示例 1：
 *
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 *
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 *
 */
public class BashballGame {

    private static final String add = "+";
    private static final String subtract = "C";
    private static final String dou = "D";

    public static void main(String[] args) {
//        String ops[] = {"5","2","C","D","+"};
        String ops[] = {"5", "-2", "4", "C", "D", "9", "+", "+"};
//        String ops[] = {"1","D","D","D"};

        System.out.println(calPoints(ops));
        ;
    }

    private static int calPoints(String[] ops) {
        int sum = 0;
        int flag = 0;
        List<Integer> array = new ArrayList<>();
        for (String op : ops) {
            if (add.equals(op)) {
                array.add(array.get(flag) + array.get(flag - 1));
                flag++;
            } else if (subtract.equals(op)) {
                array.remove(flag);
                flag = flag - 1;
            } else if (dou.equals(op)) {
                sum = array.get(flag) * 2;
                array.add(sum);
                flag++;
            } else {
                array.add(Integer.parseInt(op));
                flag = array.size() - 1;
            }
        }
        int count = 0;
//        System.out.println(array);
        for (int item : array) {
            count += item;
        }
        return count;
    }
}
