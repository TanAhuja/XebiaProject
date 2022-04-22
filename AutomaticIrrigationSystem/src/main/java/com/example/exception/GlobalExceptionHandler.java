/**
 * Filename    : GlobalExceptionHandler.java
 * Version     : 1.0.0
 * Create Date : 21 Apr 2022
 *
 * © Example
 */
package com.example.exception;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.models.ErrorResponse;
import com.example.utils.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * This method handles core exception
	 * 
	 * @param coreException
	 * @return
	 */
	@ExceptionHandler(value = CoreException.class)
	private ResponseEntity<ErrorResponse> handleCoreException(final CoreException coreException) {
		logger.debug("Handling core exception: {}", coreException);
		ErrorResponse baseResponse = new ErrorResponse();
		baseResponse.setErrorCode(coreException.getErrorCode());
		baseResponse.setErrorMessage(coreException.getErrorMessage());

		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if (Objects.nonNull(coreException.getHttpStatus())) {
			status = coreException.getHttpStatus();
		}
		return new ResponseEntity<ErrorResponse>(baseResponse, status);
	}

	/**
	 * This method handles unexpected exception
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	private ResponseEntity<ErrorResponse> handleException(final Exception exception) {
		logger.debug("Handling unexpected exception: {}", exception);
		ErrorResponse baseResponse = new ErrorResponse();
		baseResponse.setErrorCode(Constants.BASE_ERR_CODE);
		baseResponse.setErrorMessage(Constants.BASE_ERR_MSG);
		return new ResponseEntity<ErrorResponse>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
