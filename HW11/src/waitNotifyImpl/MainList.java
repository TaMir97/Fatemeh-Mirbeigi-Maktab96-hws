package waitNotifyImpl;

import java.util.ArrayList;
import java.util.List;

public class MainList {
    private List<Integer> mainList;
    private int lastElement;
    private boolean flag = true;


    public MainList(int lastElement) {
        mainList = new ArrayList<>();
        this.lastElement = lastElement;
    }

    public synchronized void fillWithEven(int evenElement) throws InterruptedException {
        while (flag) {
            wait();
        }
        flag = false;
        mainList.add(evenElement);
        notifyAll();
    }

    public synchronized void fillWithOdd(int oddElement) throws InterruptedException {
        while (!flag) {
            wait();
        }
        flag = true;
        mainList.add(oddElement);
        notifyAll();
    }

    public void removeUnnecessary(int element) {
        while (mainList.size() != lastElement + 1){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
