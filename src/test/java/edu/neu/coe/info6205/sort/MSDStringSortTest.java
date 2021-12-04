package edu.neu.coe.info6205.sort;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MSDStringSortTest {

    String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
    String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");

    @Test
    public void sortSeaShells() {
        MSDStringSort.sort(input);
        System.out.println(Arrays.toString(input));
        assertArrayEquals(expected, input);
    }

}
