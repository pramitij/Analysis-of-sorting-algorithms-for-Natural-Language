package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TimSortTestTelugu {

    @Test
    public void sortTeluguWords() {
        String[] unsortedTelugu = new String[]{"నటుడు", "బానందం", "అన్నారు", "కరోనా"};
        String[] sortedTelugu = new String[]{"అన్నారు", "కరోనా", "నటుడు", "బానందం" };

        TimSort.sort(unsortedTelugu);
        assertArrayEquals(sortedTelugu, unsortedTelugu);
    }

    @Test
    public void sortShuffled_Telugu() throws IOException {
        List<String> a = FileUtil.readFile("src/main/resources/shuffled_Telugu.txt");
        List<String> b = FileUtil.readFile("src/main/resources/shuffled_Telugu.txt");
        String[] aArray = new String[a.size()];
        String[] bArray = new String[b.size()];
        a.toArray(aArray);
        b.toArray(bArray);

        Arrays.sort(bArray);

        TimSort.sort(aArray);

        assertArrayEquals(aArray, bArray);

    }



    @Test
    public void sortShuffledTelugu() throws IOException {
        List<String> a = FileUtil.readFile("src/main/resources/1000-telugu-words-shuffled.txt");
        List<String> b = FileUtil.readFile("src/main/resources/1000-telugu-words-shuffled.txt");
        String[] aArray = new String[a.size()];
        String[] bArray = new String[b.size()];
        a.toArray(aArray);
        b.toArray(bArray);
        Arrays.sort(bArray);
        TimSort.sort(aArray);

        assertArrayEquals(aArray, bArray);

    }


}
