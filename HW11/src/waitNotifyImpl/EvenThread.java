package waitNotifyImpl;

import java.util.ArrayList;
import java.util.List;

public class EvenThread implements Runnable {
    private MainList mainList;
    private List<Integer> evenList;
    private int lastElement;

    public EvenThread(MainList mainList) {
        this.mainList = mainList;
        this.evenList = new ArrayList<>();
        this.lastElement = mainList.getLastElement();
    }

    @Override
    public void run() {
        for (int i = 0; i <= lastElement; i += 2) {
            mainList.fillWithEven(i);
            evenList.add(i);
        }
    }

    public List<Integer> getEvenList() {
        return evenList;
    }
}
