package com.talexu.htdais.word2vec;

import java.util.List;
import java.util.Set;

public interface VectorCalculator {

	public Set<WordEntry> distance(String queryWord);

	public Set<WordEntry> distance(List<String> words);

	public double[] getWordVector(String word);

	public double[] getWordsVector(List<String> words);

	public double distance(double[] v1, double[] v2);
}
