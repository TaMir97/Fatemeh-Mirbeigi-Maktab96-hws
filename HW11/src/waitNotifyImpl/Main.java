package waitNotifyImpl;

public class Main {
    public static void main(String[] args) {
        MainList mainList = new MainList(10);
        EvenThread even = new EvenThread(mainList);
        Thread evenAdd = new Thread(even);
        OddThread odd = new OddThread(mainList);
        Thread oddAdd = new Thread(odd);

        evenAdd.start();
        oddAdd.start();

        try {
            evenAdd.join();
            oddAdd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The main list: " + mainList.getMainList());
        System.out.println("The odd list: " + odd.getOddList());
        System.out.println("The even list: " + even.getEvenList());
    }
}
