package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;

public class MSDStringSortTest {

    String[] input = "she sells seashells by the seashore the shells she sells are surely seashells".split(" ");
    String[] expected = "are by seashells seashells seashore sells sells she she shells surely the the".split(" ");

    @Test
    public void sortSeaShells() {
        MSDStringSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sort1000_English_words() throws IOException {


        String[] a = FileUtil.readFileInRange("src/main/resources/1000-english-words-shuffled.txt",1000);
        String[] b = FileUtil.readFileInRange("src/main/resources/1000-english-words-shuffled.txt",1000);

        Arrays.sort(a);
        MSDStringSort.sort(b);

        assertArrayEquals(a, b);

    }

    String[] input1 = "Lorem ipsum dolor sit amet".split(" ");
    String[] expected1 = "Lorem amet dolor ipsum sit".split(" ");

    @Test
    public void sortEnglishString() {
        MSDStringSort.sort(input1);
        assertArrayEquals(expected1, input1);
    }



}
