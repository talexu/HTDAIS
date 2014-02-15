package com.talexu.htdais_demo_moa;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Word2Vec {
	private HashMap<String, double[]> wordMap = new HashMap<String, double[]>();

	private int words;
	private int size;
	private int topNSize = 40;

	/**
	 * 加载模型
	 * 
	 * @param path
	 *            模型的路径
	 * @throws IOException
	 */
	public void loadModel(String path) throws IOException {
		DataInputStream dis = null;
		BufferedInputStream bis = null;
		double len = 0;
		double vector = 0;
		try {
			bis = new BufferedInputStream(new FileInputStream(path));
			dis = new DataInputStream(bis);
			// //读取词数
			words = Integer.parseInt(readString(dis));
			// //大小
			size = Integer.parseInt(readString(dis));

			String word;
			double[] vectors = null;
			for (int i = 0; i < words; i++) {
				word = readString(dis);
				vectors = new double[size];
				len = 0;
				for (int j = 0; j < size; j++) {
					vector = readFloat(dis);
					len += vector * vector;
					vectors[j] = vector;
				}
				len = Math.sqrt(len);

				for (int j = 0; j < vectors.length; j++) {
					vectors[j] = vectors[j] / len;
				}
				wordMap.put(word, vectors);
				dis.read();
			}

		} finally {
			bis.close();
			dis.close();
		}
	}

	private static final int MAX_SIZE = 50;

	/**
	 * 得到近义词
	 * 
	 * @param word
	 * @return
	 */
	public Set<WordEntry> distance(String word) {
		double[] wordVector = getWordVector(word);
		if (wordVector == null) {
			return null;
		}
		Set<Entry<String, double[]>> entrySet = wordMap.entrySet();
		double[] tempVector = null;
		List<WordEntry> wordEntrys = new ArrayList<WordEntry>(topNSize);
		String name = null;
		for (Entry<String, double[]> entry : entrySet) {
			name = entry.getKey();
			if (name.equals(word)) {
				continue;
			}
			double dist = 0;
			tempVector = entry.getValue();
			for (int i = 0; i < wordVector.length; i++) {
				dist += wordVector[i] * tempVector[i];
			}
			insertTopN(name, dist, wordEntrys);
		}
		return new TreeSet<WordEntry>(wordEntrys);
	}

	/**
	 * 得到一组词的近义词
	 * 
	 * @param words
	 * @return
	 */
	public Set<WordEntry> distance(String[] words) {
		double[] wordsVector = getWordsVector(words);
		if (wordsVector == null) {
			return null;
		}
		double[] tempVector;
		String name;
		List<WordEntry> wordEntrys = new ArrayList<WordEntry>(topNSize);
		keyword: for (Entry<String, double[]> entry : wordMap.entrySet()) {
			name = entry.getKey();
			for (String word : words) {
				if (name.equals(word)) {
					continue keyword;
				}
			}
			double dist = 0;
			tempVector = entry.getValue();
			for (int i = 0; i < wordsVector.length; i++) {
				dist += wordsVector[i] * tempVector[i];
			}
			insertTopN(name, dist, wordEntrys);
		}
		return new TreeSet<WordEntry>(wordEntrys);
	}

	/**
	 * 近义词
	 * 
	 * @return
	 */
	public TreeSet<WordEntry> analogy(String word0, String word1, String word2) {
		double[] wv0 = getWordVector(word0);
		double[] wv1 = getWordVector(word1);
		double[] wv2 = getWordVector(word2);

		if (wv1 == null || wv2 == null || wv0 == null) {
			return null;
		}
		double[] wordVector = new double[size];
		for (int i = 0; i < size; i++) {
			wordVector[i] = wv1[i] + wv0[i] + wv2[i];
		}
		double[] tempVector;
		String name;
		List<WordEntry> wordEntrys = new ArrayList<WordEntry>(topNSize);
		for (Entry<String, double[]> entry : wordMap.entrySet()) {
			name = entry.getKey();
			if (name.equals(word0) || name.equals(word1) || name.equals(word2)) {
				continue;
			}
			double dist = 0;
			tempVector = entry.getValue();
			for (int i = 0; i < wordVector.length; i++) {
				dist += wordVector[i] * tempVector[i];
			}
			insertTopN(name, dist, wordEntrys);
		}
		return new TreeSet<WordEntry>(wordEntrys);
	}

	private void insertTopN(String name, double score,
			List<WordEntry> wordsEntrys) {
		// TODO Auto-generated method stub
		if (wordsEntrys.size() < topNSize) {
			wordsEntrys.add(new WordEntry(name, score));
			return;
		}
		double min = Double.MAX_VALUE;
		int minOffe = 0;
		for (int i = 0; i < topNSize; i++) {
			WordEntry wordEntry = wordsEntrys.get(i);
			if (min > wordEntry.score) {
				min = wordEntry.score;
				minOffe = i;
			}
		}

		if (score > min) {
			wordsEntrys.set(minOffe, new WordEntry(name, score));
		}

	}

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
			if (this.score > o.score) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	/**
	 * 得到词向量
	 * 
	 * @param word
	 * @return
	 */
	public double[] getWordVector(String word) {
		return wordMap.get(word);
	}

	/**
	 * 得到一组词的向量
	 * 
	 * @param words
	 * @return
	 */
	public double[] getWordsVector(String[] words) {
		if (words == null)
			return null;
		double[] wordsVector = null;
		for (String word : words) {
			double[] wordVector = getWordVector(word);
			if (wordVector != null) {
				if (wordsVector == null) {
					wordsVector = wordVector;
				} else {
					for (int i = 0; i < size; i++) {
						wordsVector[i] += wordVector[i];
					}
				}
			}
		}
		return wordsVector;
	}

	public static double readFloat(InputStream is) throws IOException {
		byte[] bytes = new byte[4];
		is.read(bytes);
		return getFloat(bytes);
	}

	/**
	 * 读取一个float
	 * 
	 * @param b
	 * @return
	 */
	public static double getFloat(byte[] b) {
		int accum = 0;
		accum = accum | (b[0] & 0xff) << 0;
		accum = accum | (b[1] & 0xff) << 8;
		accum = accum | (b[2] & 0xff) << 16;
		accum = accum | (b[3] & 0xff) << 24;
		return accum;
	}

	/**
	 * 读取一个字符串
	 * 
	 * @param dis
	 * @return
	 * @throws IOException
	 */
	private static String readString(DataInputStream dis) throws IOException {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[MAX_SIZE];
		byte b = dis.readByte();
		int i = -1;
		StringBuilder sb = new StringBuilder();
		while (b != 32 && b != 10) {
			i++;
			bytes[i] = b;
			b = dis.readByte();
			if (i == 49) {
				sb.append(new String(bytes));
				i = -1;
				bytes = new byte[MAX_SIZE];
			}
		}
		sb.append(new String(bytes, 0, i + 1));
		return sb.toString();
	}

	public int getTopNSize() {
		return topNSize;
	}

	public void setTopNSize(int topNSize) {
		this.topNSize = topNSize;
	}

	public HashMap<String, double[]> getWordMap() {
		return wordMap;
	}

	public int getWords() {
		return words;
	}

	public int getSize() {
		return size;
	}
}
