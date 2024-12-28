package com.sst.sst_exceptions;

public class HttpRequestException extends RuntimeException {

	private static final long serialVersionUID = 6552519769132245599L;

	public HttpRequestException(String message) {
		super(message);
	}

}
