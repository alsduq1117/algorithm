package codeplus.algorithm_basic.datastructure;

import java.io.*;

public class p9093 {
    public static char[] stack;
    public static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        int t = Integer.parseInt(br.readLine());

        stack = new char[1000];

        for (int i = 0; i < t; i++) {
            str = br.readLine() + "\n";
            for (char ch : str.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!empty()) {
                        bw.write(pop());
                    }
                    bw.write(ch);
                }
                else {
                    push(ch);
                }
            }
            bw.flush();
        }

    }

    public static void push(char ch) {
        stack[size] = ch;
        size += 1;
    }

    public static char pop() {
        size -= 1;
        return stack[size];
    }

    public static boolean empty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static char top() {
        return stack[size - 1];
    }

    public static int size() {
        return size;
    }


}

//분류 : 스택
//스택을 직접 만드는데 익숙해지고, str.toCharArray() 사용법 및 BufferWiter 사용법에 익힐수 있게 되었다.