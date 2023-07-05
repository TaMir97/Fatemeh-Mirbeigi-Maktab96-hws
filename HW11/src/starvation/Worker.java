package starvation;

public class Worker implements Runnable {
    private int runCount = 1;
    private String threadColor;
    private Object lock = new Object();

    public Worker(String threadColor) {
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            synchronized (lock) {
                System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
            }
        }
    }
}