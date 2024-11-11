package com.revolut.dagger2.modules;

import javax.inject.Singleton;

import com.revolut.dao.account.AccountDao;
import com.revolut.dao.account.Impl.AccountDaoImpl;
import com.revolut.service.account.AccountService;
import com.revolut.service.account.Impl.AccountServiceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AccountServiceModule {
	/**
	 * @return {@link AccountDaoImpl}
	 */
	@Provides
	public AccountDao getAccountDao() {
		return AccountDaoImpl.getInstance();
	}

	/**
	 * @return {@link AccountServiceImpl}
	 */
	@Provides
	@Singleton
	public AccountService getAccountService() {
		return new AccountServiceImpl(getAccountDao());
	}
}
