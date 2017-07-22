import java.util.Comparator;
import java.util.Arrays;
//https://github.com/jsquared21/Intro-to-Java-Programming/blob/master/Exercise_23/Exercise_23_02/Exercise_23_02.java
public class MergeSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = (E[])new Comparable[list.length / 2];
            System.arraycopy(list, 0 , firstHalf, 0, list.length / 2);
            sort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            sort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /** Merge two sorted lists */
    public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        /** Generic mergeSort using Comparator */
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = Arrays.copyOf(list, list.length / 2);
            mergeSort(firstHalf, comparator);

            // Merge sort the second half
            E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(secondHalf, comparator);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    public static <E> void merge(E[] list1, E[] list2, E[] temp,
                                 Comparator<? super E> comparator) {
        int current1 = 0; // Current index in list1
        int current2 = 0; // Current index in list2
        int current3 = 0; // Current index in temp

        while (current1 < list1.length && current2 < list2.length) {
            if (comparator.compare(list1[current1], list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }


}