package codeplus.algorithm_basic.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        StringTokenizer st2;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][3];  //0 : 아무것도 없는 , 1: 위쪽 스티커 떼기   2: 아래쪽 스티커 떼기
            int[][] array = new int[n + 1][2];

            st1 = new StringTokenizer(br.readLine(), " ");     //첫번째 행
            st2 = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                array[i][0] = Integer.parseInt(st1.nextToken());  //위쪽 스티커 점수 배열
                array[i][1] = Integer.parseInt(st2.nextToken());  //아래쪽 스티커 점수 배열
            }

            dp[1][0] = 0;
            dp[1][1] = array[1][0];
            dp[1][2] = array[1][1];


            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + array[i][0];
                dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1]) + array[i][1];
            }

            sb.append(Math.max(dp[n][2], Math.max(dp[n][0],dp[n][1]))+"\n");
        }

        System.out.println(sb);

    }
}



//문제 : 스티커(dp)
//알고리즘 : 스티커를 떼면 맞닿는 변에 있는 스티커는 떼지 못한다. 따라서 3가지 경우에 따라 점화식을 구할 수 있다. i 번째에서 스티커를
//떼지 않는 방법, i 번째에서 위쪽의 스티커를 떼는 방법, i 번째에서 아랫쪽의 스티커를 떼는 방법이다.
//i 번째에서 스티커를 떼지 않는건 i-1 에 뭘 하던 상관없이 자유롭게 가능하다.
//i 번째에서 위쪽 스티커를 뗄때는 i-1 번째에서 위쪽 스티커를 뗀 경우는 빼야 한다.
//i 번째에서 아랫쪽 스티커를 뗄때는 i-1 번째에서 아랫쪽에서 스티커를 뗀 경우를 빼야한다.
//배운점 : 항상 2개의 최대 값을 구할때 Math.max 를 이용해서 구햇는데 여러개의 경우 collection 함수 max 를 사용하거나,
//3개 일때는 Math.max를 겹쳐서 사용해주면 되는것을 알게 되었다.
