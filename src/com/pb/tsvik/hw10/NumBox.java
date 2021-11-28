package com.pb.tsvik.hw10;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

class NumBox<T extends Number> {

    private T[] numbers;
    private int count = 0;

    NumBox(Class<T> clazz, int maxCount) {
        this.numbers = (T[]) Array.newInstance(clazz, maxCount);
    }

    void add(T num) {
        if(count == numbers.length) throw new IllegalStateException();

        numbers[count] = num;
        count++;
    }

    T get(int index) {
        return numbers[index];
    }

    int length() {
        return count;
    }

    double sum() {
        return Stream.of(numbers)
                .limit(count)
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    double average() {
        return sum() / count;
    }

    Optional<T> max() {
        Optional<T> t = Stream.of(numbers)
                .limit(count)
                .max(Comparator.comparingDouble(Number::doubleValue));
        return t;
    }
}


