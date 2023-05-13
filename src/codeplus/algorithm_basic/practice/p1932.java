package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(max < dp[n][i]){
                max = dp[n][i];
            }
        }
        System.out.println(max);

    }
}


//문제 : 정수 삼각형
//알고리즘 : 맨 위층 시작해서 아래에 있는 수(대각선 왼쪽,오른쪽) 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성
//i번째 행 j번째 열에 있는 수는 i-1 번째 행의 j-1번째 열과 j 번째 열에 있는 숫자만 갈 수 있다. 따라서 이를 점화식으로 나타내면
//dp[i][j] = max( dp[i - 1][j - 1],   dp[i - 1][j]) + a[i][j] 이다.
//배운점 : 2차원 배열의 행과 열을 잘 구분할 수 있게 되었다.
