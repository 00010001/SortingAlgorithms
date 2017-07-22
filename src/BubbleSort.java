// Sortowanie bąbelkowe (https://pl.wikipedia.org/wiki/Sortowanie_b%C4%85belkowe).
//https://github.com/jsquared21/Intro-to-Java-Programming/blob/master/Exercise_23/Exercise_23_01/Exercise_23_01.java
public class BubbleSort implements Sort {

    @Override
    public <E extends Comparable<E>> void sort(E[] array) {
            boolean needNextPass = true;

            for (int k = 1; k < array.length && needNextPass; k++) {
                // Array may be sorted and next pass not needed
                needNextPass = false;
                for (int i = 0; i < array.length - k; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        // Swap list[i] with list[i + 1]
                        E temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;

                        needNextPass = true; // Next pass still needed
                    }
                }
            }
        }
}