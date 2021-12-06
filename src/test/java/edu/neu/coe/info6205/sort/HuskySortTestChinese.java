package edu.neu.coe.info6205.sort;


import com.ibm.icu.text.Collator;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HuskySortTestChinese {

    Collator collator = Collator.getInstance(Locale.CHINA);
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
        String[] a = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-shuffled.txt",1000);
        String[] b = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-shuffled.txt",1000);

        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(b);
        Arrays.sort(a,(x1, x2)->collator.compare(x1,x2));

        for(int i=0;i<50;i++){
            Assert.assertEquals(a[i], b[i]);
        }

    }

    @Test
    public void sortChinese1() {

        String[] sortedChinese = new String[]{"曾佳珍", "范亚文", "侯封", "江兆涛", "闫炳华", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛"};
        Arrays.sort(unsortedChinese);
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }

    @Test
    public void sortChinese2() {
        String[] sortedChinese = new String[]{"曾佳珍", "杜丽伟", "范成章", "范亚文", "冯翠君", "侯封", "江兆涛", "赖春宝", "李继翔", "廖前进", "刘久胜", "潘从伟", "闫炳华", "姚佳鑫", "应丽娜", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛", "刘久胜", "冯翠君", "赖春宝", "李继翔", "范成章", "杜丽伟", "廖前进", "姚佳鑫", "潘从伟","应丽娜" };
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(unsortedChinese);
        DualPivotQuickSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }

    @Test
    public void sortChinese3() {

        String[] sortedChinese = new String[]{"曾佳珍", "陈立昆", "杜丽伟", "范成章", "范亚文", "冯翠君", "顾新新", "侯封", "江兆涛", "赖春宝", "李继翔", "李开森", "廖前进", "林鸿森", "刘定基", "刘定基", "刘久胜", "潘从伟", "肖燕珊", "闫炳华", "杨列仁", "杨列仁", "姚佳鑫", "应丽娜", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛", "刘久胜", "冯翠君", "赖春宝", "李继翔", "范成章", "杜丽伟", "廖前进", "姚佳鑫", "潘从伟","应丽娜", "杨列仁", "杨列仁", "刘定基", "刘定基", "李开森", "肖燕珊", "林鸿森", "顾新新", "陈立昆"};
        new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(unsortedChinese);
        DualPivotQuickSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }


}