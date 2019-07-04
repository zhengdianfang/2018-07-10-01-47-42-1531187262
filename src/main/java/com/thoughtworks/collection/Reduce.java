package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public double getMinimum() {
        return this.arrayList.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    public double getAverage() {
        return this.arrayList.stream().mapToInt(number -> number).average().orElse(0);
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream()
                .filter(number -> number % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        if (collect.size() % 2 == 0) {
            return (collect.get(collect.size() / 2) + collect.get(collect.size() / 2 - 1)) / 2;
        }
        return collect.get(collect.size() / 2);
    }

    public int getFirstEven() {
        return this.arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int num = this.arrayList.stream()
                .filter(number -> number % 2 == 0)
                .findFirst().get();

        return this.arrayList.indexOf(num);
    }

    public boolean isEqual(List<Integer> arrayList) {
        this.arrayList.sort(Comparator.naturalOrder());
        arrayList.sort(Comparator.naturalOrder());
        return Arrays.equals(this.arrayList.toArray(), arrayList.toArray());

    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        return this.arrayList.stream()
                .filter(number -> number % 2 != 0)
                .reduce((first, second) -> second)
                .get();
    }

    public int getIndexOfLastOdd() {
        int num = this.arrayList.stream()
                .filter(number -> number % 2 != 0)
                .reduce((first, second) -> second)
                .get();
        return this.arrayList.indexOf(num);
    }
}
