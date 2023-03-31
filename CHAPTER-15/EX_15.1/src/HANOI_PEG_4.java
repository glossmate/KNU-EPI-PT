import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HANOI_PEG_4 {

    private static final int NUM_PEGS = 4;
    public static void computeTowerHanoi(int numRings) {
        List<Deque<Integer>> pegs = new ArrayList<>();
        for (int i = 0 ; i < NUM_PEGS ; i++) {
            pegs.add(new LinkedList<Integer>());
        }
// Initialize pegs.
        for (int i = numRings; i >= 1 ; --i) {
            pegs.get(0).addFirst(i);
        }
        computeTowerHanoiSteps(numRings , pegs, 0, 1, 2, 3);
    }
    private static void computeTowerHanoiSteps(int numRingsToMove,
                                               List <Deque<Integer>> pegs,
                                               int fromPeg , int toPeg ,
                                               int usePeg1, int usePeg2) {
        if (numRingsToMove > 1){
            computeTowerHanoiSteps(numRingsToMove - 2, pegs, fromPeg, usePeg1, usePeg2, toPeg);
            pegs.get(usePeg2).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move " + (numRingsToMove - 1) + " from peg " + fromPeg + " to peg " + usePeg2 +  " : " + pegs.toString());

            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move " + numRingsToMove + " from peg " + fromPeg + " to peg " + toPeg +  " : " + pegs.toString());

            pegs.get(toPeg).addFirst(pegs.get(usePeg2).removeFirst());
            System.out.println("Move " + (numRingsToMove -1) + " from peg " + usePeg2 + " to peg " + toPeg +  " : " + pegs.toString());
            computeTowerHanoiSteps(numRingsToMove - 2, pegs, usePeg1, toPeg, fromPeg, usePeg2);
        } else {
            pegs.get(toPeg).addFirst(pegs.get(fromPeg).removeFirst());
            System.out.println("Move " + numRingsToMove + " from peg " + fromPeg + " to peg " + toPeg +  " : " + pegs.toString());
        }
    }

}
