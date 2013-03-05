package interviewStreetBotCleans;

import java.util.*;

public class Solution {

	/* Head ends here */
	static void next_move(int posx, int posy, String[] board) {
		if (board[posx].charAt(posy) == 'd') {
			System.out.println("CLEAN");
			return;
		}
//		boolean noY = true;
//		int ydist = 0;
//		if (board[posx].indexOf('d', 0) != -1) {
//			ydist = board[posx].indexOf('d', 0) - posy;
//			noY = false;
//		}
//
//		int xdist = 99999;
//		for (int i = 0; i < board.length; i++) {
//			if (board[i].charAt(posy) == 'd') {
//				if (Math.abs(i - posx) < xdist) {
//					xdist = i - posx;
//				}
//			}
//		}
//		if (((Math.abs(xdist) < Math.abs(ydist)) || (noY)) && (xdist < 99999)) {
//			System.out.println(xdist < 0 ? "UP" : "DOWN");
//		} else if (!noY) {
//			System.out.println(ydist < 0 ? "LEFT" : "RIGHT");
//		} else {
			int indexY;
			double dirtDist = 99999, tempDist = 0;
			String currDir = "";
			for (int i = 0; i < board.length; i++) {
				indexY = board[i].indexOf('d');
				if (indexY != -1) {
					tempDist = (i - posx) ^ 2 + (indexY - posy) ^ 2;
					// System.out.println(tempDist);
					if ((tempDist < dirtDist) && (tempDist != 0)) {
						// System.out.println("reassign");
						dirtDist = tempDist;
						currDir = getDir(i - posx, indexY - posy);
					}
				}
			}
			System.out.println(currDir);
//		}
	}

	private static String getDir(int xdist, int ydist) {
		// System.out.println(xdist+" ,"+ ydist);
		if (ydist == 0)
			ydist = 99999;
		if (xdist == 0)
			xdist = 99999;
		if (Math.abs(xdist) < Math.abs(ydist)) {
			return (xdist < 0 ? "UP" : "DOWN");
		} else {
			return (ydist < 0 ? "LEFT" : "RIGHT");
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] pos = new int[2];
		String board[] = new String[5];
		for (int i = 0; i < 2; i++)
			pos[i] = in.nextInt();
		for (int i = 0; i < 5; i++)
			board[i] = in.next();
		next_move(pos[0], pos[1], board);
	}
}
