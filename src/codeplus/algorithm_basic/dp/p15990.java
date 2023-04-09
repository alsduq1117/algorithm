package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
                dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }


        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009 + "\n");
        }
        System.out.println(sb);
    }

}

//분류 : 1,2,3 더하기 5(dp)
//알고리즘 : 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 문제 단, 같은 수를 두 번 이상 연속해서 사용하면 안된다. D[i][j] = i 를 1,2,3 의 합으로 나타내는 방법의 수, 마지막에 사용한 수를 j 로 둔다
//i번째에서 1을 사용하기 위해선 dp[i-1]에서 마지막 수가 2 또는 3이여야 한다. 따라서 dp[i][1] = dp[i-1][2] + dp[i-1][3] 이다 이와 같은 방법으로 i 번째 수가 2 ,3 일때의 점화식은
// dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) , dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) 이다. 이 점화식을 통해 답을 도출 할 수 있다.
//배운점 : 배열을 초기화 해주는 작업이 좀 어려웠던 문제였던 것 같다. 일단 초기화를 어떤 것을 시켜줘야 할지 예를들면 [2][2], [3][1] 같은 것을 생각을 잘 해내야 점화식을 통해 쉽게 풀어 낼 수 있다.
//다른 문제를 만나게 되면 초기화 해주는 작업을 잘해보자!.