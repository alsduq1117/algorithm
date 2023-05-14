package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = A[i];

            for (int j = 1; j <= i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + A[i]){
                    dp[i] = dp[j] + A[i];
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}

//문제 : 가장 큰 증가하는 부분 수열 (dp)
//알고리즘 : 다시 풀어보기