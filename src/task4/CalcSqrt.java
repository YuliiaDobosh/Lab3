package task4;

public class CalcSqrt extends Thread {
    int i;

    CalcSqrt(final int x) {

        i = x;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (final InterruptedException e) {
        }
        System.out.println("Square root of " + i + " is " + Math.sqrt(i));
    }
}

