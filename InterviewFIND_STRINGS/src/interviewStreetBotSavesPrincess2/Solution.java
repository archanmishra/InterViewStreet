package interviewStreetBotSavesPrincess2;

import java.util.*;

public class Solution {
	/* Head ends here */
	static void nextMove(int m, int x, int y, String[] grid) {
		int px = 0, py = 0;
		int mx = x, my = y;
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < m; j++) {
				 if (grid[i].charAt(j) == 'p'){
					px =  i;
					py = j;
				}
			}
		}
		String xmove, ymove;
		int xdiff, ydiff;
		if(px > mx){
			xmove = "DOWN";
			xdiff = px - mx;
		}else{
			xmove = "UP";
			xdiff = mx-px;
		}
		if(py > my){
			ymove = "RIGHT";
			ydiff = py- my;
		}else{
			ymove = "LEFT";
			ydiff = my - py;
		}
		for(i =0; i < xdiff; ){
			System.out.println(xmove);
			return;
		}
		for(i=0; i< ydiff; ){
			System.out.println(ymove);
			return;
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, x, y;
		n = in.nextInt();
		x = in.nextInt();
		y = in.nextInt();
		in.useDelimiter("\n");
		String board[] = new String[n];

		for (int i = 0; i < n; i++) {
			board[i] = in.next();
		}

		nextMove(n, x, y, board);

	}

}
