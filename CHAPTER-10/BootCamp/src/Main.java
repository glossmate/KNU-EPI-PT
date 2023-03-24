import java.util.*;

public class Main {

    public static List<String> topK(int k, Iterator<String> iter) {
        PriorityQueue<String> minHeap
                = new PriorityQueue<>(k, new Comparator<String>() {
            public int compare(String s1, String s2) {
                //*
                return Integer.compare(s1.length(), s2.length());
                // */
                /*
                return Integer.compare(s2.length(), s1.length());
                // */
            }
        });
        while (iter.hasNext()) {
            minHeap.add(iter.next());
            if (minHeap.size() > k) {
// Remove the shortest string. Note that the comparison function above
// will order the strings by length.
                minHeap.poll();
            }
        }
        return new ArrayList(minHeap);
    }
    public static void main(String[] args) {
//        String strTemp = "Remove the shortest string. Note that the comparison function above will order the strings by length.";
//        String strTemp = "1 22 333 4444 55555 666666 7777777 88888888 999999999";
        String strTemp = "666666 7777777 88888888 1 22 333 999999999 4444 55555";
        Iterator<String> strIter = Arrays.stream(strTemp.split(" ")).iterator();

        List<String> result = topK(4, strIter);
        System.out.println(result);
    }
}