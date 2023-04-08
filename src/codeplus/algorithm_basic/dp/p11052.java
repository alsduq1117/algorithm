package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  //민규가 구매하려고 하는 카드의 개수

        st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            int maxPrice = 0;
            for (int j = 1; j <= i; j++) {
                if (maxPrice < p[j] + dp[i - j]) {
                    maxPrice = p[j] + dp[i - j];
                }
            }
            dp[i] = maxPrice;
        }

        System.out.println(dp[n]);
    }
}

//분류: 카드 구매하기(dp)
//알고리즘 : 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오.
//예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다. 2개 들어있는 카드팩을 2번 사면 된다.
//이 문제를 풀기 위해서는 마지막 카드팩에는 i개의 카드가 들어있고 가격은 p[i] 이다. 그렇다면 그 전까지 구매한 카드팩에서 카드의 개수는 n-i 개이다. 따라서 dp라는 카드 가격의 배열이 있을때
// max(dp[n-i] + p[i]) -> dp[n] 이 된다.(i=1 부터 n 까지 가능)
//배운점 : bottom up 방식을 이용하여 dp 문제를 풀어나가는데 조금씩 익숙해져가고 있다. 하지만 재귀를 이용하는 top down 방식이 아직 구현방법을 잘 모르는 듯 해서 연습이 필요하다고 느꼈다.


