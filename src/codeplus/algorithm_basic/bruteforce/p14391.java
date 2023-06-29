package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //세로 크기
        int m = Integer.parseInt(st.nextToken()); //가로 크기

        int[][] arr = new int[n][m];


        for (int i = 0; i < n; i++) {             //숫자 받아서 배열에 저장
            String numbers = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = numbers.charAt(j) - '0';
            }
        }


        int max = 0;
        for (int s = 0; s < (1 << (n * m)); s++) { // 세로 n 개와 가로 m 개 모두 찾아야 하므로
            int sum = 0;
            //가로값 찾기
            for (int i = 0; i < n; i++) {      // 세로 한줄 한줄 마다
                int width = 0;                   //가로의 누적 값
                for (int j = 0; j < m; j++) {
                    int order_num = i * m + j;          //위에서부터 번호를 매겼을때의 순서 값  예시 1,2,3,4  다음줄 5,6,7,8 다음줄 9, 10, 11, 12
                    if ((s & (1 << order_num)) == 0) {
                        width = width * 10 + arr[i][j];     //연속된 가로의 수는 그 전의 수를 10 곱하고 넣어주기
                    } else {
                        sum += width;                     //가로가 끊겼으므로 sum 에 집어넣어주고 가로의 누적값을  0으로 다시 초기화
                        width = 0;
                    }
                }
                sum += width;                             //가로가 끝까지 않끊긴 경우 sum 에 안끊긴 값들을 더해준다.
            }

            //세로 값 찾기
            for (int j = 0; j < m; j++) {        //가로 한줄 한줄 마다
                int height = 0;
                for (int i = 0; i < n; i++) {
                    int order_num = i * m + j;

                    if ((s & (1 << order_num)) != 0) {        //세로 값이면
                        height = height * 10 + arr[i][j];
                    } else {                                 //세로가 끊겼으면
                        sum += height;
                        height = 0;
                    }
                }
                sum += height;
            }

            if (max < sum) {
                max = sum;
            }

        }
        System.out.println(max);
    }

}


//문제 : 종이 조각
//풀이 : 다시 풀어보기
