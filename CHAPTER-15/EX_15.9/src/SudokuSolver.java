public class SudokuSolver {

    // 퍼즐의 빈 칸을 나타내는 값
    private static final int EMPTY_CELL = 0;

    // 퍼즐의 크기
    private static final int SIZE = 9;

    private int[][] puzzle;

    public SudokuSolver(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public void solve() {
        if (solveCell(0, 0)) {
            printPuzzle();
        } else {
            System.out.println("해결할 수 없는 퍼즐입니다.");
        }
    }

    private boolean solveCell(int row, int col) {
        if (row == SIZE) {
            row = 0;
            if (++col == SIZE) {
                return true;
            }
        }

        if (puzzle[row][col] != EMPTY_CELL) {
            return solveCell(row + 1, col);
        }

        for (int val = 1; val <= SIZE; ++val) {
            if (isValid(row, col, val)) {
                puzzle[row][col] = val;
                if (solveCell(row + 1, col)) {
                    return true;
                }
            }
        }

        puzzle[row][col] = EMPTY_CELL;
        return false;
    }

    private boolean isValid(int row, int col, int val) {
        for (int i = 0; i < SIZE; ++i) {
            if (val == puzzle[i][col]) {
                return false;
            }
            if (val == puzzle[row][i]) {
                return false;
            }
        }

        int boxRowOffset = (row / 3) * 3;
        int boxColOffset = (col / 3) * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (val == puzzle[boxRowOffset + i][boxColOffset + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printPuzzle() {
        for (int i = 0; i < SIZE; ++i) {
            if (i % 3 == 0) {
                System.out.println("-------------");
            }
            for (int j = 0; j < SIZE; ++j) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(puzzle[i][j] == EMPTY_CELL
                        ? " "
                        : Integer.toString(puzzle[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        int[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        SudokuSolver solver = new SudokuSolver(puzzle);
        solver.solve();
    }
}
