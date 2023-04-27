import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;


public class EOP_10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> data = new ArrayList<>();
		int[] a = {3, 1, 2, 6, 4, 5, 8, -1, 11, 7, 9, 10, 15};
		
		System.out.print("Input : ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+ " ");
			data.add(a[i]);
		}
		
		System.out.println();
		
		Iterator<Integer> list = data.iterator();
		Random r = new Random();
		int index = (int)r.nextInt(data.size());
		List<Integer> k = sortApproximatelySortedDate(list, index);

		for(int i=0; i<k.size(); i++) {
			System.out.printf("%d ", k.get(i));
		}
		
	}

	
	public static List<Integer> sortApproximatelySortedDate(Iterator<Integer> sequence, int k){
		List<Integer> result = new ArrayList<>();
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		
		for(int i=0; i<k && sequence.hasNext(); ++i) {
			minHeap.add(sequence.next());
		}
		
		while(sequence.hasNext()) {
			minHeap.add(sequence.next());
			Integer samllest = minHeap.remove();
			result.add(samllest);
		}
		
		while(!minHeap.isEmpty()) {
			Integer smallest = minHeap.remove();
			result.add(smallest);
		}

		return result;
	}
	
}
