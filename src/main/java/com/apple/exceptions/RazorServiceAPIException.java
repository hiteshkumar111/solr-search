package com.apple.exceptions;

public class RazorServiceAPIException extends ClientException {

	private static final long serialVersionUID = 1L;

	public RazorServiceAPIException(ErrorCode errorCode, Object... args) {
		super(errorCode, args);
	}

	public RazorServiceAPIException(ErrorCode errorCode, Throwable underlyingException, Object... args) {
		super(errorCode, underlyingException, args);
	}

}
