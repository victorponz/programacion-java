import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "lineas.txt";
        int threadCount = 4; // number of threads to use
        
        // create an array of line counters
        LineCounterThread[] counters = new LineCounterThread[threadCount];
        
        // create and start the threads
        for (int i = 0; i < threadCount; i++) {
            counters[i] = new LineCounterThread(fileName, i, threadCount);
            counters[i].start();
        }
        
        // wait for all threads to finish
        for (int i = 0; i < threadCount; i++) {
            counters[i].join();
        }
        
        // count the total number of lines
        int totalCount = 0;
        for (int i = 0; i < threadCount; i++) {
            totalCount += counters[i].getCount();
        }
        
        System.out.println("Total number of lines: " + totalCount);
    }
}

class LineCounterThread extends Thread {
    private final String fileName;
    private final int threadNumber;
    private final int threadCount;
    private int count;

    public LineCounterThread(String fileName, int threadNumber, int threadCount) {
        this.fileName = fileName;
        this.threadNumber = threadNumber;
        this.threadCount = threadCount;
        this.count = 0;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                if (lineNumber % threadCount == threadNumber) {
                    count++;
                }
                lineNumber++;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }
}
