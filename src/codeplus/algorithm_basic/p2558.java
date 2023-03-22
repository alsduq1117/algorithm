package codeplus.algorithm_basic;

import java.util.Scanner;



public class p2558 {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();


        if(a>0 && b<10) {
            System.out.println(a + b);
        }
        else{
            System.out.println("주어진 조건을 만족하지 않습니다.");
        }
    }
}

//풀이 1000번과 마찬가지로 코드는 비슷하다. 다만, Scanner 클래스의 nextInt() 메서드는 공백(space)이나 개행(enter)로 숫자를 구분하는 것을
//알아야 한다