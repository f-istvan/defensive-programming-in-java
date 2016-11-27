package hu.defensive.java.service;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertEquals;
import hu.defensive.java.domain.ProcessableItem;
import hu.defensive.java.service.SimpleProcessor;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SimpleProcessorTest {
	private static final List<String> TEST_DATA = newArrayList();
	private static final List<String> EXPECTED_DATA = newArrayList();

	private SimpleProcessor underTest;

	@Before
	public void setUp() {
		underTest = new SimpleProcessor();
		// populate LIST_DATA, EXPECTED_DATA...
	}

	@Test
	public void testProcess() {
		// given
		final ProcessableItem testItem = createProcessableItem();
		// when
		final ProcessableItem result = underTest.process(testItem);
		// then
		assertEquals(result.getData(), EXPECTED_DATA);
	}

	private ProcessableItem createProcessableItem() {
		final ProcessableItem processableItem = new ProcessableItem();
		processableItem.getData().addAll(TEST_DATA);
		return processableItem;
	}

}
