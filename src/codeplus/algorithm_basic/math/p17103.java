package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());


        //소수 array
        boolean[] check = new boolean[1000001];
        Arrays.fill(check, false);  // 소수이면 false, 소수가 아니면 true
        check[0] = true;
        check[1] = true;


        //에라토스테네스의 체
        for (int i = 2; i < check.length; i++) {
            if (check[i] == false) {
                for (int j = i * 2; j < check.length; j += i) {
                    check[j] = true;
                }
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int result = 0;

            for (int i = 2; i <= n / 2; i++) {
                if (check[i] == false && check[n - i] == false) {
                    result += 1;
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}

//분류: 골드바흐의 파티션(수학)
//알고리즘 : 에라토스테네스의 체를 통해 소수 array를 만들어주고, 소수의 쌍을 구해야 하므로 2부터 2/n 까지 array[i] 도 소수고 array[n-i]도
// 소수이면 result + 1 해준다.
//배운점 : 소수 문제인데 처음에 문제 풀때 에라토스테네스의 체가 기억이 안나서 애를 좀 먹었다. 소수 문제는 바로 에라토스테네스의 체로 귀결되도록
//머릿속에 박아놔야 겠고, 에라토스테네스의 체 알고리즘 또한 가물가물 해서 처음에 부등호 실수로 오류가 났는데 확실하게 알고 넘어가야겠다고 생각했다.