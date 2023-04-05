package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int t = Integer.parseInt(br.readLine());


        while(t-- > 0){
            String str = br.readLine();
            st = new StringTokenizer(str," ");

            int n = Integer.parseInt(st.nextToken());
            long result =0;

            int[] array = new int[n];
            for(int i=0; i <n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    result += gcd(array[i],array[j]);
                }
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}


//분류 : GCD합 (수학)
//알고리즘 : 테스트케이스 t 를 받고 수의 개수 n 을 받아서 각 테스트 케이스마다 가능한 모든 쌍의 GCD 합을 출력해야 한다. GCD 알고리즘은 유클리드 호제법을 통해
// static 메소드로 구현을 했고 r = a % b , a = b , b = r 을 해주고 a 값을 리턴해주면 최대공약수 값이 리턴된다.(이때 a와 b 의 크기는 신경쓰지 않아도 된다)
// 그 뒤에 2중 for문을 통해서 가능한 모든 쌍의 GCD 값을 result 에 더해준다.
//배운점 : 처음에 답이 틀렸다고 나와서 왜그런가 봤더니 result 를 처음에는 int 형으로 선언해주었다고 long 형으로 바꿔주니 답이 맞게 되었다.
//저번에도 이와 비슷하게 int 형에서 값을 다 못담는 경우가 있었는데 좀 큰 수가 나올거 같다 싶으면 long 형으로 선언해주면 졸을 것 같다.
