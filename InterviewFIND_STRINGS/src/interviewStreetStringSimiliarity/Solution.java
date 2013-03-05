package interviewStreetStringSimiliarity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static int getSuffixesSimiliarity(char[] str) {
		int i = 0, c = 0;
		for (; i < str.length; i++) {

			for (int j = 0; j < str.length - i; j++) {
				try {
					if (str[j] == str[i + j]) {
						c++;
					} else {
						break;
					}
				} catch (IndexOutOfBoundsException e) {
					break;
				}
			}

		}
		return c;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			line = br.readLine();
			int noOfInputs = Integer.valueOf(line);
			String[] inputs = new String[noOfInputs];
			for (int i = 0; i < noOfInputs; i++) {
				inputs[i] = br.readLine();
			}
			for (int i = 0; i < noOfInputs; i++) {
				System.out.println(getSuffixesSimiliarity(inputs[i].toCharArray()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
