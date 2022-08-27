package com.infinity.exceptions;

import java.text.MessageFormat;

public class AccountIsAlreadyAssignedException extends RuntimeException{
	
	public AccountIsAlreadyAssignedException(final Integer accid, final Integer cid) {
		super(MessageFormat.format("Account: {0} is already assigned to Customer: {1}", accid,cid));
	}

}
