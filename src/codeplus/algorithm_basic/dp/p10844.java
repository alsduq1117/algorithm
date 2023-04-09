package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        long[][] dp = new long[101][];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; i <= 9; j++) {
                dp[i][j] = 0;
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
            }
        }
        System.out.println(result % 1000000000);
    }
}
