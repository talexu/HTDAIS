package org.archive.modules.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.archive.io.RecordingInputStream;
import org.archive.io.ReplayInputStream;
import org.archive.modules.CrawlURI;
import org.archive.modules.Processor;

public class HTDAISFeederProcessor extends Processor {

	@Override
	protected boolean shouldProcess(CrawlURI uri) {
		if (uri.getContentType().contains("text/html")) {
			return true;
		}
		return false;
	}

	@Override
	protected void innerProcess(CrawlURI uri) throws InterruptedException {
		// TODO Auto-generated method stub
		RecordingInputStream recis = uri.getRecorder().getRecordedInput();
        if (0L == recis.getResponseContentLength()) {
            return;
        }
        
		File tf = new File ("/Users/bjutales/Downloads/TestCrawl" + uri.getURI());
        ReplayInputStream replayis = null;
        FileOutputStream fos = null;
        try {
            replayis = recis.getMessageBodyReplayInputStream();
            fos = new FileOutputStream(tf);

            replayis.readFullyTo(fos);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            IOUtils.closeQuietly(replayis);
            IOUtils.closeQuietly(fos);
        }
	}

}
