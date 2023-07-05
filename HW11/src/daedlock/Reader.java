package daedlock;

import java.util.Random;

public class Reader implements Runnable {
    private final Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
             latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
