package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.Benchmark.Benchmark;
import edu.neu.coe.info6205.sort.Benchmark.Benchmark_Timer;
import edu.neu.coe.info6205.sort.huskysort.HuskyCoderFactory;
import edu.neu.coe.info6205.sort.huskysort.PureHuskySort;
import edu.neu.coe.info6205.sort.util.FileUtil;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.Arrays;

public class DriverTelugu {
    public static String[] teluguStringListForSort;

    public static void main(String[] args) throws IOException {
        benchmark();
    }
    public static void benchmark() throws IOException {
        BasicConfigurator.configure();
        int iteration = 5;
        double mean;
        String sortType;
        int million=1000000;
        int fiftyThousand=50000;
        //int[] size = {250000, 500000, million, 2*million, 4*million};
        for(int i=250000; i < 5 * million;i+=i){
            String[] teluguStringList;
            teluguStringList = new String[i];
            for (int j = 0; j < i / fiftyThousand; j++) {
                System.arraycopy(FileUtil.readFileInRange("src/main/resources/shuffled_Telugu.txt", fiftyThousand), 0, teluguStringList, j * fiftyThousand, fiftyThousand);
            }
            int n = teluguStringList.length;
            sortType = "MSDStringSort: " + i + " elements";
            Benchmark<Object> benchmarkMSD = new Benchmark_Timer<>(sortType, a -> {
                teluguStringListForSort = Arrays.copyOf(teluguStringList, n);
                return null;
            }
                    , a -> new MSDStringSort().sort(teluguStringListForSort));
            mean = benchmarkMSD.run(1, iteration, true);
            System.out.println(mean);

            sortType = "LSDStringSort: " + i + " elements";
            Benchmark<Object> benchmarkLSD = new Benchmark_Timer<>(sortType, a -> {
                teluguStringListForSort = Arrays.copyOf(teluguStringList, n);
                return null;
            }
                    , a -> new LSDStringSort().sort(teluguStringListForSort));
            mean = benchmarkLSD.run(1, iteration, true);
            System.out.println(mean);

            sortType = "DualPivotQuickSort: " + i + " elements";
            Benchmark<Object> benchmarkDualPivotQuickSort = new Benchmark_Timer<>(sortType, a -> {
                teluguStringListForSort = Arrays.copyOf(teluguStringList, n);
                return null;
            }
                    , a -> new DualPivotQuickSort().sort(teluguStringListForSort));
            mean = benchmarkDualPivotQuickSort.run(1, iteration, true);
            System.out.println(mean);


            sortType = "HuskySort: " + i + " elements";
            Benchmark<Object> benchmarkHuskySort = new Benchmark_Timer<>(sortType, a -> {
                teluguStringListForSort = Arrays.copyOf(teluguStringList, n);
                return null;
            }
                    , a -> new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false).sort(teluguStringListForSort));
            mean = benchmarkHuskySort.run(1, iteration, true);
            System.out.println(mean);
        }
    }

}
