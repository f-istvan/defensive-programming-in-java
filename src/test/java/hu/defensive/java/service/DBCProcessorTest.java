package hu.defensive.java.service;

import static com.google.common.collect.Lists.newArrayList;
import static hu.defensive.java.service.AOPTestHelper.createAOPProxy;
import static junit.framework.Assert.assertEquals;
import hu.defensive.java.domain.ProcessableItem;
import hu.defensive.java.service.DBCProcessor;

import java.util.List;

import net.sf.oval.exception.ConstraintsViolatedException;

import org.junit.Before;
import org.junit.Test;

public class DBCProcessorTest {

	private static final List<String> TEST_DATA = newArrayList();
	private static final List<String> EXPECTED_DATA = newArrayList();

	private DBCProcessor underTest;

	@Before
	public void setUp() {
		underTest = createAOPProxy(new DBCProcessor());

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

	@Test(expected = ConstraintsViolatedException.class)
	public void whenProcessCalledWithNullShouldThrowConstraintsViolatedException() {
		underTest.process(null);
	}

	private ProcessableItem createProcessableItem() {
		final ProcessableItem processableItem = new ProcessableItem();
		processableItem.getData().addAll(TEST_DATA);
		return processableItem;
	}

}