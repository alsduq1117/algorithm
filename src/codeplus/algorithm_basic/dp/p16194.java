package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");


        int[] P = new int[1000];     // 가격 배열
        int[] dp = new int[1000];    // 최소 가격
        Arrays.fill(dp, 1000 * 10000);
        dp[0] = 0;


        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] > P[j] + dp[i - j]) {
                    dp[i] = P[j] + dp[i - j];
                }
            }
        }

        System.out.println(dp[N]);


    }
}

//분류: 카드 구매하기 2(dp)
//알고리즘 : 최소 가격으로 카드팩을 사기 위해서, i장을 샀을 때의 최소 가격을 담은 dp[i] array를 1000*10000(1장 최대 만원, 최대 1000장까지) 초기화 해주고
//dp[n] = dp[n-i] + p[i] 이다. 따라서 이 식을 코드에 옮기고 이중 for 문을 돌리게 되면 bottom up 방식으로 1장부터 ~ N 장 까지의 최소 가격을 알 수 있다.
//배운점 : 최소 값을 구하기 위해서는 배열을 초기화 할때 나올수 값중 최대 값으로 초기화 해서 넣어주는 방법을 사용해야 한다.