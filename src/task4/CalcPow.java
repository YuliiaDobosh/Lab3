package task4;


import java.sql.SQLOutput;

public class CalcPow implements Runnable {
    int i, j;

    CalcPow(final int x, final int y) {
        i = x;
        j = y;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (final InterruptedException e) {
        }
        System.out.println("Pow " + i + " ^ " + j + " = " + Math.pow(i, j));
    }

}
