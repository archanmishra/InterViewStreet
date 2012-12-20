import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Solution {
	static class Token {
		private Token[] tokens = new Token[2];
		private boolean skipable = false;
		private int value = -1;

		public Token() {
		}

		public Token(int value) {
			this.value = value;
		}

		public Token(int value, boolean skipable) {
			this.skipable = skipable;
			this.value = value;
		}

		public Token Add(Token b) {
			Token a = new Token();
			a.tokens[0] = this;
			a.tokens[1] = b;
			a.skipable = this.skipable || b.skipable;
			return a;
		}

		public Token[] getTokens() {
			return tokens;
		}

		public int getLastIndex() {
			if (this.value != -1) {
				return value;
			} else {
				return this.tokens[1].getLastIndex();
			}
		}

		public String toString(String str) {
			StringBuilder sb = new StringBuilder();
			if (value != -1) {
				sb.append(str.charAt(value));
			} else {
				for (Token token : tokens) {
					sb.append(token.getValue(str));
				}
			}
			return sb.toString();
		}

		public String getValue(String str) {
			if (this.value != -1) {
				return String.valueOf(str.charAt(this.value));
			}
			StringBuilder sb = new StringBuilder();
			for (Token t : tokens) {
				sb.append(t.getValue(str));
			}
			return sb.toString();
		}

		public boolean equals(Object o) {
			if (o instanceof Token) {
				Token new_name = (Token) o;
				return (new_name.value == this.value);
			}
			return false;
		}

	}

	static class Node {
		private String value = null;
		private Node next = null;

		static Node Head = null;

		public Node(String val) {
			this.value = val;
		}

		// insert unique string order by lexicography
		public static void addToken(String str) {
			Node temp, prev, temp1;
			if (Head == null) {
				Head = new Node(str);
			} else {
				if (str.compareTo(Head.value) < 0) {
					temp = new Node(str);
					temp.next = Head;
					Head = temp;
				} else if (str.compareTo(Head.value) == 0) {
					return;
				} else {
					prev = Head;
					temp = Head.next;
					while (temp != null) {
						if (str.compareTo(temp.value) == 0) {
							return;
						}
						if (str.compareTo(temp.value) < 0) {
							temp1 = new Node(str);
							prev.next = temp1;
							temp1.next = temp;
							return;
						}
						prev = temp;
						temp = temp.next;
					}
					temp1 = new Node(str);
					prev.next = temp1;
				}

			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			int N, Q, i;

			/**
			 * Constraints: 1<=n<=50 1<=mi<=2000 1<=q<=500 1<=k<=1000000000
			 */

			line = br.readLine();
			N = Integer.valueOf(line);
			if (N > 50) {
				return;
			}
			String[] strings = new String[N];
			for (i = 0; i < N; i++) {
				strings[i] = br.readLine();
				if (strings[i].length() > 2000) {
					return;
				}
			}

			Q = Integer.valueOf(br.readLine());
			if (Q > 500) {
				return;
			}
			LinkedHashMap<Integer, String> q = new LinkedHashMap<Integer, String>();
			int qi;
			for (i = 0; i < Q; i++) {
				qi = Integer.valueOf(br.readLine());
				if (qi > 1000000000)
					return;
				q.put(qi, "INVALID");

			}
			ArrayList<Token> temp;
			for (i = 0; i < N; i++) {
				temp = makeProperSubset(strings[i]);
				for (Token t : temp) {
					Node.addToken(t.toString(strings[i]));
				}
			}
			Node tempU = Node.Head;
			i = 0;
			while (tempU != null) {
				if (q.containsKey(i + 1)) {
					q.put(i + 1, tempU.value);
				}
				tempU = tempU.next;
				i++;
			}
			for (String val : q.values()) {
				System.out.println(val);
			}

		} catch (IOException e) {
			return;
		}
	}

	private static ArrayList<Token> makeProperSubset(String s) {
		ArrayList<Token> sub = new ArrayList<Token>();

		int subsetLen = (int) Math.pow(2.0, (float) s.length()) - 1;
		int start_pos = 1, i, curr_pos = 1, len = s.length(), reset_pos = start_pos, last_token_index;
		Token[] chars = new Token[len];
		Token current_prefix = null;
		Token next_prefix = null;

		for (i = 0; i < len - 1; i++) {
			chars[i] = new Token(i);
			sub.add(chars[i]);
		}
		chars[len - 1] = new Token(len - 1, true);
		sub.add(chars[len - 1]);
		// if the set has 2 or less elements
		switch (subsetLen) {

		case 1:
			return sub;
		case 3:
			sub.add(sub.get(0).Add(sub.get(1)));
			break;
		default:
			curr_pos = 0;
			while (curr_pos < (sub.size() - 1)) {
				current_prefix = sub.get(curr_pos);
				// skip condition
				// if contains last element then skip.
				// if the reset-index is at last don't increment it.
				if (current_prefix.skipable) {
					next_prefix = sub.get(curr_pos + 1);
					last_token_index = next_prefix.getLastIndex();
					if (last_token_index != len - 1) {
						start_pos = last_token_index + 1;
					} else {
						start_pos = (start_pos == len - 1) ? start_pos
								: (start_pos + 1);
					}
					reset_pos = start_pos;
				} else {
					for (i = reset_pos; i < len; i++) {
						sub.add(current_prefix.Add(chars[i]));
					}
					reset_pos++;
				}
				curr_pos++;
			}
		}
		return sub;
	}
}
