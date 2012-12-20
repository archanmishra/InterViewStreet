import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System;
import java.util.ArrayList;

public class Solution {
	private class Token{
		private ArrayList<Token> tokens;
		private boolean skipable = false;
		public Token(){
			tokens = new ArrayList<Token>();
		}
		public Token Add(Token b){
			Token a = new Token();
			tokens.addAll(b.getTokens());
			return a;
		}
		public ArrayList<Token> getTokens(){
			return tokens;
		}
	}

	public Solution(){
		
	}
	public static void main(String[] args) {
		ArrayList<String> subsets = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			int N, Q, i, counter = 0;
			line = br.readLine();
			N = Integer.valueOf(line);
			String[] strings = new String[N];
			for (i = 0; i < N; i++) {
				strings[i] = br.readLine();
			}

			// ---|||---\\ Q = Integer.valueOf(br.readLine());
			// ---|||---\\ int[] q = new int[Q];
			// ---|||---\\ for (i = 0; i < Q; i++) {
			// ---|||---\\ q[i] = Integer.valueOf(br.readLine());
			// ---|||---\\ }
			ArrayList<String> temp;
			for (i = 0; i < N; i++) {
				temp = makeProperSubset(strings[i]);
				subsets.addAll(temp);
			}
			System.out.println(subsets.size());
			// for (String s : subsets)
			// System.out.println(s);

		} catch (IOException e) {
			return;
		}
	}

	private static ArrayList<String> makeProperSubset(String s) {
		ArrayList<String> sub = new ArrayList<String>();

		int subsetLen = (int) Math.pow(2.0, (float) s.length()) - 1;
		int start_pos = 1, i, curr_pos = 1, len = s.length(), reset_pos = start_pos, last_token_index;
		String[] chars = new String[len];
		String current_prefix = null;
		String next_prefix = null;
		String last_token = null;

		for (i = 0; i < len; i++) {
			chars[i] = s.substring(i, i + 1);
			sub.add(chars[i]);
		}

		// if the set has 2 or less elements
		switch (subsetLen) {

		case 1:
			return sub;
		case 3:
			sub.add(s);
			break;
		default:
			curr_pos = 0;
			while (curr_pos < (sub.size() - 1)) {
				current_prefix = sub.get(curr_pos);
				// skip condition
				// if contains last element then skip.
				// if the reset-index is at last don't increment it.
				if (current_prefix.contains(chars[chars.length - 1])) {
					next_prefix = sub.get(curr_pos + 1);
					last_token = next_prefix
							.substring(next_prefix.length() - 1);
					if (!last_token.equalsIgnoreCase(chars[chars.length - 1])) {
						for (i = 0; i < chars.length; i++) {
							if (chars[i].equalsIgnoreCase(last_token))
								break;
						}						
						start_pos = i +1;
					} else {
						start_pos = (start_pos == len - 1) ? start_pos
								: (start_pos + 1);
					}
					reset_pos = start_pos;
				} else {
					for (i = reset_pos; i < len; i++) {
						sub.add(current_prefix + chars[i]);
					}
					reset_pos++;
				}
				curr_pos++;
			}
		}
		return sub;
	}
}
