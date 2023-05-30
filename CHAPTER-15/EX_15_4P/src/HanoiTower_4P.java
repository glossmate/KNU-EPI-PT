import java.util.Scanner;

public class HanoiTower_4P {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();

        // 하노이 타워 문제를 해결하는 함수 호출
        hanoiTower(n, "P1", "P4", "P2", "P3");
    }

    // 하노이 타워 문제를 해결하는 함수
    public static void hanoiTower(int n, String from, String to, String aux1, String aux2) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        hanoiTower(n - 2, from, aux1, aux2, to);
        System.out.println("Move disk " + (n - 1) + " from " + from + " to " + aux2);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        System.out.println("Move disk " + (n - 1) + " from " + aux2 + " to " + to);
        hanoiTower(n - 2, aux1, to, from, aux2);
    }
}
