import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int EMPTY_ENTRY = 0;
    public static boolean solveSudoku(List<List<Integer>> partialAssignment){
        return solvePartialSudoku(0 , 0, partialAssignment);
    }
    private static boolean solvePartialSudoku (
            int i, int j, List<List<Integer>> partialAssignment) {

        if (i == partialAssignment.size()) {
            i = 0; // Starts a new row.
            if (++j == partialAssignment.get(i).size()) {
                return true; // Entire matrix has been filled without conflict.
            }
        }
        // Skips nonempty entries.
        if (partialAssignment.get(i).get(j) != EMPTY_ENTRY) {
            return solvePartialSudoku(i + 1, j, partialAssignment);
        }

        for (int val = 1; val <= partialAssignment.size(); ++val) {
            // It’s substantially quicker to check if entry val conflicts
            // with any of the constraints if we add it at (i,j) before
            // adding it, rather than adding it and then checking all constraints.
            // The reason is that we are starting with a valid configuration,
            // and the only entry which can cause a problem is entryval at (i,j).
            if (validToAddVal(partialAssignment, i, j, val)) {
                partialAssignment.get(i).set(j, val);
                if (solvePartialSudoku(i + 1, j, partialAssignment)) {
                    return true;
                }
            }
        }
        partialAssignment.get(i).set(j, EMPTY_ENTRY); // Undo assignment.
        return false;
    }

    private static boolean validToAddVal(List<List<Integer>> partialAssignment,
                                         int i, int j, int val) {
        // Check row constraints.
        for (List<Integer> element : partialAssignment) {
            if (val == element.get(j)) {
                return false;
            }
        }
// Check column constraints.
        for (int k = 0; k < partialAssignment.size(); ++k) {
            if (val == partialAssignment.get(i).get(k)) {
                return false;
            }
        }

        // Check region constraints.
        int regionSize = (int) Math.sqrt(partialAssignment.size());
        int I = i / regionSize, J = j / regionSize;
        for (int a = 0; a < regionSize; ++a) {
            for (int b = 0; b < regionSize; ++b) {
                if (val == partialAssignment
                                .get(regionSize * I + a).get(regionSize * J + b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> partialAssignment = new ArrayList<List<Integer>>();
        partialAssignment.add(Arrays.asList(5,3,0,0,7,0,0,0,0));
        partialAssignment.add(Arrays.asList(6,0,0,1,9,5,0,0,0));
        partialAssignment.add(Arrays.asList(0,6,8,0,0,0,0,6,0));
        partialAssignment.add(Arrays.asList(8,0,0,0,6,0,0,0,3));
        partialAssignment.add(Arrays.asList(4,0,0,8,0,3,0,0,1));
        partialAssignment.add(Arrays.asList(7,0,0,0,2,0,0,0,6));
        partialAssignment.add(Arrays.asList(0,6,0,0,0,0,2,8,0));
        partialAssignment.add(Arrays.asList(0,0,0,4,1,9,0,0,5));
        partialAssignment.add(Arrays.asList(0,0,0,0,8,0,0,7,9));

        System.out.println("--------------- BEFORE ----------");
        partialAssignment.stream().forEach(System.out::println);

        solveSudoku(partialAssignment);

        System.out.println("--------------- AFTER ----------");
        partialAssignment.stream().forEach(System.out::println);

        partialAssignment = new ArrayList<List<Integer>>();

        partialAssignment.add(Arrays.asList(5,3,0,0,7,0,0,0,0,0,0,0));
        partialAssignment.add(Arrays.asList(6,0,0,1,9,5,0,0,0,0,0,0));
        partialAssignment.add(Arrays.asList(0,6,8,0,0,0,0,6,0,0,0,0));
        partialAssignment.add(Arrays.asList(8,0,0,0,6,0,0,0,3,0,0,0));
        partialAssignment.add(Arrays.asList(4,0,0,8,0,3,0,0,1,0,0,0));
        partialAssignment.add(Arrays.asList(7,0,0,0,2,0,0,0,6,0,0,0));
        partialAssignment.add(Arrays.asList(0,6,0,0,0,0,2,8,0,0,0,0));
        partialAssignment.add(Arrays.asList(0,0,0,4,1,9,0,0,5,0,0,0));
        partialAssignment.add(Arrays.asList(0,0,0,0,8,0,0,7,9,0,0,0));
        partialAssignment.add(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
        partialAssignment.add(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));
        partialAssignment.add(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0));

        System.out.println("--------------- BEFORE ----------");
        partialAssignment.stream().forEach(System.out::println);

        solveSudoku(partialAssignment);

        System.out.println("--------------- AFTER ----------");
        partialAssignment.stream().forEach(System.out::println);

    }
}