package codeplus.algorithm_basic.datastructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;

        str = br.readLine();
        int t = Integer.parseInt(br.readLine());

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        for (Character c : str.toCharArray()) {
            s1.push(c.toString());
        }

        while (t-- > 0) {
            String m = br.readLine();
            st = new StringTokenizer(m," ");
            String m1 = st.nextToken();  //명령어

            switch (m1) {
                case "L":
                    if (!s1.empty()) {
                        s2.push(s1.pop());
                    }
                    break;
                case "D":
                    if (!s2.empty()) {
                        s1.push(s2.pop());
                    }
                    break;

                case "B":
                    if (!s1.empty()) {
                        s1.pop();
                    }
                    break;
                case "P":
                    String m2 = st.nextToken();  //집어 넣을 문자
                    s1.push(m2);
                    break;
            }
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        while(!s2.empty()){
            bw.write(s2.pop());
        }

        bw.flush();
    }
}

// 분류 : 에디터 문제(스택)
// 알고리즘 : 커서를 중심으로 왼쪽 스택 오른쪽 스택을 만들어서 커서를 왼쪽으로 한 칸 움직이면(L명령어) 왼쪽 스택에서 pop 한 문자를 오른쪽 스택에 push 해주고 커서를 오른쪽으로 한 칸 움직이면(D명령어)
// 오른쪽 스택을 pop 한 문자를 왼쪽 스택에 push 해준다. 커서 왼쪽에 문자를 삭제하려면(B명령어) 왼쪽 스택을 pop 해준다. 마지막으로 커서 왼쪽에 $ 문자를 추가하려면(P $ 명령어)는 왼쪽 스택에 $를 push 한다.
// 마지막으로 왼쪽에 있는 스택을 모두 오른쪽 스택으로 옮겨주고 오른쪽 스택을 차례대로 pop 하며 출력해준다.
// 배운점 : 어떤 문자열은 띄어쓰기가 있고 어떤 문자열은 하나의 문자로 된것을 분류할때 Switch 와 Tokenizer를 사용하여 해당하는 명령일때만 nextToken 을 한번 더 해줘서 가져오면 되는것을 알게 되었다.
//
