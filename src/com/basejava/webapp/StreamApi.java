package com.basejava.webapp;

import java.util.Arrays;
import java.util.List;

public class StreamApi {

    public static void main(String[] args) {
        System.out.println("oddOrEven = " + oddOrEven(Arrays.asList(11, 18, 13, 40, 50, 91, 1)));
        System.out.println("minValue = " + minValue(new int[]{1, 2, 2, 7, 5, 3, 7, 9, 8}));
    }

    static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream().filter(x -> x % 2 != 0).count() % 2 == 0 ?
                integers.stream().filter(x -> x % 2 != 0).toList() :
                integers.stream().filter(x -> x % 2 == 0).toList();
    }

    static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (result, x) -> result * 10 + x);
    }
}
