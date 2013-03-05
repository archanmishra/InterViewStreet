package interviewStreetInsertionSort;

/* Head ends here */
import java.util.*;

public class Solution {

	static void insertionSort(int[] ar) {
		int temp = ar[ar.length - 1];
		for (int i = ar.length - 2; i >= 0; i--) {
			if (ar[i] > temp) {
				shiftRight(ar, i);
				printArray(ar);
			} else {
				ar[i + 1] = temp;
				printArray(ar);				
				return;
			}
		}
		ar[0] = temp;
		printArray(ar);	
	}

	private static void shiftRight(int[] ar, int pos) {
		ar[pos + 1] = ar[pos];
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
