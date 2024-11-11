package com.revolut.account.service;

import java.util.Collection;

import com.revolut.account.domain.Account;
import com.revolut.account.domain.TransferDetails;
import com.revolut.account.exceptions.AccountNotFoundException;
import com.revolut.account.exceptions.InsufficientAmountException;

public interface AccountService {

    Collection<Account> getAccounts();

    Account getAccount(int id) throws AccountNotFoundException, AccountNotFoundException;

    Account createAccount(Account account);

    TransferDetails transfer(TransferDetails transferDetails) throws InsufficientAmountException, AccountNotFoundException;

}
