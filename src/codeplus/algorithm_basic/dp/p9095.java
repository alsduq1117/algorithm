package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        int[] array = new int[11];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;

        for (int i = 3; i < 11; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(array[n] + "\n");
        }

        System.out.println(sb);
    }
}

//분류 : 1,2,3 더하기 (dp)
//알고리즘 : 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하려면 n-1 일때는 +1 n-2일때는 +2, n-3 일때는 +3 을 해주면 되기 때문에
// 점화식 dp[n] = dp[n-1] + dp[n-2] + dp[n-3]이 나오게 된다.
//배운점 : 다른 사람의 코드를 보니 재귀를 사용하거나, array[0],array[1]을 초기화 하지 않고 점화식을 썼는데 뭐가 더 효율적인지 생각하고 반영해보자.
