package daedlock;

import java.util.Random;

import static daedlock.AnsiColor.*;

public class Writer implements Runnable {
    private final Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {
                ANSI_BLACK +
                        ANSI_RED_BACKGROUND + "Test First Line",
                ANSI_GREEN_BACKGROUND + "Test Second Line",
                ANSI_YELLOW_BACKGROUND + "Test Third Line",
                ANSI_CYAN_BACKGROUND + "Test Forth Line\n"
                        + ANSI_RESET
        };

        for (String s : messages) {
            message.write(s);
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException ignored) {

            }
        }
        message.write("Finished");
    }
}
