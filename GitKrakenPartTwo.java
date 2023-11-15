import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GitKrakenPartTwo implements Callable<Long> {

    static int n;

    public static void main(String[] args){
        n = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        Future[] futures = new Future[n];
        for(int i=0; i<n; i++){
            futures[i] = executorService.submit(new GitKrakenPartTwo());
        }
        try{
            long sum = 0;
            for(int i=0; i<n; i++){
               sum += (Long)(futures[i].get());
            }
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        executorService.shutdown();
    }

    @Override
    public Long call() throws Exception {
        long start = System.currentTimeMillis();
        for(int i=0; i<100000000/n; i++) {

        }
        long end = System.currentTimeMillis();
        return (end-start);
    }
}
