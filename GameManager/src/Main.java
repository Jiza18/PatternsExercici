import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class GameManager {
    static GameManager INSTANCE;
    static int score;

    synchronized static GameManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new GameManager();
        }
            return INSTANCE;
    }

    synchronized void incrementScore(int points) {
        int newScore = score + points;
        if (new Random().nextInt(10) >= 0) {
            score = newScore;
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Callable<Void>> gameParts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            gameParts.add(() -> {
                GameManager.getInstance().incrementScore(1);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(gameParts);
        executorService.shutdown();

        System.out.println(GameManager.score);
    }
}
