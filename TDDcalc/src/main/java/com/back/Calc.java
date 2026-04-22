package com.back;

public class Calc {
    public static int run(String content) {
        String[] str = content.split(" ");
        return search(str);
    }

    private static int search(String[] str) {
        int a = Integer.parseInt(str[0]);      // 현재 값
        String b = "+"; // 연산자
        int flag = 0;
        int sum = 0;    // 누적 값

        for (int i = 1; i < str.length; i++) {
            if (str[i].matches("[+\\-*]")) {
                if (b.equals("*")) {
                    flag = 1;
                } else if (b.equals("+") || b.equals("-")) {
                    sum = calculate(sum, b, a);
                }
                b = str[i];
            } else if (str[i].matches("-?\\d+")) {
                if (flag == 1) {
                    a = calculate(a, "*", Integer.parseInt(str[i]));
                    flag = 0;
                } else {
                    a = Integer.parseInt(str[i]);
                }
            }
        }
        sum = calculate(sum, b, a);
        return sum;
    }

    private static int calculate(int a, String b, int c) {
        return switch (b) {
            case "+" -> a + c;
            case "-" -> a - c;
            case "*" -> a * c;
            default -> a;
        };
    }
}
