package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 2];
        array[0] = 0;
        array[1] = 1;
        array[2] = 3;

        for (int i = 3; i <= n; i++) {
            array[i] = (array[i - 1] + (2 * array[i - 2])) % 10007;
        }

        System.out.println(array[n]);
    }
}


//분류 : 2xn 타일링 2
//알고리즘 : 2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수는 2 x (n-2)의 직사각형에 2x1 2개를 추가하거나, 2x2 1개를 추가하면 되고
// 2 x (n-1) 의 직사각형에 1x2 직사각형 하나를 추가해야 한다. 따라서 점화식은 2xn = 2x(2xn-2) + 2x(2xn-1) 이다.
//배운점 : n에 1값을 넣으면 array[0],array[1],array[2] 를 초기화 하기 위해  배열의 크기를 n+2로 설정 해야 했다.