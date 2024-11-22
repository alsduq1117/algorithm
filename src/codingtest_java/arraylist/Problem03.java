package codingtest_java.arraylist;

import java.util.Arrays;
import java.util.HashSet;


public class Problem03 {

    public static void main(String[] args) {
        int[] a = new int[]{5,0,2,7};
        System.out.println(Arrays.toString(Solution(a)));
    }

    public static int[] Solution(int[] numbers) {
        int first = 0;
        HashSet<Integer> set = new HashSet<>();
        while(first != numbers.length){
            for(int second = first + 1; second<numbers.length; second++){
                int sum = numbers[first] + numbers[second];
                set.add(sum);
            }
            first++;
        }

        return  set.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
