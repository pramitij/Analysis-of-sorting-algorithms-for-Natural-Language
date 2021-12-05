package edu.neu.coe.info6205.sort;

import com.ibm.icu.text.Collator;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class DualPivotQuickSortTestChinese {

    @Test
    public void sortChinese() {

        String[] sortedChinese = new String[]{"阿冰", "阿冰冰", "阿超"};
        String[] unsortedChinese = new String[]{"阿超", "阿冰", "阿冰冰"};
        Arrays.sort(unsortedChinese);
        DualPivotQuickSortChinese.sort(unsortedChinese);
        System.out.println(Arrays.toString(unsortedChinese));
        assertArrayEquals(sortedChinese, unsortedChinese);
    }



    @Test
    public void GeneralTest() throws IOException {
        String[] a = FileUtil.readFileInRange("src/main/resources/1000-english-words-shuffled.txt",1000);
        String[] b = FileUtil.readFileInRange("src/main/resources/1000-english-words-shuffled.txt",1000);
        Collator collator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(a,(x1, x2)->collator.compare(x1,x2));
        DualPivotQuickSortChinese.sort(b);
        assertArrayEquals(a, b);
    }
}



