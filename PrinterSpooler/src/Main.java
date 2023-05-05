import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrinterSpooler {
    static PrinterSpooler INSTANCE;

    int jobCount;

    static synchronized PrinterSpooler getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PrinterSpooler();
        }
        return INSTANCE;
    }

    private PrinterSpooler() {
        jobCount = 0;
    }

    synchronized void printJob(String job) {
        System.out.println("Printing job " + (++jobCount) + ": " + job);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {


        List<Callable<Void>> printOrders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int docid = i;
            printOrders.add(() -> {
                PrinterSpooler.getInstance().printJob("Document" + docid);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(printOrders);
        executorService.shutdown();

        System.out.println("FINISHED. Jobs printed: " + PrinterSpooler.getInstance().jobCount);
    }
}