package codingtest_java.arraylist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem02 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] arr){
        Integer[] result = Arrays.stream(arr)
                .boxed()
                .distinct()
                .toArray(Integer[]::new);

        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }


}

//정수 배열을 받아 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution 함수 구현
//제약 조건 : 2 이상 1000 이하 , 각 배열의 데이터 값은 -100,000 이상 100,000 이하
