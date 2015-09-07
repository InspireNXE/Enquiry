/**
 * This file is part of Enquiry, licensed under the MIT License (MIT).
 *
 * Copyright (c) InspireNXE <http://github.com/InspireNXE/>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.inspirenxe.enquiry.api.event;

import org.inspirenxe.enquiry.api.engine.SearchEngine;
import org.inspirenxe.enquiry.api.engine.SearchResult;
import org.inspirenxe.enquiry.plugin.Enquiry;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.CauseTracked;

import java.util.List;

public interface SearchEvent extends Event, CauseTracked {

    /**
     * Gets the {@link SearchEngine}
     * @return The engine
     */
    SearchEngine getEngine();

    /**
     * Gets the {@link Enquiry} instance
     * @return The Enquiry instance
     */
    Enquiry getEnquiry();

    /**
     * Gets the query being searched for
     * @return The query
     */
    String getQuery();

    /**
     * Fired before the {@link SearchEngine} performs a search
     */
    interface Pre extends SearchEvent, Cancellable {

        /**
         * Sets the query to be searched for
         * @param query The query
         */
        void setQuery(String query);
    }

    /**
     * Fired when a {@link SearchEngine} performs a successful search
     */
    interface Success extends SearchEvent {

        /**
         * Gets the results of the search
         * @return The results
         */
        List<? extends SearchResult> getResults();
    }

    /**
     * Fired when a {@link SearchEngine} fails a search
     */
    interface Failure extends SearchEvent {

    }
}
