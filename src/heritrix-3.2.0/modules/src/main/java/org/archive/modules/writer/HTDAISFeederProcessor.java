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

	private static int count = 1;
	private static boolean flag = true;

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

//		File outputFile = new File("/Users/bjutales/Downloads/TestCrawl/"
//				+ count++ + ".txt");
//		RecordingInputStream recis = uri.getRecorder().getRecordedInput();
//		if (0L == recis.getResponseContentLength()) {
//			return;
//		}
//		try {
//			writeToPath(recis, outputFile);
//
//		} catch (IOException ioException) {
//			System.err.println("File Error!");
//		} finally {
//			System.out.println("Mission complete!");
//			flag = false;
//		}
	}

	// private void writeToPath(RecordingInputStream recis, File dest)
	// throws IOException {
	// File tf = new File(dest.getPath() + "N");
	// ReplayInputStream replayis = null;
	// FileOutputStream fos = null;
	// try {
	// replayis = recis.getMessageBodyReplayInputStream();
	// fos = new FileOutputStream(tf);
	//
	// replayis.readFullyTo(fos);
	// } finally {
	// IOUtils.closeQuietly(replayis);
	// IOUtils.closeQuietly(fos);
	// }
	// if (!tf.renameTo(dest)) {
	// throw new IOException("Can not rename " + tf.getAbsolutePath()
	// + " to " + dest.getAbsolutePath());
	// }
	//
	// }
}
