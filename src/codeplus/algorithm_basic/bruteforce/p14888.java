package codeplus.algorithm_basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p14888 {

    static boolean b[] = new boolean[11];
    static int a[] = new int[11];

    static ArrayList<String> permutationArr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] num_array = new int[n];
        for (int i = 0; i < n; i++) {
            num_array[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] operator_Array = new int[4];  //0: 덧셈 , 1: 뺄셈 , 2: 곱셈 , 3:나눗셈
        for (int i = 0; i < 4; i++) {
            operator_Array[i] = Integer.parseInt(st2.nextToken());
        }

        int[] operArr = new int[n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                if (operator_Array[j] > 0) {        //걍 순서대로 수열 박아버리기 0 0 1 2 3 이런식으로
                    operArr[i] = j;
                    operator_Array[j]--;
                    break;
                }
            }
        }

        recursion(0, n, operArr);

        int max = -1000000000;
        int min = 1000000000;

        for (int i = 0; i < permutationArr.size(); i++) {
            String str = permutationArr.get(i);
            StringTokenizer st = new StringTokenizer(str, ",");
            int sum = num_array[0];

            for (int j = 1; j < n; j++) {
                int oper = Integer.parseInt(st.nextToken());
                sum = operateNum(sum, num_array[j], oper);
            }


            if (sum > max) {
                max = sum;
            }

            if (sum < min) {
                min = sum;
            }
        }

        System.out.println(max);
        System.out.println(min);


    }

    static void recursion(int index, int n, int[] operArr) {
        if (index == n - 1) {
            String str = "";
            for (int i = 0; i < operArr.length; i++) {
                if (i == operArr.length - 1) {
                    str += a[i];
                } else {
                    str += a[i] + ",";
                }

            }
            permutationArr.add(str);
        }

        for (int i = 0; i < operArr.length; i++) {
            if (b[i]) continue;
            b[i] = true;
            a[index] = operArr[i];
            recursion(index + 1, n, operArr);
            b[i] = false;
        }

    }

    static int operateNum(int sum, int element, int oper) {

        switch (oper) {
            case 0:
                sum += element;
                break;
            case 1:
                sum -= element;
                break;
            case 2:
                sum *= element;
                break;
            case 3:
                if (sum > 0) {
                    sum /= element;
                } else if (sum == 0) {
                    sum = 0;
                } else if (sum < 0) {
                    sum = (-sum);
                    sum /= element;
                    sum = (-sum);
                }
                break;
        }
        return sum;
    }

}

//문제 : 연산자 끼워넣기
//N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다.
//-연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.
//우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.
//알고리즘 : 순열을 이용하여


