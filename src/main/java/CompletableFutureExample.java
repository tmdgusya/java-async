import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService dispatcher = Executors.newFixedThreadPool(2);

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(
                new SupplierImpl(), dispatcher
        );

        System.out.println(stringCompletableFuture.complete("Not Finished"));
        dispatcher.shutdownNow();
    }

}

class SupplierImpl implements Supplier<String> {

    @Override
    public String get() {
        try {
            Thread.sleep(5000);
            return "roach";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
