package org.archive.modules.writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;

import org.apache.commons.io.IOUtils;
import org.archive.io.RecordingInputStream;
import org.archive.io.ReplayInputStream;
import org.archive.modules.CrawlURI;
import org.archive.modules.Processor;

public class HTDAISFeederProcessor extends Processor {

	private static int count = 10;

	@Override
	protected boolean shouldProcess(CrawlURI uri) {
		// if (uri.getContentType().contains("text/html")) {
		// return true;
		// }
		// return false;
		return true;
	}

	@Override
	protected void innerProcess(CrawlURI uri) throws InterruptedException {
		// TODO Auto-generated method stub
		// RecordingInputStream recis = uri.getRecorder().getRecordedInput();
		// if (0L == recis.getResponseContentLength()) {
		// return;
		// }
		//
		// File tf = new File ("/Users/bjutales/Downloads/TestCrawl/" +
		// uri.getURI());
		// ReplayInputStream replayis = null;
		// FileOutputStream fos = null;
		// try {
		// replayis = recis.getMessageBodyReplayInputStream();
		// fos = new FileOutputStream(tf);
		//
		// replayis.readFullyTo(fos);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// IOUtils.closeQuietly(replayis);
		// IOUtils.closeQuietly(fos);
		// }

		File outputFile = new File(
				"/Users/bjutales/Downloads/TestCrawl/test.txt");
		PrintWriter out = null;
		if (count-- > 0) {

			try {

				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(outputFile), "UTF-8")));

				out.println(count + ": " + uri.getURI());

			} catch (IOException ioException) {
				System.err.println("File Error!");
			} finally {
				System.out.println("Mission complete!");
			}
		}
		if (count == 0) {
			out.close();
		}
	}

}
