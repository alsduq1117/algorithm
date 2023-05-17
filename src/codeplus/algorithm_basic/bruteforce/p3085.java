package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] array = new char[n][n];

        for (int i = 0; i < n; i++) {                    //배열 초기화
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {            //좌,우 캔디 바꾸기
                char temp = array[i][j];
                array[i][j] = array[i][j + 1];
                array[i][j + 1] = temp;

                int max_candy = check_max_candy(array, n);
                if (ans < max_candy) {
                    ans = max_candy;
                }

                array[i][j + 1] = array[i][j];       //배열 다시 되돌리기
                array[i][j] = temp;
            }

            for (int k = 0; k < n - 1; k++) {
                char temp = array[k][i];              //위 아래로 캔디 바꾸기
                array[k][i] = array[k+1][i];
                array[k+1][i] = temp;

                int max_candy = check_max_candy(array, n);
                if (ans < max_candy) {
                    ans = max_candy;
                }

                array[k+1][i] = array[k][i];
                array[k][i] = temp;                     //배열 다시 되돌리기
            }
        }

        System.out.println(ans);

    }

    private static int check_max_candy(char[][] array, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int continue_candy = 1;
            for (int j = 0; j < n - 1; j++) {              //가로로 가장 연속되는 캔디 수 구하기
                if (array[i][j] == array[i][j + 1]) {
                    continue_candy += 1;
                    if (ans < continue_candy) {
                        ans = continue_candy;
                    }
                } else {
                    continue_candy = 1;
                }
            }
        }

        for (int i = 0; i<n; i++) {
            int continue_candy = 1;
            for (int j = 0; j < n - 1; j++) {               //세로로 가장 연속되는 캔디 수 구하기
                if (array[j][i] == array[j + 1][i]) {
                    continue_candy += 1;
                    if (ans < continue_candy) {
                        ans = continue_candy;
                    }
                } else {
                    continue_candy = 1;
                }
            }
        }

        return ans;
    }
}


//문제 : 사탕 게임
//알고리즘 : 사탕을 좌우, 위아래로 바꾸면서 해당하는 배열의 최대 연속되는 캔디 값을 구하면 된다..(브루트 포스라 하나하나 구해줘야 함)
//배운점 : 브루트 포스 알고리즘은 그냥 별다른 알고리즘 없이 하나하나 구하면 된다고 해서 그렇게 어렵지 않을 줄 알았는데
//엄청나게 시간이 오래걸렸던 문제 였던 것같다. 일단 2차원 배열의 행과 열에 대한 개념이 제대로 잡히지 않아서 머릿속으로 사탕을 옮기는데 그걸
//코드로 옮기는 것이 어려웠고, 사탕의 위치를 바꿔준 뒤에 배열의 위치를 다시 원래대로 되돌려준다는것을 초반에 생각을 못했던 것 같다.
//그리고 메소드를 잘 이용해서 문제를 풀어야 고생을 안한다는 것을 깨닫게 되었다.