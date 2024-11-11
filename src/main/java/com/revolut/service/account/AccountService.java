package com.revolut.service.account;

import com.revolut.dto.requests.AccountRequestDto;
import com.revolut.dto.requests.DepositRequest;
import com.revolut.dto.requests.WithdrawRequestDto;
import com.revolut.dto.responses.ResponseDto;

public interface AccountService {

    // Get-all account from DB
	ResponseDto getAll();

	// Get account by id from DB
	ResponseDto getById(String id) throws IllegalArgumentException;

	// Create new account and returned newly created user
	ResponseDto create(AccountRequestDto request);

	// Update account and return updated user
	ResponseDto update(AccountRequestDto request);

	// Check is account exists by id
	ResponseDto exists(String id);

	// Delete account by id
	ResponseDto delete(String id);

	// Withdraw amount from account
	ResponseDto withdraw(WithdrawRequestDto withdrawRequestDto);

	// Deposit amount from account
	ResponseDto deposit(DepositRequest deposit);
	
	// Get balance against account id
	ResponseDto balance(String id);
}
