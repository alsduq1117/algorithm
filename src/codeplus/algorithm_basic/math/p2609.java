package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);

        int lcm = (a * b) / gcd;

        sb.append(gcd + "\n");
        sb.append(lcm);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

//분류 : 최대공약수와 최소공배수(수학)
//알고리즘 : 최대 공약수(gcd)는 입력값 a,b 의 크기를 비교하고 swap할 필요업이 재귀를 이용하여 b가 0이 될때까지 (a,b) -> (b, a%b)를 해준다
//최대공배수(lcm)는 A*B = gcd * lcm 이므로 구한 A*B/gcd 를 해주면 쉽게 구할 수 있다.
//배운점 : A*B = gcd * lcm 인지 알게되었다.