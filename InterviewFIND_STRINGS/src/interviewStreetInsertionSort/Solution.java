package interviewStreetInsertionSort;

/* Head ends here */
import java.util.*;

public class Solution {
	static int shifts = 0;
	static void insertionSort(int[] ar) {
		int j = ar.length - 1;
		int i = 0;
//		if (ar.length <= 2) {
////			printArray(ar);
//			return;
//		}
		for (j = 1; j < ar.length; j++) {
			int temp = ar[j];
			for (i = j - 1; i >= 0; i--) {
				if (ar[i] > temp) {
					shiftRight(ar, i);
				} else {
					ar[i + 1] = temp;
					break;
				}
			}
			if (i == -1) {
				ar[0] = temp;
			}
//			printArray(ar);
		}
		System.out.println(shifts);
	}

	private static void shiftRight(int[] ar, int pos) {
		ar[pos + 1] = ar[pos];
		shifts ++;
	}

	/* Tail starts here */

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
	}
}
