package daedlock;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();

        Thread writer = new Thread(new Writer(message));
        Thread reader = new Thread(new Reader(message));

        writer.start();
        reader.start();
    }
}