package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n+1]; //지워졌으면 true
        Arrays.fill(check,false);

        for(int i=2; i<=n; i++){
            //지워지지 않은 수
            if(check[i] == false){
                for(int j=i*2; j<=n; j+=i){
                    check[j] = true;
                }
            }
        }

        for(int i = m; i<=n; i++){
            if(check[i]==false && i>1){
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }
}

//분류: 에라토스테네스의 채(수학)
//알고리즘 : M 이상 N 이하의 소수를 구하고 싶을때 2부터 자기 자신을 제외한 2의 배수들을 싹 지워준다. 예를 들면 2를 제이한 나머지 4 ,6, 8, 10, 12, 14...
//를 배열에서 지운다. 그 다음 지워지지 않은 수 3을 제외한 나머지 6,9,12(2에서 이미 지워짐),15 이런식으로 쭉쭉 지워나가면 소수만 남게된다.
//배운점: 지금까지 풀어본 문제중에 가장 많이 정답을 틀렸었다.부등호 부터 시작해서 알고리즘은 알지만 어떻게 반복문을 통해 나타낼지도 굉장히 어려웠고, 머릿속에 있는
// 알고리즘을 코드로 옮기는 훈련을 많이 해야겠다고 생각했다. 또한 Arrays.fill 을 통해 배열을 초기화하는 방법에 대해서도 배우게 되었다
// 까먹지 않기위해 풀이를 다시 적어보자면 i는 2부터 N까지 만약 지워지지 않은 수 라면 j 는 (자기 자신 i)를 제외한 i*2, i*3, i*4 를 지워준다. (이때 사실은
// i*2 ~ i*(i-1) 까지는 이미 지워진 수 일 것이다. 하지만 int 형은 21억까지 밖에 저장할 수 없어서 stackOverFlow 가 발생할 수 있으므로 ,i*2 부터 처리해준다)
// 그렇게 N 까지의 i의 배수들을 다 지워주게 되면 소수들만 false로 남은 check array만 남게되는데 m부터 n까지 false인 안댁수룰 출력해주면 된다.