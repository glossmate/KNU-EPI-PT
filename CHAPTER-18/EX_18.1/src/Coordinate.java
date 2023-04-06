import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    public int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        if (x != that.x || y != that.y) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }


    public static enum Color { WHITE, BLACK }
    public static List<Coordinate> searchMaze(List<List<Color>> maze,
                                              Coordinate s, Coordinate e) {
        List<Coordinate> path = new ArrayList<>();
        maze.get(s.x).set(s.y , Color.BLACK);
        path.add(s);
        if (!searchMazeHelper(maze , s, e, path)) {
            path.remove(path.size() - 1);
        }
        return path; // Empty path means no path between s and e.
    }

    // Performs DFS to find a feasible path.
    private static boolean searchMazeHelper(List<List<Color>> maze,
                                            Coordinate cur, Coordinate e,
                                            List<Coordinate> path) {
        if (cur.equals(e)) {
            return true;
        }
        final int[][] SHIFT = {{0 ,1},{1, 0},{0,-1},{-1, 0}};
        for (int[] s : SHIFT) {
            Coordinate next = new Coordinate(cur.x + s[0],cur.y + s[1]);
            if (isFeasible(next, maze)) {
                maze.get(next.x).set(next.y, Color.BLACK);
                path.add(next);
                if (searchMazeHelper(maze, next, e, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private static boolean isFeasible(Coordinate cur, List<List<Color>> maze) {
        return cur.x >= 0 && cur.x < maze.size() && cur.y >= 0
                && cur.y < maze.get(cur.x).size()
                && maze.get(cur.x).get(cur.y) == Color.WHITE;
    }

}


