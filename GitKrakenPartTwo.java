import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GitKrakenPartTwo implements Callable<Integer> {

    static int n;

    public static void main(String[] args){
        n = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        Future[] futures = new Future[n];
        for(int i=0; i<n; i++){
            futures[i] = executorService.submit(new GitKrakenPartTwo());
        }
        try{
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += (int)(futures[i].get());
            }
            System.out.println(sum);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        executorService.shutdown();
    }

    @Override
    public Integer call() throws Exception {
        for(int i=0; i<100000000/n; i++) {

        }
        return 100000000/n;
    }
}
