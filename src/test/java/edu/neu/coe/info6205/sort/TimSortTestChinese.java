package edu.neu.coe.info6205.sort;


import com.ibm.icu.text.Collator;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class TimSortTestChinese {

    @Test
    public void sortSeaShells() {
        String[] sortedChinese = new String[]{"阿冰", "阿冰冰", "阿超"};
        String[] unsortedChinese = new String[]{"阿超", "阿冰", "阿冰冰"};
        Arrays.sort(unsortedChinese);
        TimSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }

    @Test
    public void GeneralTest() throws IOException {
        String[] a = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-shuffled.txt",1000);
        String[] b = FileUtil.readFileInRange("src/main/resources/1000-chinese-words-shuffled.txt",1000);
        Collator collator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(a,(x1, x2)->collator.compare(x1,x2));
        TimSortChinese.sort(b);


        assertArrayEquals(a, b);

    }

    @Test
    public void sortChinese1() {

        String[] sortedChinese = new String[]{"曾佳珍", "范亚文", "侯封", "江兆涛", "闫炳华", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛"};
        Arrays.sort(unsortedChinese);
        TimSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }

    @Test
    public void sortChinese2() {
        String[] sortedChinese = new String[]{"曾佳珍", "杜丽伟", "范成章", "范亚文", "冯翠君", "侯封", "江兆涛", "赖春宝", "李继翔", "廖前进", "刘久胜", "潘从伟", "闫炳华", "姚佳鑫", "应丽娜", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛", "刘久胜", "冯翠君", "赖春宝", "李继翔", "范成章", "杜丽伟", "廖前进", "姚佳鑫", "潘从伟","应丽娜" };
        Arrays.sort(unsortedChinese);
        TimSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }

    @Test
    public void sortChinese3() {

        String[] sortedChinese = new String[]{"曾佳珍", "陈立昆", "杜丽伟", "范成章", "范亚文", "冯翠君", "顾新新", "侯封", "江兆涛", "赖春宝", "李继翔", "李开森", "廖前进", "林鸿森", "刘定基", "刘定基", "刘久胜", "潘从伟", "肖燕珊", "闫炳华", "杨列仁", "杨列仁", "姚佳鑫", "应丽娜", "余康康"};
        String[] unsortedChinese = new String[]{"曾佳珍", "闫炳华", "余康康", "侯封", "范亚文", "江兆涛", "刘久胜", "冯翠君", "赖春宝", "李继翔", "范成章", "杜丽伟", "廖前进", "姚佳鑫", "潘从伟","应丽娜", "杨列仁", "杨列仁", "刘定基", "刘定基", "李开森", "肖燕珊", "林鸿森", "顾新新", "陈立昆"};
        Arrays.sort(unsortedChinese);
        TimSortChinese.sort(unsortedChinese);
        assertArrayEquals(sortedChinese, unsortedChinese);
    }


}
