package interviewStreetQuickSort;

import java.util.Scanner;

public class Solution {
	static int[] partition(int[] ar, int pivot, int length) {
		if (length <= 1) {
			return ar;
		}
		int[] before = new int[length-1];
		int[] after = new int[length-1];
		int i, j = 0, k = 0;
		for (i = 1; i < length; i++) {
			if (ar[i] < pivot) {
				before[j] = ar[i];
				j++;
			} else {
				after[k] = ar[i];
				k++;
			}
		}
		i = merge(ar, pivot, partition(before, before[0], j),
				partition(after, after[0], k), j, k);
		printArray(ar, length);
		return ar;
	}

	private static int merge(int[] ar, int pivot, int[] before, int[] after,
			int j, int k) {
		int i;
		for (i = 0; i < j; i++) {
			ar[i] = before[i];
		}
		ar[i] = pivot;
		for (i = j + 1; i <= k + j; i++) {

			ar[i] = after[i - j - 1];
		}
		return i;
	}

	/* Tail starts here */

	static void printArray(int[] ar, int length) {
		for (int i = 0; i < length; i++) {
				System.out.print(ar[i] + " ");
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
		partition(ar, ar[0], ar.length);
	}
}
