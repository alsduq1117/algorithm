package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int k = 1; //자릿수 표현


        for (int i = 10; i <= 100000000; i *= 10) {

            if (n - i < 0) {
                break;
            }
            k += 1;
        }

        int ans = 0;

        for (int i = 1; i < k; i++) {
            ans += 9 * Math.pow(10,i-1) * i;
        }

        ans += (n - Math.pow(10,k-1) + 1) * k;


        System.out.println(ans);

    }
}

//문제 : 수 이어 쓰기1
//알고리즘 : 1의 자릿수일때는 자릿수 +1씩 10의 자릿수일때는 +2씩, 100의 자릿수일때는 +3씩 .... 이런 규칙으로 늘어나게 된다
//1의자릿수는 총 9 - 1 + 1 = 9개 , 10의 자릿수는 99 - 10 + 1 = 90개 , 100의 자릿수는 999 - 100 + 1 = 900 ... 이런 규칙이 있다
//따라서 k를 통해 입력받는 숫자 n 의 자릿수를 파악한 뒤에(만약 n = 120 이라면, k = 3)
//k 자릿수 이하의 수들은 (9 * 10의 i-1 제곱) * i(자릿수)을 통해 for 문으로 계산하고
//k 자릿수는 (n - 10의 k-1제곱 + +1) * k 를 통해 계산해 준다
//배운점 : 자바는 거듭제곱을 계산할때 Math.pow 를 통해 계산할 수 있다는 것을 까먹고 있었다..