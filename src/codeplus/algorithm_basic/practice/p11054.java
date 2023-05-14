package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] dp1 = new int[n + 1]; // 증가하는 수열 부분
        int[] dp2 = new int[n + 1]; // 감소하는 수열 부분
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int max = -99999;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp1[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (a[i] > a[j] && dp1[i] < dp1[j] + 1) {
                        dp1[i] = dp1[j] + 1;
                    }
                }
            }
            for (int i = k; i <= n; i++) {
                dp2[i] = 1;
                for (int j = k; j < i; j++) {
                    if (a[i] < a[j] && dp2[i] < dp2[j] + 1) {
                        dp2[i] = dp2[j] + 1;
                    }
                }
            }
            if( max < dp1[k] + Arrays.stream(dp2).max().getAsInt() - 1 ){
                max = dp1[k] + Arrays.stream(dp2).max().getAsInt() - 1;
            }
        }
        System.out.println(max);
    }
}


//문제 : 가장 긴 바이토닉 부분 수열
//알고리즘 : 1 ~ k 까지 증가하는 부분 수열의 길이와 k 부터 n 까지 감소하는 부분 수열의 길이 중 가장 긴 것을 구해야 한다.
//증가하는 부분 수열 알고리즘과 감소하는 부분 수열의 알고리즘을 이용해서 증가하는 부분은 k 번째 에서의 가장 긴 값이고,
//감소하는 부분은 k 부터 n 까지 감소하는 부분 수열 중 가장 긴 수열을 더해서(n 번째일때가 가장 긴 수열이 항상 아님!)
//-1 을 해준다(k 가 겹치기 때문에)
//배운점 : 정답 코드를 살펴보니 다른 방식으로 푼 것이 많았다. 나는 감소하는 부분 수열을 구할때 n부터 값을 구하는 것이 아닌
//k 부터 올라가면서 값을 구하기 때문에 답 처럼 풀게되면 틀리게 되었다.어찌저찌 풀긴 했지만 n 부터 거꾸로 구하면 더 쉽게 구할 수 있다는 것을 알았다..