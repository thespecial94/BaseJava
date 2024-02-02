package com.basejava.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {
        System.out.println("oddOrEven = " + oddOrEven(Arrays.asList(11, 18, 13, 40, 50, 91, 1)));
        System.out.println("minValue = " + minValue(new int[]{1, 2, 2, 7, 5, 3, 7, 9, 8}));
    }

    static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> numbers = integers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 != 0));
        return numbers.get(integers.stream().filter(x -> x % 2 != 0).count() % 2 == 0);
    }

    static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (result, x) -> result * 10 + x);
    }
}
