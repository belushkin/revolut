package com.revolut;

import java.math.BigDecimal;

import com.revolut.account.domain.Account;

public class AccountsProvider {
  public final static Account ACCOUNT_1 = new Account(1, "John", BigDecimal.valueOf(100));
  public final static Account ACCOUNT_2 = new Account(2, "Steve", BigDecimal.valueOf(200));
}
