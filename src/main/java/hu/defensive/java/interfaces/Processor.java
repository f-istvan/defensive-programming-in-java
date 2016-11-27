package hu.defensive.java.interfaces;

import hu.defensive.java.domain.ProcessableItem;

public interface Processor {

    /**
     * Processes an item and returns the result which is also processable.
     * 
     * @param item
     *            a processable item to process. Read only, the processed object
     *            is returned. Must not be null.
     * @return the processed result which is never null.
     * @throws IllegalArgumentException
     *             when input item is null.
     */
    ProcessableItem process(ProcessableItem item);
}
