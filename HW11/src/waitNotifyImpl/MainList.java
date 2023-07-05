package waitNotifyImpl;

import java.util.ArrayList;
import java.util.List;

public class MainList {
    private List<Integer> mainList;
    private int lastElement;
    private boolean evenFlag = true;
    private boolean oddFlag = false;
    private boolean finished = false;

    public MainList(int lastElement) {
        mainList = new ArrayList<>();
        this.lastElement = lastElement;
    }

    public synchronized void fillWithEven(int evenElement) throws InterruptedException {
        while (!evenFlag || finished) {
            wait();
        }
        mainList.add(evenElement);
        evenFlag = false;
        oddFlag = true;
        notifyAll();
    }

    public synchronized void fillWithOdd(int oddElement) throws InterruptedException {
        while (!oddFlag || finished) {
            wait();
        }
        mainList.add(oddElement);
        oddFlag = false;
        evenFlag = true;

        if (mainList.size() == lastElement + 1) {
            finished = true;
        }

        notifyAll();
    }

    public void removeUnnecessary(int element) {
        while (!finished) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        mainList.remove(element);
    }

    public int getLastElement() {
        return lastElement;
    }

    public List<Integer> getMainList() {
        return mainList;
    }
}
