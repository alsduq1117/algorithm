package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        //bottom up 방식
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        System.out.println(dp[n]);

    }
}

//분류 : 2xn 타일링(DP)
//알고리즘 : 2xn 타일이있을때, 타일을 만들 수 있는 방법의 수를 구해야 한다. 2x1 에서는 세로 한칸 2x2 에서는 가로 두칸 + 세로 한칸 + 세로 한칸 으로 만들 수 있다.
//2x3 은 2x1 의 타일에다가 가로 두개짜리를 넣는 방법 1개랑(세로 2개는 세로 1개를 기준으로 보기때문에 제외) 2x2 의 2개에다가 세로 한칸을 붙이는 방법 2가지
//총 3가지가 있다. 따라서 점화식 dp[i] = dp[i-2] + dp[i-1] 에 따라서 코딩을 하면 된다.
//배운점: 생각 보다 많이 틀린 문제이다. 그 이유는 출력하는 부분에서 %10007을 한다는것을 모르고 있었기 때문이다.