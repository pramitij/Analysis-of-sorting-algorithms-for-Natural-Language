package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HuskySortTest {

    String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
    String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");

    @Test
    public void sortSeaShells() {
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        System.out.println(Arrays.toString(input));
        assertArrayEquals(expected, input);
    }

    String[] input1 = "Lorem ipsum dolor sit amet".split(" ");
    String[] expected1 = "Lorem amet dolor ipsum sit".split(" ");

    @Test
    public void sortEnglishString() {
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input1);
        System.out.println(Arrays.toString(input1));
        assertArrayEquals(expected1, input1);
    }



}