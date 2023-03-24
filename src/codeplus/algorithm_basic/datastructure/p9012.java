package codeplus.algorithm_basic.datastructure;

import java.io.*;
import java.util.Stack;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int cnt = 0;
            str = br.readLine();

            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    cnt += 1;
                } else {
                    cnt -= 1;
                }
                if (cnt < 0) {
                    break;
                }

            }
            if (cnt == 0) {
                bw.write("YES" + "\n");
            } else {
                bw.write("NO" + "\n");
            }

        }
        bw.flush();
    }
}

// 분류 : 괄호 문제 (스택)
// 알고리즘 : "(" 를 읽어올때는 count 증가 ")"를 읽어올때는 카운트 감소  count 가 0밑으로 내려가면 ")"의 개수가 스택에 들어가있는 "("의
// 개수보다 많아 진것이므로 괄호문자열이 아니다. for문을 마치고 cnt의 개수를 셌을때 0이면 괄호문자열이 맞고 cnt 가 0이 아닌 0보다 큰 수라면 "("의 개수가 ")"의 개수보다 많은 것이라 괄호문자열이 아니다.
// 배운점 : br.readLine(); 은 개행문자(엔터키)를 포함해 한줄을 전부 읽어오는 방식이다. while(t-- > 0) 을 통해 간단하게 테스트케이스 반복문 가능
// Stack<Integer> stack = new Stack<>()을 통해 Stack 생성 가능