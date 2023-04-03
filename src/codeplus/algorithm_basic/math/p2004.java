package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int twoCnt = getCount(n, 2) - getCount(m, 2) - getCount(n - m, 2);
        int fiveCnt = getCount(n, 5) - getCount(m, 5) - getCount(n - m, 5);

        System.out.println(Math.min(twoCnt,fiveCnt));

    }


    public static int getCount(int n, int k) {
        int cnt = 0;

        while (n >= k) {
            cnt += n / k;
            n /= k;
        }

        return cnt;
    }
}


//분류 : 조합 0의 개수(수학)
//알고리즘 : 조합에서는 팩토리얼 0의 개수와 비슷하지만 2의 개수가 5의 개수보다 적은 경우가 존재하기 때문에 2의 개수일때와 5의 개수를 따로 계산하여 더 작은
//수를 출력해 준다.
//배운점 : 이 문제를 풀면서 runtime 에러 / By zero가 엄청 많이 나왔다 왜 나왔을까 의심되는 부분은 처음에 문제를 풀때 k 를 계속해서 제곱해주고