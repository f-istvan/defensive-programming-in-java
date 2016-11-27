package hu.defensive.java.service;

import hu.defensive.java.domain.ProcessableItem;
import hu.defensive.java.interfaces.Processor;

public class SimpleProcessor implements Processor {

	/**
	 * Processes data with less than 10 chars.
	 * 
	 * @return the processed data.
	 */
	@Override
	public ProcessableItem process(final ProcessableItem item) {
		if (item == null) {
			throw new IllegalArgumentException();
		}

		ProcessableItem newItem = null;
		if (item.getData().size() < 10) {
			newItem = doProcessData(item);
		}
		return newItem;
	}

	private ProcessableItem doProcessData(final ProcessableItem item) {
		// do something
		return item;
	}

}
