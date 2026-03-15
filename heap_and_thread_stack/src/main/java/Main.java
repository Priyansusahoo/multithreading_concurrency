import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch(TimeUnit.SECONDS);

        Thread cyan = new Thread(stopWatch::countDown, ThreadColour.ANSI_CYAN.name());
        Thread purple = new Thread(() -> stopWatch.countDown(7), ThreadColour.ANSI_PURPLE.name());
        Thread red = new Thread(() -> stopWatch.countDown(7), ThreadColour.ANSI_RED.name());
        cyan.start();
        purple.start();
        red.start();
    }
}

class StopWatch {

    private TimeUnit timeUnit;

    public StopWatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countDown() {
        countDown(5);
    }

    public void countDown(int unitCount) {
        String threadName = Thread.currentThread().getName();
        ThreadColour threadColour = ThreadColour.ANSI_RESET;
        try {
            threadColour = ThreadColour.valueOf(threadName);
        } catch (IllegalArgumentException e) {
            // No Action
        }
        String colour = threadColour.getColour();
        for (int i = unitCount; i > 0 ; i--) {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("countDown(n) Interrupted");
                e.printStackTrace();
            }
            System.out.printf("%s%s Thread : i = %d%n", colour, threadName, i);
        }
    }
}