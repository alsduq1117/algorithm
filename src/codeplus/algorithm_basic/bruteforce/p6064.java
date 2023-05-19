package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            boolean find = false;
            st = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            x -= 1;
            y -= 1;


            for (int i = x; i <= m*n; i += m) {
                if (i % n == y) {
                    sb.append(i+1 + "\n");
                    find = true;
                    break;
                }
            }

            if (find == false) {
                sb.append(-1 + "\n");
            }

        }

        System.out.println(sb);
    }
}

//문제 : 카잉 달력 (bruteforce)
//알고리즘 : x 와 y 의 값은 어떤 값을 M 과 N 으로 나눠준 나머지 값이다. 이때 주의할 점은 카잉달력에서는 x 의 값이 M 일때 0 이 아닌 M 으로
//y의 값이 N 일때 0이 아닌 N 으로 <M,N> 으로 표시해줘야 하는데, 단순히 % 만 해주게 되면 이러한 값들을 처리해 주지 못하게 된다. 따라서 x , y 값에 -1 을
//먼저 해주게 되면, x,y 가 M,N 일때에도 달력에서 처리해 줄 수 있게 된다.대신 값을 구하고 그 값에 i+1을 해줘야 한다.
//여기서 가장 핵심 알고리즘은 브루트 포스라고 해서 i의 값을 1씩 증가시키면서 찾는게 아닌, 규칙성을 찾아서 m 만큼 넘어가면서 찾아주는것이다.

//배운점 : 브루트 포스라고 해서 하나하나 찾는게 아니라, 규칙성을 발견하면 그걸 이용해야 한다. 또한 x,y의 값에 -1을 해주는 동작들을 이해하지 못했었는데
//풀고 하나씩 복기해보니까 이해가 되는것 같았다.