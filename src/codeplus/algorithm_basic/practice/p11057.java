package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] = dp[i][j] % 10007;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 10007;
        }

        System.out.println(result % 10007);
    }
}


//문제 : 오르막 수 (dp)
//알고리즘 : N 의 길이의 숫자가 오름차순으로 정렬되어 있는 경우의 수를 구하는 문제이다(같은 숫자는 연속해도 된다).
//dp[N][i] 은 N번째에 i 숫자가 들어오는 경우의 수 이다. i가 들어오기 위해선 N-1 번째에 i 혹은 i 보다 작은 수가 들어와야 한다. 따라서 점화식은 다음과 같다.
//dp[N][i] = dp[N-1][0] + ~~ + dp[N-1][i] 이다.

//배운점 : 처음에 문제를 풀었을때 3중 for문이 나와서 디버그를 돌려보니 엄청 많은 경우의 수를 돌길래 당연히 시간초과 틀릴줄 알아서 강의에 나온 풀이를 보니 똑같은 3중 for문을 사용해서 문제를 풀었다.
//3중 for문이라고 해서 틀린 답은 아니니까 다음에는 소신을 가지고 풀면 될 것같다.