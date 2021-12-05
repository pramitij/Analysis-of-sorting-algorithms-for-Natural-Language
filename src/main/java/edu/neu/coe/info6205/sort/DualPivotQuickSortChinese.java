package edu.neu.coe.info6205.sort;
//from: https://algs4.cs.princeton.edu/23quicksort/QuickDualPivot.java.html
import com.ibm.icu.text.Collator;
import java.util.Locale;

public class DualPivotQuickSortChinese {

    // quicksort the array a[] using dual-pivot quicksort
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
//    private static void sort(Comparable[] a, int lo, int hi) {
//        if (hi <= lo) return;
//
//        // make sure a[lo] <= a[hi]
//        if (less(a[hi], a[lo])) exch(a, lo, hi);
//
//        int lt = lo + 1, gt = hi - 1;
//        int i = lo + 1;
//        while (i <= gt) {
//            if       (less(a[i], a[lo])) exch(a, lt++, i++);
//            else if  (less(a[hi], a[i])) exch(a, i, gt--);
//            else                         i++;
//        }
//        exch(a, lo, --lt);
//        exch(a, hi, ++gt);
//
//        // recursively sort three subarrays
//        sort(a, lo, lt-1);
//        if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
//        sort(a, gt+1, hi);
//
//        assert isSorted(a, lo, hi);
//    }

    private static void sort(Comparable[] arr, int from, int to) {
        if (to <= from) return;
        // a[low] must be <= a[high]
        if (less(arr[to], arr[from])) exch(arr, from, to);

        int lt = from + 1;
        int gt = to - 1;
        int i = from + 1;
        while (i <= gt) {
            if (less(arr[i], arr[from])) exch(arr, lt++, i++);
            else if (less(arr[to], arr[i])) exch(arr, i, gt--);
            else i++;
        }
        // Moving the left and right pivot elements
        exch(arr, from, --lt);
        exch(arr, to, ++gt);
        // recursively sort three subarrays
        sort(arr, from, lt - 1);
        // only sorting if pivot elements are in place
        if (less(arr[lt], arr[gt])) sort(arr, lt + 1, gt - 1);
        sort(arr, gt + 1, to);
    }



    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return Collator.getInstance(Locale.CHINA).compare(v,w)<0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.println(comparable);
        }
    }
}

