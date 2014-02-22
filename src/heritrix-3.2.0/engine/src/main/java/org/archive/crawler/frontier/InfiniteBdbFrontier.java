package org.archive.crawler.frontier;

import org.archive.modules.CrawlURI;

public class InfiniteBdbFrontier extends BdbFrontier {

	/**
	 * When notified of a seed via the SeedListener interface, always schedule
	 * it.
	 * 
	 * @see org.archive.modules.seeds.SeedListener#addedSeed(org.archive.modules.CrawlURI)
	 */
	@Override
	public void addedSeed(CrawlURI puri) {
		puri.setForceFetch(true);
		super.addedSeed(puri);
	}

	/**
	 * If frontier is exhausted, reload seeds
	 * 
	 * @see org.archive.crawler.framework.Frontier#isEmpty()
	 */
	public boolean isEmpty() {
		if (queuedUriCount.get() == 0
				&& (uriUniqFilter == null || uriUniqFilter.pending() == 0)
				&& futureUriCount.get() == 0) {
			getSeeds().announceSeeds();
		}
		return false;
	}
}
