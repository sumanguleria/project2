package com.web.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

//@Component
public class BaseDomain {
@Transient
 public String  errorCode,errorMessage;

public String getErrorCode() {
	return errorCode;
}

public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

}
