package com.sigmoid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReverseByIndexTest {

    private ReverseByIndex reverseByIndex;

    @BeforeEach
    void setUp() {

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80,
                90));

        reverseByIndex = new ReverseByIndex(list);
    }

    @Test
    void getSubList() {
        // given


        // when
        final LinkedList<Integer> reverseByIndexSubList = reverseByIndex.getSubList(2, 6);

        // then
        LinkedList<Integer> resultList = new LinkedList<>(Arrays.asList(30, 40, 50, 60, 70));
        assertEquals(resultList, reverseByIndexSubList);


    }

    @Test
    void subList_InvalidValues_IndexOutOfBounds() {
        try {
            final LinkedList<Integer> byIndexSubList = reverseByIndex.getSubList(23, 35);
            fail();
        } catch (RuntimeException e) {
            // expected output, test should skip from here as of now
        }
    }

    @Test
    void subList_InvalidValues_StartGreaterThanEnd() {
        try {
            final LinkedList<Integer> byIndexSubList = reverseByIndex.getSubList(7, 2);
            fail();
        } catch (RuntimeException e) {
            // expected output, test should skip from here as of now
        }
    }

    @Test
    void reverseListByIndex() {

        LinkedList<Integer> integerLinkedList = reverseByIndex.reverseListByIndex(2, 6);
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(70, 60, 50, 40, 30));
        assertEquals(expected, integerLinkedList);
    }

    @Test
    void replaceSubListInList() {
        reverseByIndex.reverse(2, 6);
        System.out.println(reverseByIndex.getLinkedList());
        assertEquals(new LinkedList<>(Arrays.asList(10, 20, 70,
                60, 50, 40, 30, 80, 90)), reverseByIndex.getLinkedList());
    }
}