/**
 * Created by X on 7/22/2017.
 */
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;

public class MainApp {

    public static void main(String[] args) {
        compareSortAlgorithms(20000, 1000);
    }

    private static Integer[] compareSortAlgorithms(int n, int valueUpperBound) {
        Integer[] array = generateArray(n, valueUpperBound);

        for (SortingAlgorithm algorithm : SortingAlgorithm.values()) {
            System.out.println("Typ sortowania: "+algorithm.toString() + " Czas: " + getSortTime(Arrays.copyOf(array, array.length),algorithm));
        }
        return array;
    }

    private static long getSortTime(Integer[] array, SortingAlgorithm method){
        LocalTime startTime = LocalTime.now();
        switch (method){
            case BUBBLE:
                doSort(new BubbleSort(), array);
                break;
            case HEAP:
                doSort(new HeapSort(),array);
                break;
            case INSERT:
                doSort(new InsertSort(), array);
                break;
            case MERGE:
                doSort(new MergeSort(), array);
                break;
            case QUICK:
                doSort(new QuickSort(), array);
                break;
            case SELECTION:
                doSort(new SelectionSort(), array);
                break;
        }
        return startTime.until(LocalTime.now(), ChronoUnit.MILLIS);
    }

    public static void doSort(Sort sortingMethod, Integer[] array)
    {
        sortingMethod.sort(array);
    }
    public static <T extends Comparable> boolean isSorted(T[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static Integer[] generateArray(int n, int valueUpperBound) {
        Integer[] result = new Integer[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            result[i] = random.nextInt(valueUpperBound);
        }
        return result;
    }




}
