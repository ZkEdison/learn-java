package Day04;


import java.util.Random;
import java.util.Scanner;

/**
 * 猜字母游戏
 */
public class GuessDemo {
    public static void main(String[] args) {
        /**
         * 定义一个 5 个长度的字符数组用于存储系统所产生的5个字符，并定义变量记载用户所猜测的
         * 次数
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("GuessingGame>欢迎尝试猜字母游戏");

        int level = 20;
        char[] chs = new char[level];
        int score = 0;
        generate(chs);
        System.out.println(chs);

        System.out.println("GuessingGame>游戏开始，请输入你所猜的5个字母");
        while (true) {
            String inputStr = scanner.next().trim().toUpperCase();
            if ("EXIT".equals(inputStr)) {
                System.out.println("GuessingGame>谢谢你的尝试，再见！");
                break;
            }

            // 比较
            char[] input = inputStr.toCharArray();
            int[] result = check(chs, input);

            if (result[0] == level) {
                score = 100 * level - score * 10;
                System.out.println("GuessingGame>恭喜你猜对了！你的得分是：" + score);
                break;
            } else {
                System.out.println("uessingGame>你猜对" + result[1] + "个");
                score++;
            }
        }


        scanner.close();
    }

    public static int[] check(char[] chs, char[] input) {
        int [] result = new int[2];
        // result[0]:存储正确的位置个数
        // result[1]:存储正确的字符个数
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < chs.length; j++) {
                if (input[i] == chs[j]) {
                    result[1]++;
                    if (i == j) {
                        result[0]++;
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void generate(char[] chs) {
        /**
         * 定义一个数组letters存放所有字符，定义一个boolean类型的数组大小和letters数组大小相
         * 同，用来标识letters数组中的元素是否被选中，
         */
        char[] letters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        boolean[] flags = new boolean[letters.length];


        // 根据所需要产生的字符个数(5个) 随机产生字符数组, 且字符不能重复.
        Random random = new Random();
        for (int i = 0; i < chs.length; i++) {
            int index;
            do {
                index = random.nextInt(letters.length);
            } while (flags[index]);
            chs[i] = letters[index];
            flags[index] = true;
        }
    }
}
