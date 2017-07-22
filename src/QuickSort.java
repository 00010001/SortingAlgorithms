/**
 * Created by X on 7/22/2017.
 */
public class QuickSort implements Sort{

    public <E extends Comparable<E>> void sort(E[] array) {

        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array,0, array.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int i = lowerIndex, j = higherIndex;
            T x = array[(i + j) / 2];

            do {
                while (array[i].compareTo(x) < 0) i++;
                while (x.compareTo(array[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quickSort(array, lowerIndex, j);
            quickSort(array, i, higherIndex);
        }
    }
}
