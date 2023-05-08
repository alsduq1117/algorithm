package codeplus.algorithm_basic.practice;

import java.io.*;
import java.util.StringTokenizer;

public class p1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];  // 0 은 빨강, 1 은 초록, 2 는 파랑


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r_cost = Integer.parseInt(st.nextToken());
            int g_cost = Integer.parseInt(st.nextToken());
            int b_cost = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i][0] = r_cost;
                dp[i][1] = g_cost;
                dp[i][2] = b_cost;
            } else {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r_cost;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g_cost;
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b_cost;
            }

        }

        int min = 9999999;
        for (int i = 0; i < 3; i++){
            if(dp[N][i] != 0 && min > dp[N][i]){
                min = dp[N][i];
            }
        }
        System.out.println(min);
    }
}

//문제 : RGB 거리
//풀이 : 바로 전에 칠한 색깔을 저장하기 위해서 2차원 배열 dp 를 만들어 주었고, i 번째에 빨강색을 칠하기 위해서는 i-1 번째에 초록 혹은 파랑색으로 칠해져야 한다
//i-1 번째에서 초록색을 선택했을때의 비용과 파랑색을 선택했을때의 비용중 더 싼 값을 비교하여 넣어주고 거기에 i 번째에 빨강색을 칠한 비용을 더해서 저장해 준다

//알게 된 점: 나는 처음에 알고리즘을 풀기 위해 생각했던 말을 그대로 코드로 옮겨 넣었었다. 예를 들면 바로 전 이웃집이 빨강색 이였다면 초록,파랑 중 더 싼 비용의 가격을 더하고
//초록이면 dp[i][1] 에 값을 넣어주고 파랑이면 dp[1][2]에 값을 넣어줬다. 이렇게 하면 문제점이 밑 if 문에서 전 이웃집이 초록색 일때에도 똑같이 dp[i][2]를 택할 수도 있는데
//이렇게 되면 나중에 넣은 값만 넣어지기 때문에 기존에 구했던 값이 무용지물이 되버리는 사태가 생겼다. 그래서 강의에서 보여준 알고리즘을 적용하고 나서야 이해가 되었다..
//알고리즘을 좀 더 잘 풀고싶다..