package hu.defensive.java.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface Transaction {

    /**
     * Add the given money to the account.
     * 
     * @param amount
     *            cannot be null or negative
     * @param account
     *            cannot be null, 10 chars length
     * @param transactionDate
     *            cannot be null or past date
     * @return transactionId not null
     */
    public String add(BigDecimal amount, String account, Date transactionDate);

    /**
     * Cash withdrawal from the given account.
     * 
     * @param amount
     *            cannot be null or negative
     * @param account
     *            cannot be null, 10 chars length
     * @param transactionDate
     *            cannot be null or past date
     * @return transactionId not null
     */
    public String withdraw(BigDecimal amount, String account,
	    Date transactionDate);

    /**
     * Transfer the given money from accountFrom to accountTo
     * 
     * @param amount
     *            cannot be null or negative
     * @param accountFrom
     *            cannot be null, 10 chars length
     * @param accountTo
     *            cannot be null, 10 chars length
     * @param transactionDate
     *            cannot be null or past date
     * @return transactionId not null
     */
    public String transfer(BigDecimal amount, String accountFrom,
	    String accountTo, Date transactioDate);

}
