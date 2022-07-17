import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutuerSyncExample {

    public static void main(String[] args) throws Exception {
        ExecutorService dispatcher = Executors.newFixedThreadPool(2); //  1

        Callable<String> callBack = () -> { // 2
            Thread.sleep(3000);
            return "roach";
        };

        String result = callBack.call(); // 3 (3초가 블락킹이되는 코드) Main Thread 가 멈추게 되는 코드

        System.out.println(result); // 4
    }

}
