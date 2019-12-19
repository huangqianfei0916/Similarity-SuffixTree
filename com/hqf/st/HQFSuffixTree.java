package com.hqf.st;

import java.util.ArrayList;

public class HQFSuffixTree {

	public static double CalculateSimilarity_matrix(String s1, String s2) {
		StringBuffer sBuffer = new StringBuffer(s2);
		String[] c = new String[2];
		c[0] = s2.toUpperCase();
		c[1] = at_gc(String.valueOf(sBuffer.reverse()).toUpperCase());

		double[] kk = new double[2];// 核矩阵格式

		SuffixTree st1 = new SuffixTree();
		st1.build(s1.toUpperCase() + "$");
		for (int i = 0; i < c.length; i++) {

			int index = 0;

			int flag[] = new int[200];
			int flag1[] = new int[200];
			int l = 0;
			int cz = 0;
			ArrayList<Integer> result = new ArrayList();
			while (index < c[i].length()) {
				// a[1]为匹配的个数，a[0]是构建suffix的string的下标
				int[] a = st1.selectPrefixForAlignment(c[i], index);
				if (a[1] > Math.abs(a[0] - index)) {

					result.add(a[0]);
					result.add(index);

					index += a[1];
					flag1[l] = a[1];
					flag[l] = a[0];

					if (l > 0 && flag[l - 1] + flag1[l - 1] > a[0]) {
						cz = flag[l - 1] + flag1[l - 1] - a[0];
						if (a[1] > cz) {
							a[1] -= cz;
						} else {
							a[1] = 0;
						}
					}
					result.add(a[1]);
					l++;

				} else if (a[1] > 0)
					index += a[1];
				else
					index++;
			}
			int[][] tmp = new int[3][result.size() / 3];
			int m = 0;
			while (m < result.size()) {
				tmp[0][m / 3] = result.get(m);
				m++;
				tmp[1][m / 3] = result.get(m);
				m++;
				tmp[2][m / 3] = result.get(m);
				m++;
			}

			int match = 0;
			for (int ss = 0; ss < tmp[2].length; ss++) {
				match += tmp[2][ss];

			}
			double len = Math.max(s1.length(), s2.length());

			double sim1 = match / len;

			kk[i] = sim1;
		}

		double sim = Math.max(kk[0], kk[1]);

		return sim;

	}

	public static String at_gc(String s1) {
		char[] s = s1.toCharArray();
		for (int i = 0; i < s.length; i++) {
			if (s[i] == 'A') {
				s[i] = 'T';
			} else if (s[i] == 'T') {
				s[i] = 'A';
			} else if (s[i] == 'G') {
				s[i] = 'C';

			} else {
				s[i] = 'G';
			}

		}

		return String.valueOf(s);

	}

}
