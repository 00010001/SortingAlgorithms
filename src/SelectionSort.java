/**
 * //https://pl.wikipedia.org/wiki/Sortowanie_przez_wybieranie
 */
public class SelectionSort implements Sort{
    public <E extends Comparable<E>> void sort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[smallest])<=0) {
                    smallest = j;
                }
            }
            swap(array, i, smallest);
        }
    }
    private static  <E> void swap(E[] array, int i, int j) {
        if (i != j) {
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
