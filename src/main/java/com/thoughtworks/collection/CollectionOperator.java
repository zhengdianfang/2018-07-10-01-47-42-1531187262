package com.thoughtworks.collection;

import com.google.common.collect.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int min = Math.min(left, right);
        int max = Math.max(left, right);
        return IntStream.rangeClosed(min, max).boxed()
                .sorted(left < right ? Comparator.naturalOrder() : Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int min = Math.min(left, right);
        int max = Math.max(left, right);
        return IntStream.rangeClosed(min, max)
                .filter(number -> number % 2 ==0)
                .boxed()
                .sorted(left < right ? Comparator.naturalOrder() : Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(number -> number % 2 ==0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array)
                .skip(array.length - 1)
                .boxed()
                .findFirst().orElse(0);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        first.retainAll(second);
        return first;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        return Streams.concat(Arrays.stream(firstArray), Arrays.stream(secondArray))
                .distinct()
                .collect(Collectors.toList());
    }
}
