// Sortowanie przez wstawianie (https://pl.wikipedia.org/wiki/Sortowanie_przez_wstawianie)

//https://stackoverflow.com/questions/35628712/insertion-sort-how-to-accept-input-and-print-the-sorted-array/35629991#35629991
public class InsertSort implements Sort {


    @Override
    public <E extends Comparable<E>> void sort(E[] array) {

        int n = array.length;
        for (int j = 1; j < n; j++) {
            E key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i].compareTo(key) > 0)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }

    }
}




