package edu.neu.coe.info6205.sort;


import com.ibm.icu.text.Collator;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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
    public void GeneralTest() throws IOException {
        String[] expected = FileUtil.readFileInRange("src/main/resources/sortedChinese.txt",5);
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(input);
        assertArrayEquals(expected, input);



    }
}