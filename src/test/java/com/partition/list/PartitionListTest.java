package com.partition.list;

import com.partition.list.exception.NoAuthorizationSizeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PartitionListTest {


    @InjectMocks
    private PartitionList partitionList ;

    @Test
    public void shouldReturnSameListWithMaxSize() throws NoAuthorizationSizeException {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Collection<List<Integer>> result = partitionList.partiton(list, Integer.MAX_VALUE);
        assertThat(result.size(), is(1));
    }

    @Test
    public void shouldReturnListFromIntegerList() throws NoAuthorizationSizeException {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collection<List<Integer>> result = partitionList.partiton(integerList, 3);
        assertThat(result.size(), is(3));
    }

    @Test
    public void shouldReturnStringFromStringList() throws NoAuthorizationSizeException {
        List<String> stringList = Arrays.asList("A", "B", "C", "D");
        Collection<List<String>> result = partitionList.partiton(stringList, 2);
        assertThat(result.size(), is(2));
    }

    @Test
    public void shouldReturnObjectFromObjectList() throws NoAuthorizationSizeException {
        List<Object> objectList = Arrays.asList(new BigDecimal("1"), new String(), Boolean.valueOf(true));
        Collection<List<Object>> result = partitionList.partiton(objectList, 2);
    }

    @Test
    public void shouldReturnEmptyListFromNullList() throws NoAuthorizationSizeException {
        Collection<List<Object>> result = partitionList.partiton(null, 3);
        assertEquals(Collections.emptyList(), Collections.emptyList());
    }

    @Test
    public void shouldReturnEmptyListFromEmptyList() throws NoAuthorizationSizeException {
        List<String> emptyList = Collections.emptyList();
        Collection<List<String>> result = partitionList.partiton(emptyList, 2);
        assertThat(result.size(), is(0));

    }

    @Test
    public void shouldReturnExceptionIfNegativeSize() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        try {
            Collection<List<Integer>> result = partitionList.partiton(list, -2);
        } catch (NoAuthorizationSizeException e) {
            assertThat(e.getMessage(), is("Negative size is not valid"));
        }

    }

    @Test
    public void shouldReturnExceptionIfZeroSize() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        try {
            Collection<List<Integer>> result = partitionList.partiton(list, 0);
        } catch (NoAuthorizationSizeException e) {
            assertThat(e.getMessage(), is("Zero is not a valid size"));
        }
    }

}