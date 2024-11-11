package com.revolut.dto.requests;

import com.revolut.models.AccountModel;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AccountRequestDto {

    private AccountModel account;

    /**
	 * @param builder
	 */
	private AccountRequestDto(Builder builder) {
		this.account = builder.account;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private AccountModel account;

		private Builder() {

		}

		/**
		 * @param account
		 * @return
		 */
		public Builder withAccount(AccountModel account) {
			this.account = account;
			return this;
		}

		public AccountRequestDto build() {
			return new AccountRequestDto(this);
		}

	}
}
