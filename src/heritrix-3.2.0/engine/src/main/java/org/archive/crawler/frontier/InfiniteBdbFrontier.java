package org.archive.crawler.frontier;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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

	ScheduledExecutorService scheduledThreadPool = Executors
			.newScheduledThreadPool(5);
	AtomicInteger emptyQuery = new AtomicInteger(0);

	/** Delay before recrawl */
	protected long delay = 500;

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	/**
	 * If frontier is exhausted, reload seeds
	 * 
	 * @see org.archive.crawler.framework.Frontier#isEmpty()
	 */
	public boolean isEmpty() {
		boolean empty = super.isEmpty();
		if (empty && emptyQuery.getAndAdd(1) == 0) {
			scheduledThreadPool.schedule(new Runnable() {
				@Override
				public void run() {
					getSeeds().announceSeeds();
					emptyQuery.set(0);
				}
			}, getDelay(), TimeUnit.SECONDS);
		}
		return empty;
	}
}
