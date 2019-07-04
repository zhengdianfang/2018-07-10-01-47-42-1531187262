package com.thoughtworks.collection;


import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder, rightBorder);
        int max = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max)
                .filter(number -> number % 2 == 0)
                .sum();

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int min = Math.min(leftBorder, rightBorder);
        int max = Math.max(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max)
                .filter(number -> number % 2 != 0)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(number -> number * 3 + 2)
                .sum();

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(number -> number % 2 == 0 ? number : (number * 3 + 2))
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(number -> number * 3 + 5)
                .sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        if (collect.size() % 2 == 0) {
            return (collect.get(collect.size() / 2) + collect.get(collect.size() / 2 - 1)) / 2;
        }
        return collect.get(collect.size() / 2);

    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .average().orElse(0.0);


    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(number -> number % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return Streams.concat(
                arrayList.stream().filter(number -> number % 2 == 0).sorted(),
                arrayList.stream().filter(number -> number % 2 != 0).sorted(Collections.reverseOrder())
        ).collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i + 1 < arrayList.size()) {

                integers.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
            }
        }
        return integers;
    }
}
