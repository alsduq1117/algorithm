package codingtest_java.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem18 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 15));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }
    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int element : arr) {
            if(hashSet.contains(target - element)){
                return true;
            }
            hashSet.add(element);
        }
        return false;
    }

}