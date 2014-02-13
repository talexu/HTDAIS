package com.talexu.htdais_corpus_splitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.ansj.util.FilterModifWord;

/**
 * Hello world!
 * 
 */
public class App {
	public static final String TAG_START_CONTENT = "<content>";
	public static final String TAG_END_CONTENT = "</content>";
	public static final String TAG_START_TITLE = "<contenttitle>";
	public static final String TAG_END_TITLE = "</contenttitle>";

	static Pattern pattern = Pattern.compile(String.format(
			"(^%s|%s)(.+)(%s$|%s)", TAG_START_CONTENT, TAG_START_TITLE,
			TAG_END_CONTENT, TAG_END_TITLE));

	public static void main(String[] args) {
		initializeStopWord();

		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(
				new FileInputStream(inputFile), "gbk"));
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(outputFile), "UTF-8")))) {

			String text;
			while ((text = input.readLine()) != null) {
				Matcher matcher = pattern.matcher(text);
				if (matcher.find()) {
					// System.out.println(matcher.group(2));
					for (Term term : FilterModifWord.modifResult(ToAnalysis
							.parse(matcher.group(2)))) {
						String word = term.getName();
						out.print(word);
						out.print(" ");
					}
					out.println();
				}
			}
		} catch (IOException ioException) {
			System.err.println("File Error!");
		} finally {
			System.out.println("Mission complete!");
		}
	}

	private static void initializeStopWord() {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("library/HIT_stopword.dic")),
				"gbk"))) {
			String text;
			while ((text = input.readLine()) != null) {
				FilterModifWord.insertStopWord(text);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
