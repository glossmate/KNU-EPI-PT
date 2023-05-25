import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EOP_18_3 {

	
	public static char[][] data = {{'B', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B'}, {'B', 'W', 'W', 'B'}, {'B', 'B', 'B', 'W'}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Input Array");
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Output Array");
		
		fillSurroundedReginos(data);
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void fillSurroundedReginos(char[][] board) {
		for(int i=0; i< board.length; ++i) {
			if(board[i][0] == 'W') {
				markBoundaryRegion(i, 0, board);
			}
			if(board[i][board[i].length - 1] == 'W') {
				markBoundaryRegion(i, board[i].length - 1, board);
			}
		}
		
		for(int j=0; j< board.length; ++j) {
			if(board[j][0] == 'W') {
				markBoundaryRegion(0, j, board);
			}
			if(board[board.length - 1][j] == 'W') {
				markBoundaryRegion(board.length - 1, j, board);
			}
		}
		
		for(int i =0; i< board.length; ++i) {
			for(int j=0; j< board[i].length; ++j) {
				
				board[i][j] = (board[i][j] != 'T' ? 'B' : 'W');
			}
		}
		
	}
	
	private static class Coordinate{
		public Integer x;
		public Integer y;
		
		public Coordinate(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void markBoundaryRegion(int i, int j, char[][] board) {
		Queue<Coordinate> q = new ArrayDeque<>();
		q.add(new Coordinate(i, j));
		
		while(!q.isEmpty()) {
			Coordinate curr = q.poll();
			if(curr.x >=0 && curr.x < board.length && curr.y >=0 && curr.y < board[curr.x].length && board[curr.x][curr.y] == 'W') {
				board[curr.x][curr.y] =  'T';
				q.add(new Coordinate(curr.x - 1, curr.y));
				q.add(new Coordinate(curr.x + 1, curr.y));
				q.add(new Coordinate(curr.x, curr.y - 1));
				q.add(new Coordinate(curr.x, curr.y + 1));
				
				
				
			}
			
		}
	}
}
