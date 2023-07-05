package waitNotifyImpl;

import java.util.ArrayList;
import java.util.List;

public class OddThread implements Runnable {
    private int lastElement;
    private MainList mainList;
    private List<Integer> oddList;

    public OddThread(MainList mainList) {
        this.mainList = mainList;
        this.oddList = new ArrayList<>();
        this.lastElement = mainList.getLastElement();
    }

    @Override
    public void run() {
        for (int i = 1; i <= lastElement; i += 2) {
            mainList.fillWithOdd(i);
            oddList.add(i);
        }
    }

    public List<Integer> getOddList() {
        return oddList;
    }
}
