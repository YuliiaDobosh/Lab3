package task4;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class task4 {
    public static void main(final String[] args) {

        final CalcSqrt calcSqrt = new CalcSqrt(16);
        calcSqrt.start();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new CalcPow(2, 4));
        executorService.shutdown();
    }
}
