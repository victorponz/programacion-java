public class ArraySum {
    private static int[] arr = new int[100_000_000];
    public static void main(String[] args) throws InterruptedException {
        createLargeArray(arr); 
        long start1 = System.nanoTime();//46498489 26767280
        int threadCount = 4; // number of threads to use
        
        // create an array of array summing threads
        ArraySumThread[] threads = new ArraySumThread[threadCount];
        
        // create and start the threads
        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * arr.length / threadCount;
            int endIndex = (i + 1) * arr.length / threadCount;
            threads[i] = new ArraySumThread(arr, startIndex, endIndex);
            threads[i].start();
        }
        
        // wait for all threads to finish
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
        
        // sum the partial sums computed by each thread
        int totalSum = 0;
        for (int i = 0; i < threadCount; i++) {
            totalSum += threads[i].getPartialSum();
        }
        
        System.out.println("Array sum: " + totalSum);
       
        long end1 = System.nanoTime(); 
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));
    }
    private static void createLargeArray(int[] array ){
        for(int i = 0; i < array.length; i++){
            array[i] = (int) (Math.random() * 10 );
        }
    }
}

class ArraySumThread extends Thread {
    private final int[] arr;
    private final int startIndex;
    private final int endIndex;
    private int partialSum;

    public ArraySumThread(int[] arr, int startIndex, int endIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialSum = 0;
    }

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialSum += arr[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
    
}
