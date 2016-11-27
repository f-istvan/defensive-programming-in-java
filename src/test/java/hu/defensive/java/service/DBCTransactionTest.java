package hu.defensive.java.service;

import static hu.defensive.java.service.AOPTestHelper.createAOPProxy;
import static junit.framework.Assert.assertEquals;
import hu.defensive.java.service.DBCTransaction;

import java.math.BigDecimal;
import java.util.Date;

import net.sf.oval.exception.ConstraintsViolatedException;

import org.junit.Before;
import org.junit.Test;

public class DBCTransactionTest {
	private static final String EXPECTED_DATA = "";

	private DBCTransaction underTest;

	@Before
	public void setUp() {
		underTest = createAOPProxy(new DBCTransaction());

		// populate LIST_DATA, EXPECTED_DATA...
	}

	@Test
	public void testAdd() {
		// given
		final BigDecimal testAmount = new BigDecimal(10);
		final String testAccount = "0123456789";
		final Date testDate = new Date();
		// when
		final String result = underTest.add(testAmount, testAccount, testDate);
		// then
		assertEquals(result, EXPECTED_DATA);
	}

	@Test(expected = ConstraintsViolatedException.class)
	public void testAddWhenAccountLengthIsLowerThan10() {
		// given
		final BigDecimal testAmount = new BigDecimal(10);
		final String testAccount = "012345678";
		final Date testDate = new Date();
		// when
		final String result = underTest.add(testAmount, testAccount, testDate);
		// then
		assertEquals(result, EXPECTED_DATA);
	}

	@Test(expected = ConstraintsViolatedException.class)
	public void testAddWhenAccountLengthIsGreaterThan10() {
		// given
		final BigDecimal testAmount = new BigDecimal(10);
		final String testAccount = "012345678910";
		final Date testDate = new Date();
		// when
		final String result = underTest.add(testAmount, testAccount, testDate);
		// then
		assertEquals(result, EXPECTED_DATA);
	}

	@Test(expected = ConstraintsViolatedException.class)
	public void whenAddCalledWithNullShouldThrowConstraintsViolatedException() {
		underTest.add(null, null, null);
	}

	@Test
	public void testWithdraw() {
		// given
		final BigDecimal testAmount = new BigDecimal(10);
		final String testAccount = "0123456789";
		final Date testDate = new Date();
		// when
		final String result = underTest.withdraw(testAmount, testAccount,
				testDate);
		// then
		assertEquals(result, EXPECTED_DATA);
	}

	@Test
	public void testTransfer() {
		// given
		final BigDecimal testAmount = new BigDecimal(10);
		final String testAccountFrom = "0123456789";
		final String testAccountTo = "0123456789";
		final Date testDate = new Date();
		// when
		final String result = underTest.transfer(testAmount, testAccountFrom,
				testAccountTo, testDate);
		// then
		assertEquals(result, EXPECTED_DATA);
	}

	@Test(expected = ConstraintsViolatedException.class)
	public void whenWithDrawCalledWithNullShouldThrowConstraintsViolatedException() {
		underTest.withdraw(null, null, null);
	}

	@Test(expected = ConstraintsViolatedException.class)
	public void whenTransferCalledWithNullShouldThrowConstraintsViolatedException() {
		underTest.transfer(null, null, null, null);
	}

}