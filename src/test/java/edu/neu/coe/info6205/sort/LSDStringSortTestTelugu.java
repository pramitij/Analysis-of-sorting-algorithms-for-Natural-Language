package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class LSDStringSortTestTelugu {

    @Test
    public void sortTeluguWords() {
        String[] unsortedTelugu = new String[]{"నటుడు", "బానందం", "అన్నారు", "కరోనా"};
        String[] sortedTelugu = new String[]{"అన్నారు", "కరోనా", "నటుడు", "బానందం" };

        LSDStringSort.sort(unsortedTelugu);
        System.out.println(Arrays.toString(unsortedTelugu));
        assertArrayEquals(sortedTelugu, unsortedTelugu);
    }

    @Test
    public void sortShuffledTelugu() throws IOException {
        List<String> a = FileUtil.readFile("src/main/resources/shuffledTelugu.txt");
        List<String> b = FileUtil.readFile("src/main/resources/shuffledTelugu.txt");
        String[] aArray = new String[a.size()];
        String[] bArray = new String[b.size()];
        a.toArray(aArray);
        b.toArray(bArray);

        Arrays.sort(bArray);

        LSDStringSort.sort(aArray);
        assertArrayEquals(aArray, bArray);

    }


}
