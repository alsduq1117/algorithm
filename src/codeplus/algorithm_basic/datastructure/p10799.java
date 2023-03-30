package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        char[] array = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(array[i]);
            } else if (array[i] == ')') {
                if (array[i - 1] == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
        }
        sb.append(result);
        System.out.println(sb);

    }
}

// 분류 : 쇠막대기(스택)
// 알고리즘 : () 처럼 붙어있는 괄호는 레이저이고(막대기 절단) ( 는 막대기의 시작, )는 막대기의 끝이다. ()로 막대기를 절단하게 되면 현재 스택에 남아 있는 ( 괄호의 개수
// 만큼 막대기가 이어져있으므로 stack.size 만큼 개수를 더해준다, 만약 붙어있는 괄호() 가 아닌 ) 만 나왔다면 막대기의 끝으로서 막대기가 끊기므로 +1만 추가된다.
// 배운점 : 스택을 생각하지 않는다면 알고리즘을 생각해내기 어려운 문제인것 같다.

