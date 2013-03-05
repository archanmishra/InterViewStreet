package interviewStreetCountPairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			line = br.readLine();

			String[] tokens = line.split(" ");
			int N, K, counter = 0;
			N = Integer.valueOf(tokens[0]);
			K = Integer.valueOf(tokens[1]);
			line = br.readLine();
			tokens = line.split(" ");
			int[] numbers = new int[N];
			for (int i = 0; i < N; i++) { 
				numbers[i] = Integer.valueOf(tokens[i]);
			}
			Arrays.sort(numbers);
			for (int i = 0; i < N-1; i++) {
				if(numbers[i] + K > numbers[numbers.length-1])
					break;
				for (int j = i+1; j < N; j++) {
					if ((numbers[i] + K == numbers[j])||(numbers[i] - K == numbers[j])) {
						counter++;
						break;
					}
				}
			}
			System.out.println(counter);
		} catch (IOException e) {
			return;
		}
	}

}