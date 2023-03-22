package codeplus.algorithm_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        while (true) {
            str = br.readLine();

            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0)
                break;

            else
                sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}


//while(true)를 통해 일단 반복문을 돌려놓고 종료 조건이 맞으면 반복문을 종료해주는 아이디어가 필요하다.
