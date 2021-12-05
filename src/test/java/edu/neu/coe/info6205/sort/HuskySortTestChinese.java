package edu.neu.coe.info6205.sort;


import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

public class HuskySortTestChinese {

    @Test
    public void sortChinese(){
        String[] expected = new String[]{"阿安","阿彬","阿兵","阿冰冰","阿晨","阿称","阿丛","阿丹丹","阿德力","阿迪迪","阿迪江","阿迪雅","阿栋","阿繁","阿方","阿菲","阿飞儿","阿飞飞","阿芬","阿丰","阿夏","阿鲜","阿湘","阿晓","阿新","阿行","阿旭","阿轩","乔江","乔娇",};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);
    }


    @Test
    public void GeneralTest1() throws IOException {
        String[] a = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-sorted.txt",1000);
        String[] b = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-shuffled.txt",1000);

        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(b);

        for(int i=0;i<1000;i++){
            System.out.println(b[i]);
        }
        assertArrayEquals(a, b);

    }
}