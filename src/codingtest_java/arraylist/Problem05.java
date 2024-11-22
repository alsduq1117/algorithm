package codingtest_java.arraylist;

import java.util.Arrays;

public class Problem05 {

    public static void main(String[] args){
    }


    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};

            int[][] result = new int[arr1.length][arr2[0].length];


            for(int i=0; i<arr1.length; i++){
                for(int j=0; j<arr2[i].length; j++){
                    for(int k=0; k<arr2.length; k++){
                        result[i][j] += arr1[i][k] * arr2[k][j];
                    }
                }
            }

            answer = result;

            return answer;
        }
    }
}
