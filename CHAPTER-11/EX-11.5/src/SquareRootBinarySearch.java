public class SquareRootBinarySearch {
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("음수의 제곱근은 구할 수 없습니다.");
        }

        double low = 0;
        double high = x;
        double precision = 1e-15; // 원하는 정밀도를 설정합니다.

        while (high - low > precision) {
            double mid = (low + high) / 2;
            double square = mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        double x = 924.245;
        double sqrt = squareRoot(x);
        System.out.println("제곱근: " + sqrt);
    }
}
