package org.archive.crawler.framework;

import java.util.logging.Level;

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
            if(!getRunWhileEmpty()) {
                this.sExit = CrawlStatus.FINISHED;
                beginCrawlStop();
            }
            sendCrawlStateChangeEvent(State.EMPTY, CrawlStatus.RUNNING);
            
            break; 
        case PAUSE:
            if (state == State.PAUSING) {
                completePause();
            }
            break;
        case FINISH:
            completeStop();
            requestCrawlStart();
            requestCrawlResume();
            break;
        default:
            // do nothing
        }
    }
	
	/**
     * Called when the last toethread exits.
     */
	@Override
    protected void completeStop() {
        if (!isRunning) {
            return;
        }
        
        LOGGER.fine("Entered complete stop.");

        statisticsTracker.getSnapshot(); // ???
        
        this.reserveMemory = null;
        if (this.toePool != null) {
            this.toePool.cleanup();
        }
        this.toePool = null;

        LOGGER.fine("Finished crawl.");

        try {
            if (appCtx.isRunning()) {
                appCtx.stop();
            }
        } catch (RuntimeException re) {
            LOGGER.log(Level.SEVERE,re.getMessage(),re);
        }
        
        sendCrawlStateChangeEvent(State.FINISHED, this.sExit);

        // CrawlJob needs to be sure all beans have received FINISHED signal before teardown
        this.isStopComplete = true;
    }
}
