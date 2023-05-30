import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollatzConjecture {
    public static void main(String[] args) {
        int start = 10000;
        int end = 100000;

        // 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = start; i <= end; i++) {
            int num = i;
            // 작업을 스레드 풀에 제출
            executor.submit(() -> processCollatzConjecture(num));
        }

        // 모든 작업이 완료될 때까지 대기
        executor.shutdown();
    }

    private static void processCollatzConjecture(int num) {
        System.out.println("Processing: " + num);
        while (num != 1) {
            System.out.print(num + " -> ");
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
        }
        System.out.println(num);
    }
}
