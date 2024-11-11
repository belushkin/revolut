package com.revolut.dao.account;

import java.util.Collection;

import com.revolut.exception.DataNotFoundException;
import com.revolut.models.AccountModel;

public interface AccountDao {

    // Get-all account from DB
	Collection<AccountModel> getAll();

	// Get account by id from DB
	AccountModel getById(Integer id);

	// Create new account and returned newly created account
	AccountModel createAccount(AccountModel account);

	// Update account and return updated account
	void updateAccounts(AccountModel... accounts);

	// Check is account exists by id
	boolean exists(Integer id) throws DataNotFoundException;

	// Delete account by id
	AccountModel delete(Integer id) throws DataNotFoundException;

	// Withdraw amount from account
	WithdrawResponseDto withDraw(WithdrawRequestDto withdrawRequestDto)
			throws DataNotFoundException, InvalidAmountException;

	// // Deposit amount from account
	// DepositResponse deposit(DepositRequest depositRequest)
	// 		throws DataNotFoundException, InvalidAmountException;

	// // get balance against account id
	// BigDecimal balance(String id) throws DataNotFoundException;
}
