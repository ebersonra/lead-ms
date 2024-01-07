package br.com.leads.ms.domain.handler;

import br.com.leads.ms.domain.exception.LeadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LeadCommonExceptionHandler {

    @ExceptionHandler(LeadException.class)
    public ResponseEntity<Object> handleLeadException(LeadException exception) {
        return getErrorMessage(exception, getHttpStatus(exception));
    }

    private static HttpStatus getHttpStatus(Exception exception) {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(exception instanceof LeadException leadException) {
            httpStatus = leadException.getErrorCode();
        }

        return httpStatus;
    }

    private ResponseEntity<Object> getErrorMessage(Exception exception, HttpStatus httpStatus) {
        String messageError = "Internal Server Error";

        if(exception instanceof LeadException leadException) {
            messageError = leadException.getErrorMessage();
        }

        return new ResponseEntity<>(messageError, httpStatus);
    }
}
