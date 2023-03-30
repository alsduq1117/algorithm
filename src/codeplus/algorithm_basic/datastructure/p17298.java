package codeplus.algorithm_basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        int[] array = new int[t];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<t; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<t; i++){
            if(stack.empty()){

            }
        }


    }
}
