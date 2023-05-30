import java.util.*;

public class Main {
    public static List<String> decomposelntoDictionaryWords(
            String domain, Set<String> dictionary) {
        int[] lastLength = new int[domain.length()];

        Arrays.fill(lastLength, -1);
        // When the algorithm finishes , lastLength[i] != -1 indicates
        // domain.substring(SI , i + 1) has a valid decomposition, and the length of
        // the last string in the decomposition will be lastLength[i].
        for (int i = 0; i < domain.length(); ++i){
            // If domain.substring(SI, i + 1) is a valid word, set lastLength[i] to the
            // length of that word.
            if (dictionary.contains(domain.substring(0 , i + 1))) {
                lastLength[i] = i + 1;
            }
            // If lastLength[i] = -1 look for j < i such that domain.substring(SI, j +
            // 1) has a valid decomposition and domain.substring(j + 1, i + 1) is a
            // dictionary word. If so, record the length of that word in
            // lastLength[i].
            if (lastLength[i] == -1) {
                for (int j = 0; j < i; ++j){
                    if (lastLength[j] != -1
                            && dictionary.contains(domain.substring(j + 1, i + 1))){
                        lastLength[i] = i - j;
                        break;
                    }
                }
            }
            for (int z=0; z< lastLength.length; z++) {
                System.out.print(lastLength[z] + ",");
            }
            System.out.println();
        }

        List<String> decompositions = new ArrayList<>();
        if (lastLength[lastLength.length - 1] != -1) {
            // domain can be assembled by valid words.
            int idx = domain.length() - 1;
            while (idx >= 0){
                decompositions.add(
                        domain.substring(idx + 1 - lastLength[idx], idx + 1)
                );
                idx -= lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }

    public static void main(String[] args) {

        Set<String> dictionary = new HashSet<String>();
        dictionary.add("BED");
        dictionary.add("BATH");
        dictionary.add("AND");
        dictionary.add("BE");
        dictionary.add("YO");
        dictionary.add("ND");
        dictionary.add(".");
        dictionary.add("COM");

        List<String> decompositions = decomposelntoDictionaryWords(
                "BEDBATHANDBEYOND.COM",dictionary
        );
        System.out.println(decompositions);
    }
}