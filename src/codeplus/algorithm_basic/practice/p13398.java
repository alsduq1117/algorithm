package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13398 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 2];
        int[] dl = new int[n + 2];               //i번째 까지의 최대 연속합
        int[] dr = new int[n + 2];               //i번째 부터 시작하는 최대 연속합
        dl[0] = -9999;
        dr[n + 1] = -9999;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dl[i] = a[i];
            if (dl[i] < dl[i - 1] + a[i]) {
                dl[i] = dl[i - 1] + a[i];
            }
        }

        for (int i = n; i >= 1; i--) {
            dr[i] = a[i];
            if (dr[i] < dr[i + 1] + a[i]) {
                dr[i] = dr[i + 1] + a[i];
            }
        }


        int max = -9999;
        for (int i = 1; i <= n; i++) {          //숫자를 제거하지 않은 경우
            if (max < dl[i]) {
                max = dl[i];
            }
        }

        for (int i = 1; i <= n; i++) {         //숫자를 제거한 경우
            if (max < dl[i-1] + dr[i+1]) {
                max = dl[i-1] + dr[i+1];
            }
        }

        System.out.println(max);


    }
}


//문제 : 연속합 2 (dp)
//알고리즘 : 연속합의 최대 값을 구하는 문제(숫자를 하나 지울 수 있음) i번째 숫자 전 과 후를 생각해야 한다
//0 부터 i 번째 까지의 연속합을 구하는 배열 dl 과
//i 번째 부터 n 까지의 연속합을 구하는 배열 dr 을 구해야 하는데(dr 의 경우 n번째부터 거꾸로 구해야 한다)
//만약 지우지 않을 경우의 연속합의 최대 값과 i번째 값을 지울 경우를 비교해서 최대 값을 구해주면 된다.
//배운점 : 처음 접근했던 방식은 배열의 값을 차례대로 0으로 만들어 주면서 그 숫자를 뺏을때의 연속합의 최대값을 다 구해서 비교해주려고 했는데
//이 방법을 쓰려면 배열에 값을 다시 넣어줘야 하는 번거로움과 계산을 굉장히 많이 해야 했다..
//정답코드를 보고 과연 내가 dl, dr 과 같은 방법을 생각해 낼 수 있을까....라는 생각이 많이 드는 문제였다.. 박다보면 될거라고 믿는다!