package edu.neu.coe.info6205.sort;

import com.ibm.icu.text.Collator;
import com.ibm.icu.util.ULocale;

//from: https://www.geeksforgeeks.org/timsort/

import java.util.Locale;

public class TimSortChinese {
    static int RUN = 32;

    public static int compare(String s1, String s2) {
        return Collator.getInstance(Locale.CHINA).compare(s1, s2);
    }

    static int min(int a, int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    /* This function sorts array from starting index to ending index which is of size atmost RUN */
    static void insertionSort(String a[], int beg, int end) /* function to sort an array with insertion sort */
    {
        int i, j;
        String temp;
        for (i = beg + 1; i <= end; i++)
        {
            temp = a[i];
            j = i - 1;

            while(j >= beg && !(compare(temp,a[j]) > 0))
            {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = temp;
        }
    }
    /* Function to merge the sorted runs */
    static void merge(String a[], int beg, int mid, int end)
    {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        //temporary arrays
        String[] LeftArray = new String[n1];
        String[] RightArray = new String[n2];
        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];
        i = 0;
        j = 0;
        k = beg;
        while (i < n1 && j < n2)
        {
            if(!(compare(LeftArray[i],RightArray[j])>0))
            {
                a[k] = LeftArray[i];
                i++;
            }
            else
            {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1)
        {
            a[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j<n2)
        {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }
    /* function to implement tim sort */
    public static void sort(String[] a)
    {
        int n = a.length;
        /* Sort individual subarrays of size RUN */
        for (int i = 0; i < n; i+=RUN)
            insertionSort(a, i, min((i+RUN-1), (n-1)));
        // Start merging from size RUN (or 32).
        for (int size = RUN; size < n; size = 2*size)
        {
            for (int beg = 0; beg < n; beg += 2*size)
            {
                /* find ending point of left subarray. The starting point of right sub array is mid + 1 */
                int mid = beg + size - 1;
                int end = min((beg + 2*size - 1),(n-1));

                /* Merge subarray a[beg...mid] and a[mid+1...end] */
                if(mid < end)
                    merge(a, beg, mid, end);
            }
        }
    }
}
