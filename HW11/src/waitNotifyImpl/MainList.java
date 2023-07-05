package waitNotifyImpl;

import java.util.ArrayList;
import java.util.List;

public class MainList {
    private List<Integer> mainList;
    private int lastElement;
    private boolean evenFlag = true;
    private boolean oddFlag = false;

    public MainList(int lastElement) {
        mainList = new ArrayList<>();
        this.lastElement = lastElement;
    }

    public synchronized void fillWithEven(int evenElement) {
        while (!evenFlag ) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        mainList.add(evenElement);
        evenFlag = false;
        oddFlag = true;

        notifyAll();
    }

    public synchronized void fillWithOdd(int oddElement)  {
        while (!oddFlag ) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        mainList.add(oddElement);
        oddFlag = false;
        evenFlag = true;

        notifyAll();
    }


    public int getLastElement() {
        return lastElement;
    }

    public List<Integer> getMainList() {
        return mainList;
    }
}
