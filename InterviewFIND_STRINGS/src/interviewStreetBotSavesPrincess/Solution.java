package interviewStreetBotSavesPrincess;

import java.util.*;

public class Solution {

	/* Head ends here */
	static void nextMove(int m, String[] grid) {
		int px = 0, py = 0;
		int mx = 0, my = 0;
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < m; j++) {
				if (grid[i].charAt(j) == 'm'){
					mx = i;
					my = j;
				}else if (grid[i].charAt(j) == 'p'){
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
		for(i =0; i < xdiff; i++){
			System.out.println(xmove);
		}
		for(i=0; i< ydiff; i++){
			System.out.println(ymove);
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m;
		m = in.nextInt();
		String grid[] = new String[m];
		for (int i = 0; i < m; i++) {
			grid[i] = in.next();
		}

		nextMove(m, grid);
	}
}