package hu.defensive.java.service;

import hu.defensive.java.interfaces.Transaction;

import java.math.BigDecimal;
import java.util.Date;

import net.sf.oval.constraint.DateRange;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.guard.Guarded;

@Guarded
public class DBCTransaction implements Transaction {

	@Override
	public String add(
			@NotNull @NotNegative final BigDecimal amount,
			@NotNull @Length(min = 10, max = 10) final String account,
			@NotNull @DateRange(min = "yesterday") final Date transactionDate) {
		return "";
	}

	@Override
	public String withdraw(
			@NotNull @NotNegative final BigDecimal amount,
			@NotNull @MaxLength(10) final String account,
			@NotNull @DateRange(min = "yesterday") final Date transactionDate) {
		return "";
	}

	@Override
	public String transfer(
			@NotNull @NotNegative final BigDecimal amount,
			@NotNull @MaxLength(10) final String accountFrom,
			@NotNull @MaxLength(10) final String accountTo,
			@NotNull @DateRange(min = "yesterday") final Date transactionDate) {
		return "";
	}

}
