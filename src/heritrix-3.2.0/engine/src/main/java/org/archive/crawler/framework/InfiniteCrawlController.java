package org.archive.crawler.framework;

import org.archive.crawler.framework.CrawlController.State;

public class InfiniteCrawlController extends CrawlController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Receive notification from the frontier, in the frontier's own 
     * manager thread, that the frontier has reached a new state. 
     * 
     * @param reachedState the state the frontier has reached
     */
	@Override
    public void noteFrontierState(Frontier.State reachedState) {
        switch (reachedState) {
        case RUN: 
            LOGGER.info("Crawl running.");
            sendCrawlStateChangeEvent(State.RUNNING, CrawlStatus.RUNNING);
            break;
        case EMPTY: 
            LOGGER.info("Crawl empty.");
//            if(!getRunWhileEmpty()) {
//                this.sExit = CrawlStatus.FINISHED;
//                beginCrawlStop();
//            }
//            sendCrawlStateChangeEvent(State.EMPTY, CrawlStatus.RUNNING);
            requestCrawlStart();
            requestCrawlResume();
            break; 
        case PAUSE:
            if (state == State.PAUSING) {
                completePause();
            }
            break;
        case FINISH:
            completeStop();
            break;
        default:
            // do nothing
        }
    }
}
