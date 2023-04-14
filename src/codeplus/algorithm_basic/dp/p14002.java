package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] a = new int[1001];   //수열을 저장하는 배열
        int[] dp = new int[1001];  //최대 수열 길이를 저장하는 배열
        int[] v = new int[1001];  //역추적을 위한 배열

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(st.nextToken());
            a[i] = k;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[j] + 1 > dp[i] && a[i] > a[j]) {
                    dp[i] = dp[j] + 1;
                    v[i] = j;
                }
            }
        }
        int max = 0;
        int t = 0; //최대 수열을 가지고 있는 수의 인덱스 값

        for (int i = 1; i <= n; i++) {
            if (max < dp[i]) {
                max = dp[i];
                t = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(a[t]);
        while (!(v[t] == 0)) {
            stack.push(a[v[t]]);
            t = v[t];
        }

        while (!stack.empty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(max);
        System.out.println(sb);

    }
}

//분류 : 가장 긴 증가하는 부분 수열4(dp)
//알고리즘 : 기존의 가장 긴 증가하는 부분수열(p11053)과 알고리즘이 같지만 추가적으로 가장 긴 증가하는 부분 수열을 출력해야한다
//그렇기 위해선 역추적을 해야하는데 모든 알고리즘에서의 역추적 방법은 똑같다. 배열을 만들어주고경로 DP배열의 값이 갱신될때 사용한 과거의 해의 위치를 저장한다.
//배운점 : 역추적을 하는 방법에 대해 배우게 되었다.
