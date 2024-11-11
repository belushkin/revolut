package com.revolut.dao.account.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.revolut.dao.account.AccountDao;
import com.revolut.dto.requests.WithdrawRequestDto;
import com.revolut.dto.responses.WithdrawResponseDto;
import com.revolut.exception.DataNotFoundException;
import com.revolut.models.AccountModel;


public class AccountDaoImpl extends BaseDaoImpl<AccountModel, Integer> implements AccountDao {

    public AccountDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, AccountModel.class);
        TableUtils.createTableIfNotExists(connectionSource, AccountModel.class);
  }

  @Override
  public Collection<AccountModel> getAll() {
    Collection<AccountModel> accounts = new ArrayList<>();
    super.forEach(accounts::add);
    return accounts;
  }

  @Override
  public AccountModel getById(Integer id) { // throws AccountNotFoundException
    try {
      AccountModel account = super.queryForId(id);
    //   if (account == null) {
    //     throw new AccountNotFoundException(String.format("Account with ID %s not found", id));
    //   }
      return account;
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }

  @Override
  public AccountModel createAccount(AccountModel account) {
    try {
      super.create(account);
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
    return account;
  }

  @Override
  public void updateAccounts(AccountModel... accounts) {
    TransactionManager tx = new TransactionManager(super.getConnectionSource());
    try {
      TransactionManager.callInTransaction("accounts", super.getConnectionSource(), () -> {
        for (AccountModel account: accounts) {
           super.update(account);
        }
        return tx;
      });
    } catch (SQLException e) {
      throw new RuntimeException(e.getCause());
    }
  }

  @Override
  public boolean exists(Integer id) {
    try {
        getById(id);
    } catch (RuntimeException e) {
      throw new DataNotFoundException();
    }
    return true;
  }

  @Override
  public AccountModel delete(Integer id) {
    try {
        AccountModel account = getById(id);
        super.delete(account);
        return account;
    } catch (RuntimeException | SQLException e) {
      throw new DataNotFoundException();
    }
  }

  @Override
  public WithdrawResponseDto withDraw(WithdrawRequestDto withdrawRequestDto) {
    // try {
    //     AccountModel account = getById(id);
    //     super.delete(account);
    //     return account;
    // } catch (RuntimeException | SQLException e) {
    //   throw new DataNotFoundException();
    // }
  }
}
