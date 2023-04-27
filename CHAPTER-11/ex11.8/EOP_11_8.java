import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class EOP_11_8 {

	public static void main(String[] args) {
		int k = 3;
		int[] number = {3, 2, 1, 5, 4};
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<number.length; i++) {
			list.add(number[i]);
		}
			
		System.out.println(findKthLargest(list, k));
		
	}
	
	private static class Compare{
		
		private static class GreaterThan implements Comparator<Integer>{
			public int compare(Integer a, Integer b) {
				return (a > b) ? -1 : (a.equals(b)) ? 0 : 1;
			}
			
		}
		
		public static final GreaterThan GREATER_THAN = new GreaterThan();
	}

	public static int findKthLargest(List<Integer> A, int k) {
		
		return findKth(A, k, Compare.GREATER_THAN);
		
	}

	public static int findKth(List<Integer> A, int k, Comparator<Integer> cmp) {
		int left = 0, right = A.size() -1;
		Random r = new Random(0);
		while(left <= right) {
			int pivotIdx = r.nextInt(right - left + 1) + left;
			int newPivotIdx = partitionAroundPivot(left, right, pivotIdx, A, cmp);
			if(newPivotIdx == k - 1) {
				return A.get(newPivotIdx);
			}
			else if(newPivotIdx > k - 1) {
				right = newPivotIdx - 1;
			}
			else {
				left = newPivotIdx + 1;
			}
		}
		return -1;
	}

	private static int partitionAroundPivot(int left, int right, int pivotIdx, List<Integer> A, Comparator<Integer> cmp) {
		int pivotValue = A.get(pivotIdx);
		int newPivotIdx = left;

		Collections.swap(A, pivotIdx, right);
		
		
		for(int i = left; i<right; ++i) {
			if(cmp.compare(A.get(i), pivotValue) < 0) {
				Collections.swap(A, i, newPivotIdx++);
			}
		}
		Collections.swap(A, right, newPivotIdx);
		return newPivotIdx;
	}
	

}
