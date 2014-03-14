package com.talexu.htdais.word2vec;

public class WordEntry implements Comparable<WordEntry> {
	public String name;
	public double score;

	public WordEntry(String name, double score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "\t" + score;
	}

	public int compareTo(WordEntry o) {
		// TODO Auto-generated method stub
		if (this.score < o.score) {
			return 1;
		} else {
			return -1;
		}
	}

}