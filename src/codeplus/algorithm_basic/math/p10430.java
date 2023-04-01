package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();

        st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        sb.append((a + b) % c + "\n");
        sb.append(((a % c) + (b % c)) % c + "\n");
        sb.append((a * b) % c + "\n");
        sb.append(((a % c) * (b % c)) % c + "\n");

        System.out.println(sb);

    }
}

//분류: 나머지 연산(수학)
//알고리즘: (A+B)%C는 ((A%C) + (B%C))%C 와 같고, (A×B)%C는 ((A%C) × (B%C))%C 와 같다. 다만 빼기일때는 (A%C) - (B%C) 과정중에 음수가
//나올수도있는데 이때 java 는 -2로 인식한다고 한다. 따라서 엉뚱한 답이 나올 수 있으므로 ((A%C) - (B%C) + C)%C  처럼 +C 를 해주어서 음수가 나오는 것을 방지한다.
