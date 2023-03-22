package codeplus.algorithm_basic;

import java.util.Scanner;

public class p10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            if (a > 0 && b < 10) {
                System.out.println(a + b);
            }
        }
    }
}

//테스트 케이스로 주어졌을 경우에는 입력,출력을 반복해준다