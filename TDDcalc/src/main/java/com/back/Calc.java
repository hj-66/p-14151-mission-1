package com.back;

public class Calc {
    public static int run(String content) {
        String[] str = content.split(" ");
        int a = 0;
        String b = "+";

        for (String s : str) {
            if (s.matches("[+\\-*]")) { // 연산자 체크
                b = s;
            } else if (s.matches("\\d+")) { // 숫자 체크
                a = calculate(a, b, Integer.parseInt(s));
            }
        }

        return a;
    }

    private static int calculate(int a, String b, int c) {

        return switch (b) {
            case "+" -> a + c;
            case "-" -> a - c;
            default -> a;
        };
    }
}
