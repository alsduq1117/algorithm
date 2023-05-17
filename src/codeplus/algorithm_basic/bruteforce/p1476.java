package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1476 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");


        int e = Integer.parseInt(st.nextToken());  //지구   <= 15
        int s = Integer.parseInt(st.nextToken());  //태양   <= 28
        int m = Integer.parseInt(st.nextToken());  //달     <= 19

        int ans = 0;

        if (e == 15) {
            e = 0;
        }
        if (s == 28) {
            s = 0;
        }
        if (m == 19) {
            m = 0;
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {

            if (i % 15 == e && i % 28 == s && i % 19 == m) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}

//문제 : 날짜 계산
//알고리즘 : 첫번째 입력은 어떤 수 i 를 15로 나눴을때의 나머지 값이고, 두번째 입력은 어떤 수 i 를 28로 나눴을때의 나머지 값이고
//세 번째 입력은 어떤 수 i 를 19로 나눴을때의 나머지 값이다. 그래서 세 조건을 만족하는 수를 반복문을 돌며 찾아주면 된다.
//배운점 : 15로 나눈 나머지 값이기 때문에 15가 들어오면 처리를 못해준다. 따라서 첫번째 입력으로 15가 들어오면 e 의 값을 0 으로 변환해주는
//작업을 해줘야 한다.