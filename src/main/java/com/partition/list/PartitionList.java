package com.partition.list;

import com.partition.list.exception.NoAuthorizationSizeException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PartitionList {

    /**
     *
     * @param liste
     * @param size
     * @return Collection of list
     * @throws NoAuthorizationSizeException if size <= 0
     */
    public <T> Collection<List<T>> partiton(List<T> liste, int size) throws NoAuthorizationSizeException {

        if(liste == null) {
            return Collections.emptyList();
        }
        if(size < 0) {
            throw new NoAuthorizationSizeException("Negative size is not valid");
        }
        final AtomicInteger count = new AtomicInteger();
        try {
            Collection<List<T>> result = liste.stream().
                    collect(Collectors.groupingBy( item -> count.getAndIncrement() / size)).values();
            return result;
        } catch (ArithmeticException e) {
            throw new NoAuthorizationSizeException("Zero is not a valid size");
        }

    }
}
