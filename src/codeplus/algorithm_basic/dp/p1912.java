package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] a = new int[n + 1];  //수열을 저장하는 배열
        int[] d = new int[n + 1];  //최대 연속 합을 저장하는 배열


        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = a[0];

        for (int i = 1; i < n; i++) {
            if (d[i - 1] + a[i] > a[i]) {
                d[i] = d[i - 1] + a[i];
            } else {
                d[i] = a[i];
            }
        }

        int max = -99999;  //음수의 경우도 있으므로
        for (int i = 0; i < n; i++) {
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

    }
}

//분류 : 연속합(dp)
//풀이 : 주어진 수열중에 연속된 몇 개의 수를 선택 해서 구할 수 있는 합 중 가장 큰 합을 구해야 한다. 이를 구하기 위해서는 지금까지 구한 연속합 d[i-1] 과
// 주어진 i번째 수열 값 a[i] 값을 더한 값이 a[i] 보다 크면 d[i] 에는 d[i-1] + a[i] 를 저장하고 그렇지 않다면 d[i] 에는 a[i] 값을 넣어준다.
// 쉽게 말하자면 i-1번째까지 구한 연속합을 i번째 수열 값을 더해도 더 커? 안크다면 다시 i번째부터 연속합을 구해나갈거야! 이다.
//배운점 : 모두 음수로 된 수열도 있기때문에 처음 max 값을 초기화 할때 0 이 아닌 적당한 음수 값으로 설정해 줘야 한다.