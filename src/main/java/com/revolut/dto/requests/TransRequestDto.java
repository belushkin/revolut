package com.revolut.dto.requests;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TransRequestDto {
    private final Integer fromAccount;
	private final Integer toAccount;
	private volatile BigDecimal amount;

    private TransRequestDto(Builder builder) {
		this.fromAccount = builder.fromAccount;
		this.toAccount = builder.toAccount;
		this.amount = builder.amount;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	public static class Builder {
		private Integer fromAccount;
		private Integer toAccount;
		private volatile BigDecimal amount;

		private Builder() {

		}

		/**
		 * @param fromAccount
		 * @return
		 */
		public Builder withFromAccount(Integer fromAccount) {
			this.fromAccount = fromAccount;
			return this;
		}

		/**
		 * @param toAccount
		 * @return
		 */
		public Builder withToAccount(Integer toAccount) {
			this.toAccount = toAccount;
			return this;
		}

		/**
		 * @param amount
		 * @return
		 */
		public Builder withAmount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public TransRequestDto build() {
			return new TransRequestDto(this);
		}
	}
}
