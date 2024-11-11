package com.revolut.dto.responses;

import com.google.gson.JsonElement;
import com.revolut.dto.status.StatusType;
import com.revolut.utils.Helper;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResponseDto {

    private final StatusType statusType;
	private final JsonElement data;
	private final String message;

	/**
	 * @param builder
	 */
	private ResponseDto(final Builder builder) {
		this.statusType = builder.statusType;
		this.data = builder.data;
		this.message = builder.message;
	}

	/**
	 * @return
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder pattern for Response DTO class
	 * 
	 */
	@ToString
	public static class Builder {
		private StatusType statusType;
		private JsonElement data;
		private String message;

		private Builder() {

		}

		/**
		 * @param statusType
		 * @return
		 */
		public Builder withStatusType(StatusType statusType) {
			this.statusType = statusType;
			return this;
		}

		/**
		 * @param data
		 * @return
		 */
		public Builder withData(Object data) {
			this.data = Helper.GSON.toJsonTree(data);
			return this;
		}

		/**
		 * @param message
		 * @return
		 */
		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		/**
		 * @param format
		 * @param args
		 * @return
		 */
		public Builder withMessage(String format, Object... args) {
			this.message = String.format(format, args);
			return this;
		}

		/**
		 * @return
		 */
		public ResponseDto build() {
			return new ResponseDto(this);
		}

	}
}
