package com.revolut.dto.requests;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WithdrawRequestDto {
private final Integer accountId;
	private volatile BigDecimal amount;
	
	
	private WithdrawRequestDto(Builder builder) {
		this.accountId = builder.accountId;
		this.amount = builder.amount;
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer accountId;
		private volatile BigDecimal amount;

		private Builder() {

		}

		public Builder withAmount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder withAccountId(Integer accountId) {
			this.accountId = accountId;
			return this;
		}

		public WithdrawRequestDto build() {
			return new WithdrawRequestDto(this);
		}
	}
}
