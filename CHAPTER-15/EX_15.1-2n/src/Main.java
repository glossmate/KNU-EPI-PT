import java.util.Stack;

public class Main {

    static Stack<Integer>[] tower = new Stack[3];

    public static void main(String[] args) {
        int n = 3;
        int totalDisks = 2 * n;

        // 3개의 스택 생성
        for (int i = 0; i < 3; i++) {
            tower[i] = new Stack<Integer>();
        }

        // 첫번째 기둥에 디스크를 넣음
        for (int i = n; i > 0; i--) {
            tower[0].push(i);
            tower[0].push(i);
        }

        System.out.println(tower[0].toString() + ", " + tower[1].toString() + ", " + tower[2].toString());

        // 하노이 타워 문제를 해결하는 함수 호출
        hanoiTower(totalDisks, 0, 1, 2);
    }

    // 하노이 타워 문제를 해결하는 함수
    public static void hanoiTower(int n, int source, int destination, int aux) {
        if (n == 0) {
            return;
        }

        // 출발지에서 보조 기둥으로 n-1개의 디스크 이동
        hanoiTower(n - 1, source, aux, destination);

        // 출발지에서 목적지로 가장 큰 디스크 이동
        int disk = tower[source].pop();
        tower[destination].push(disk);
        System.out.println("Move disk " + disk + " from " + (source+1) + " to " + (destination+1));
        System.out.println(tower[0].toString() + ", " + tower[1].toString() + ", " + tower[2].toString());

        // 보조 기둥에서 목적지로 n-1개의 디스크 이동
        hanoiTower(n - 1, aux, destination, source);
    }
}
