package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14501 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, 0, n, t, p);

        System.out.println(ans);

    }

    static void recursion(int day, int sum, int n, int[] t, int[] p) {

        if (day == n + 1) {
            if (ans < sum) ans = sum;
            return;
        }

        if (day > n + 1) {
            return;
        }
        recursion(day + 1, sum, n, t, p);
        recursion(day + t[day], sum + p[day], n, t, p);

    }


}

//문제 : 퇴사 (브루트포스)