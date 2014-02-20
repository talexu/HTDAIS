package org.archive.modules.deciderules;

import org.archive.modules.CrawlURI;
import org.apache.commons.httpclient.HttpMethod;

/**
 * Provides a rule that returns "true" for any CrawlURIs which has a fetch
 * status code that does not fall within the provided inclusive range. For
 * instance, to reject any URIs with a "client error" status code you must
 * provide the range 400 to 499.
 * 
 * @author cmiles74
 */
public class NotMatchesStatusCodeDecideRule extends PredicatedDecideRule {

    /** Default lower bound */
    public final static Integer DEFAULT_LOWER_BOUND = new Integer(0);

    /** Default upper bound */
    public final static Integer DEFAULT_UPPER_BOUND = new Integer(600);

    /**
     * Creates a new NotMatchesStatusCodeDecideRule instance. Note
     * that this will return a rule that will return "true" for all
     * valid status codes (and some invalide ones, too).
     */
    public NotMatchesStatusCodeDecideRule() {

        // set our default bounds
        kp.put("lowerBound", DEFAULT_LOWER_BOUND);
        kp.put("upperBound", DEFAULT_UPPER_BOUND);
    }

    /**
     * Sets the lower bound on the range of acceptable status codes.
     *
     * @param Integer Status code
     */
    public void setLowerBound(Integer statusCode) {

        kp.put("lowerBound", statusCode);
    }

    /**
     * Returns the lower bound on the range of acceptable status codes.
     *
     * @returns Integer Status code
     */
    public Integer getLowerBound() {

        Object value = kp.get("lowerBound");

        if(value != null) {

            return((Integer) value);
        }

        return(null);
    }

    /**
     * Sets the upper bound on the range of acceptable status codes.
     *
     * @param Integer Status code
     */
    public void setUpperBound(Integer statusCode) {

        kp.put("upperBound", statusCode);
    }

    /**
     * Returns the upper bound on the range of acceptable status codes.
     *
     * @returns Integer Status code
     */
    public Integer getUpperBound() {

        Object value = kp.get("upperBound");

        if(value != null) {

            return((Integer) value);
        }

        return(null);
    }

    /**
     * Returns "true" if the provided CrawlURI has a fetch status that does not
     * fall within this instance's specified range.
     * 
     * @param CrawlURI
     *            The URI to be evaluated
     * @return true If the CrawlURI has a fetch status outside the specified
     *         range
     */
    @Override
    protected boolean evaluate(CrawlURI uri) {

        // by default, we'll return false
        boolean value = false;

        int statusCode = uri.getFetchStatus();

        if (statusCode <= getLowerBound().intValue()
                || statusCode >= getUpperBound().intValue()) {

            value = true;
        }

        return (value);
    }
}