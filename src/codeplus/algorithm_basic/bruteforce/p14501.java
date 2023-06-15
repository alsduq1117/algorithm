package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14501 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        recursion(1, 0, n, t, p);

        System.out.println(ans);

    }

    static void recursion(int day, int sum, int n, int[] t, int[] p) {

        if (day == n + 1) {
            if (ans < sum) ans = sum;
            return;
        }

        if (day > n + 1) {
            return;
        }
        recursion(day + 1, sum, n, t, p);
        recursion(day + t[day], sum + p[day], n, t, p);

    }


}

//문제 : 퇴사 (브루트포스)
//알고리즘 : N+1일째에 퇴사를 하고 남은 N 일 동안 최대한 많은 금액을 받을 수 있도록 상담을 해야 한다.
//재귀함수를 이용하여 day 가 n+1 이 되면 최대값을 업데이트 해준다. 그리고 1~n까지는 만약 상담을 진행하지 않는 경우는  day+1 함수를 호출하는 경우이고
//그 날짜를 선택하여 상담을 진행했다면 상담을 진행하는 날짜 만큼 day에 + 해주고 sum 에도 pay 만큼 + 해주면 된다.
//배운점 : 재귀 알고리즘이 아직 익숙하지가 않기때문에 많이 문제를 풀어봐야 할 것 같다.