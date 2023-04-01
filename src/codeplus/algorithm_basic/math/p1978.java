package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int result = 0;


        while (t-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (prime(num)) {
                result += 1;
            }
        }

        System.out.println(result);
    }

    public static boolean prime(int n) {
        if (n < 2) {               //2보다 작으면 소수가 아님
            return false;
        }
        for (int i = 2; i * i <= n; i++) {     //2부터 루트 n 까지의 숫자로 나눠진다면 소수가 아님
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//분류 : 소수 찾기(수학)
//알고리즘 : 보통은 2부터 n/2 까지의 숫자까지 나눠보며 나눠진다면 소수가 아니고 나눠지지 않는다면 소수라고 판별하는데 √n을 사용하면 시간복잡도를 크게 줄일 수 있다.
// 가령 24 의 약수를 나타내면 1,2,3,4,6,8,12,24 인데 √24(4.~~) 을 기준으로 좌우 숫자로 짝지어 진다. 4 x 6 , 3 x 8 , 2 x 12 이런식으로 그렇기 때문에
// √n 까지의 숫자로 나눠진다면 소수가 아니고 나눠지지 않으면 소수이다.