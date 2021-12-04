package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.Benchmark.Benchmark;
import edu.neu.coe.info6205.sort.Benchmark.Benchmark_Timer;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.Arrays;

public class Driver {
    public static String[] chineseStringListForSort;

    public static void main(String[] args) throws IOException {
        benchmark();
    }
    public static void benchmark() throws IOException {
        BasicConfigurator.configure();
        int iteration = 5;
        double mean;
        String sortType;
        int million=1000000;
        //int[] size = {250000, 500000, million, 2*million, 4*million};
        for(int i=250000; i < 5 * million;i+=i){
            String[] chineseStringList;
            if (i < 2 * million) {
                chineseStringList = FileUtil.readFileInRange("src/main/resources/shuffledChinese.txt", i);
            }
            else{
                chineseStringList = new String[i];
                for (int j = 0; j < i / million; j++) {
                    System.arraycopy(FileUtil.readFileInRange("src/main/resources/shuffledChinese.txt", million), 0, chineseStringList, j * million, million);
                }
            }
            int n = chineseStringList.length;
            sortType = "MSDStringSort: " + i + " elements";
            Benchmark<Object> benchmarkMSD = new Benchmark_Timer<>(sortType, a -> {
                chineseStringListForSort = Arrays.copyOf(chineseStringList, n);
                return null;
            }
                    , a -> new MSDStringSortChinese().sort(chineseStringListForSort));
            mean = benchmarkMSD.run(1, iteration, true);
            System.out.println(mean);

            sortType = "LSDStringSort: " + i + " elements";
            Benchmark<Object> benchmarkLSD = new Benchmark_Timer<>(sortType, a -> {
                chineseStringListForSort = Arrays.copyOf(chineseStringList, n);
                return null;
            }
                    , a -> new LSDStringSortChinese().sort(chineseStringListForSort));
            mean = benchmarkLSD.run(1, iteration, true);
            System.out.println(mean);

            sortType = "DualPivotQuickSort: " + i + " elements";
            Benchmark<Object> benchmarkDualPivotQuickSort = new Benchmark_Timer<>(sortType, a -> {
                chineseStringListForSort = Arrays.copyOf(chineseStringList, n);
                return null;
            }
                    , a -> new DualPivotQuickSortChinese().sort(chineseStringListForSort));
            mean = benchmarkDualPivotQuickSort.run(1, iteration, true);
            System.out.println(mean);

            sortType = "TimSort: " + i + " elements";
            Benchmark<Object> benchmarkTimSort = new Benchmark_Timer<>(sortType, a -> {
                chineseStringListForSort = Arrays.copyOf(chineseStringList, n);
                return null;
            }
                    , a -> new TimSort().sort(chineseStringListForSort));
            mean = benchmarkTimSort.run(1, iteration, true);
            System.out.println(mean);

            sortType = "HuskySort: " + i + " elements";
            Benchmark<Object> benchmarkHuskySort = new Benchmark_Timer<>(sortType, a -> {
                chineseStringListForSort = Arrays.copyOf(chineseStringList, n);
                return null;
            }
                    , a -> new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(chineseStringListForSort));
            mean = benchmarkHuskySort.run(1, iteration, true);
            System.out.println(mean);
        }
    }

}
