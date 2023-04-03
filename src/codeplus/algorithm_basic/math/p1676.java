package codeplus.algorithm_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //5의 개수만 가지고 판별

        int n1 = n/5; //인수로 5를 하나가지고 있는 n까지의 수
        int n2 = n/25; //인수로 5를 2개 가지고 있는 n까지의 수
        int n3 = n/125; //인수로 5를 3개 가지고 있는 n까지의 수

        System.out.println(n1+n2+n3);

    }
}

//분류 : 팩토리얼의 0의 개수 세기(수학)
//문제 : N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
//알고리즘 : 팩토리얼은 1x2x3x4x5x6.... 을 하는것인데 이것을 계산해서 0의 개수를 구하기란 쉽지않다. 따라서 0이 나올때의 특징을 파악해야하는데 0이 나오기 위해서는
// 소인수 분해를 하였을때 (2x5)가 몇번 나올지 파악하면 된다. 추가적으로 2의 개수는 항상 5의 개수보다 많으므로 인수로 5의 개수가 몇개있는지만 파악해주면 풀 수 있다.
//배운점: 팩토리얼을 구현하여 풀줄만 알지 사실 이런 응용문제를 해결하기 위해서는 어느정도 선행 지식이 필요하다고 느껴졌다.과연 문제로 나왔을때 선행 지식 없이 풀수있을까?
//의문이드는 간단해보이지만 어려운 문제였다.