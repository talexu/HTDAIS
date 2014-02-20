/*
 *  This file is part of the Heritrix web crawler (crawler.archive.org).
 *
 *  Licensed to the Internet Archive (IA) by one or more individual 
 *  contributors. 
 *
 *  The IA licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.archive.crawler.frontier.precedence;

import org.archive.modules.CrawlURI;

/**
 * UriPrecedencePolicy which assigns URIs a precedence equal to the number
 * of hops in its hops-path-from-seed (either all hops or just navlink ('L')
 * hops. 
 */
public class HopsUriPrecedencePolicy extends BaseUriPrecedencePolicy {
    private static final long serialVersionUID = 2602303562177294731L;

    /** whether to count only navlinks ('L'), or all hops */
    {
        setNavlinksOnly(true);
    }
    public boolean getNavlinksOnly() {
        return (Boolean) kp.get("navlinksOnly");
    }
    public void setNavlinksOnly(boolean navsOnly) {
        kp.put("navlinksOnly",navsOnly);
    }

    /* (non-Javadoc)
     * @see org.archive.crawler.frontier.precedence.BaseUriPrecedencePolicy#calculatePrecedence(org.archive.crawler.datamodel.CrawlURI)
     */
    @Override
    protected int calculatePrecedence(CrawlURI curi) {
        return super.calculatePrecedence(curi) + 
            ((getNavlinksOnly()) 
                    ? curi.getLinkHopCount() 
                    : curi.getPathFromSeed().length());
    }
}
