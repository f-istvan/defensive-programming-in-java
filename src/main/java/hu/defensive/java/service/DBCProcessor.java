package hu.defensive.java.service;

import hu.defensive.java.domain.ProcessableItem;
import hu.defensive.java.interfaces.Processor;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

@Guarded
public class DBCProcessor implements Processor {

	@Override
	@NotNull
	public ProcessableItem process(@NotNull final ProcessableItem item) {
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
