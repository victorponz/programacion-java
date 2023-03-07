import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort {
    public static void main(String[] args) {
        int[] arr = generateArray(1000000);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelMergeSort(arr, 0, arr.length));
        System.out.println(Arrays.toString(arr));
    }
    
    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}

class ParallelMergeSort extends RecursiveAction {
    private static final int THRESHOLD = 100000;
    private final int[] arr;
    private final int start;
    private final int end;
    
    ParallelMergeSort(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            Arrays.sort(arr, start, end);
        } else {
            int mid = start + (end - start) / 2;
            ParallelMergeSort left = new ParallelMergeSort(arr, start, mid);
            ParallelMergeSort right = new ParallelMergeSort(arr, mid, end);
            invokeAll(left, right);
            merge(mid);
        }
    }
    
    private void merge(int mid) {
        int[] leftArr = Arrays.copyOfRange(arr, start, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, end);
        int i = 0, j = 0, k = start;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
}
