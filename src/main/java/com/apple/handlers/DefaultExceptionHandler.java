package com.apple.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apple.exceptions.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles all exceptions. This class catch all exception thrown by controller and convert error
 * message into json format
 */
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {


    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
        apiErrorResponse.setTimestamp(new Date());
        Map<String,String > error = new HashMap<>();
        error.put("message",ex.getMessage());
        apiErrorResponse.setError(error);
        log.error("Message" + ex.getMessage(),ex);
        return new ResponseEntity<Object>(apiErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = createError(ex);
        log.error("Message" + ex.getMessage(),ex);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = {InvalidRequestException.class})
    protected ResponseEntity<ApiErrorResponse> handleInvalidRequestException(InvalidRequestException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = createError(ex);
        log.error("Message" + ex.getMessage(),ex);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {ClientException.class})
    protected ResponseEntity<ApiErrorResponse> handleClientException(ClientException ex, WebRequest request) {
        ApiErrorResponse apiErrorResponse = createError(ex);
        log.error("Message" + ex.getMessage(),ex);
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }


    private ApiErrorResponse createError(ClientException e) {
        ApiErrorResponse error = new ApiErrorResponse();
        StringBuffer message = new StringBuffer();
        if (null != e.getMessage()) {
            message.append(e.getMessage());
        }
        if (null != e.getErrorCode()) {
            message.append(e.getErrorCode().getMessage());
        }
        if (null != e.getMessagePositionalArgs()) {
            for (Object object : e.getMessagePositionalArgs()) {
                message.append(" ");
                message.append(object);
            }
        }
        Map<String,String> errorObject = new HashMap<>();
        errorObject.put("subErrorCode",e.getErrorCode().getSubErrorCode()+"");
        errorObject.put("message",message.toString());
        error.setError(errorObject);
        error.setTimestamp(new Date());
        return error;
    }
}
