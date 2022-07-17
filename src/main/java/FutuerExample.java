import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutuerExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService dispatcher = Executors.newFixedThreadPool(2); // 1

        Callable<String> callBack = () -> { // 2
            System.out.println("Async Thread " + Thread.currentThread().getName());
            Thread.sleep(3000); // 4 (Other Thread)
            return "roach";
        };

        Future<String> promise = dispatcher.submit(callBack); // 3

        System.out.println("Main Thread " + Thread.currentThread().getName());

        System.out.println(promise.get()); // 5 (Main Thread) 3초 블락킹

        if (promise.isDone()) {
            System.out.println("Shut Down Dispatcher");
            dispatcher.shutdown();
        }
    }

}
