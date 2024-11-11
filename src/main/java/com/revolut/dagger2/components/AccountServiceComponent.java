package com.revolut.dagger2.components;

import javax.inject.Singleton;

import com.revolut.dagger2.modules.AccountServiceModule;

import dagger.Component;

@Singleton
@Component(modules = AccountServiceModule.class)
public class AccountServiceComponent {

    	/**
	 * @return {@link AccountServiceImpl}
	 */
	AccountServiceImpl buildAccountServiceImpl();
}
