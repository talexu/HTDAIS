package org.archive.modules.writer;

import org.archive.modules.CrawlURI;
import org.archive.modules.Processor;

public class HTDAISFeederProcessor extends Processor {

	@Override
	protected boolean shouldProcess(CrawlURI uri) {
		if (uri.getContentType().contains("text/html")
				&& uri.getFetchStatus() == 200) {
			return true;
		}
		return false;
	}

	@Override
	protected void innerProcess(CrawlURI uri) throws InterruptedException {
		// TODO Auto-generated method stub

	}

}
