//https://www.reddit.com/r/javaexamples/comments/3adlr9/heapsort/
public class HeapSort implements Sort{


    @Override
    public <E extends Comparable<E>> void sort(E[] array) {
        sort(array, true);
    }

    public static <T extends Comparable<T>> T[] sort(T[] array, boolean down)
    {
        if (down)
        {
            heapify(array, array.length);
        }
        else
        {
            heapifyUp(array, array.length);
        }

        int end = array.length - 1;
        while (end >= 0)
        {
            swap(array, end, 0);
            end--;
            siftDown(array, 0, end);
        }
        return array;

    }

    private static <T extends Comparable<T>> T[] swap(T[] array, int index1, int index2)
    {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    private static <T extends Comparable<T>> T[] heapify(T[] array, int count)
    {
        int start = (int) Math.floor((count - 2)/2);
        while (start >= 0)
        {
            siftDown(array, start, count - 1);
            start--;
        }
        return array;
    }

    private static <T extends Comparable<T>> T[] heapifyUp(T[] array, int count)
    {
        int end = 1;
        while (end < count)
        {
            siftUp(array, 0, end);
            end++;
        }
        return array;
    }

    private static<T extends Comparable<T>> T[] siftUp(T[] array, int start, int end)
    {
        int child = end;
        while (child > start)
        {
            int parent = (int) Math.floor((child - 1) /2);
            if (array[parent].compareTo(array[child]) < 0)
            {
                swap(array, parent, child);
                child = parent;
            }
            else
            {
                return array;
            }
        }
        return array;
    }

    private static <T extends Comparable<T>> T[] siftDown(T[] array, int start, int end)
    {
        int root = start;
        while (root * 2 + 1 <= end)
        {
            int child = root * 2 + 1;
            int swap = root;
            if (array[swap].compareTo(array[child]) < 0)
            {
                swap = child;
            }
            if ((child + 1 <= end) && (array[swap].compareTo(array[child + 1]) < 0))
            {
                swap = child + 1;
            }
            if (swap==root)
            {
                return array;
            }
            else
            {
                swap(array, root, swap);
                root = swap;
            }
        }
        return array;
    }
}
