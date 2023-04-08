package codeplus.algorithm_basic.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //bottom up 방식
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        array[1] = 0;

        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0 && array[i] > array[i / 2] + 1) {
                array[i] = array[i / 2] + 1;
            }
            if (i % 3 == 0 && array[i] > array[i / 3] + 1) {
                array[i] = array[i / 3] + 1;
            }
        }

        System.out.println(array[n]);

    }
}

//분류: 1로 만들기(DP)
//알고리즘 : 어떤 수를 3으로 나누거나(나누어 떨어질때), 2로 나누거나, -1 을 할 수 있을때 1로 만들수 있는 최소한의 계산 횟수를 구해야한다.
// 그렇다면 3으로 나누기,2로 나누기,-1 순으로 우선순위를 정하여 숫자를 계산하면 되는거 아닌가요? 정답만 말하자면 아니다! 이런식으로 풀때의
// 알고리즘을 그리디 알고리즘이라고 하는데 10의경우 10 5 4 2 1 보단 10 9 3 1 이 더 최소한의 연산을 가진다. 따라서 이 문제에서는 그리디 알고리즘
//이 아닌 DP 알고리즘을 사용한다. 나는 DP 알고리즘을 bottom up 방식을 사용하여 구현하였는데 이 방식은 가장 작은 문제부터 해결해 나가는 방식이다.
//코드를 보면, array[2] 부터 최소값으로 채워나가서 3, 4, 5 ....,n 까지 최소값을 구하게 되는 방식이다.
//배운점 : DP 알고리즘을 학교에서 이론으로만 배우고 막상 코드로 옮기려고 하니 머릿속이 복잡해 지는 느낌이 들었다.점점 익숙해져나가면 되겠지?
// topDown 은 재귀 호출 방식을, bottomUp 은 반복문을 사용하게 된다. 두가지 방법 모두다 푸는 방법을 숙지해두고 상황에 맞게 써나가는 연습을 해야겠다.