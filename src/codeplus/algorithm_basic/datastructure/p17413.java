package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringTokenizer st;

        char[] array = str.toCharArray();
        Stack<String> stack = new Stack<>();
        boolean k = false;  //false면 태그 안쪽  true면 태그 문자


        for (int i = 0; i < array.length; i++) {
            if (array[i] == '<') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                k = true;
                sb.append("<");
            } else if (array[i] == '>') {
                k = false;
                sb.append(">");
            } else if (k == false && array[i] == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            } else if (k == true && array[i] != '>') {
                sb.append(array[i]);
            } else if (k == false && array[i] != '<') {
                stack.push(String.valueOf(array[i]));
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());


    }
}

// 분류 : 단어뒤집기2 (스택)
// 알고리즘 : < > 태그문자들은 순서 그대로 태그안에 있는 문자들은 단어를 뒤집어서 출력해야한다. k 를 사용하여 태그 바깥인지 안쪽인지 구분해주도록 하였고
// 태그 바깥에서 ' ' 가 나오면 stack에 있는 문자들을 모두 출력하도록 한다. 마지막에는 스택에 남아있는 문자들을 출력한다.
// 배운점 : 일단 스택값이 존재하는데 stack.empty()를 while문에 집어넣어줘서 시간을 많이 소비해버렸다. !stack.empty() 해주는걸 다음엔 잊지 않도록 해야겠고,
// 처음에는 if 문을 가지고만 했었는데 하다보니 위에 if 문을 거쳐서 밑에 또 if 문을 거치는 문제가 발생했다. 그래서 else if문으로 바꿔서 해결하였다.
