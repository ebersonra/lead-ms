package br.com.leads.ms.domain.handler;

import br.com.leads.ms.domain.exception.LeadException;
import br.com.leads.ms.domain.response.MessageErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

@ControllerAdvice
public class LeadCommonExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(LeadCommonExceptionHandler.class);

    @ExceptionHandler(LeadException.class)
    public ResponseEntity<MessageErrorResponse> handleLeadException(LeadException exception) {
        return getErrorMessage(exception, getHttpStatus(exception));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return getErrorMessage(exception, getHttpStatus(exception));
    }

    private static HttpStatus getHttpStatus(Exception exception) {

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(exception instanceof LeadException leadException) {
            httpStatus = leadException.getErrorCode();
        }else if(exception instanceof BindException) {
            httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        }

        return httpStatus;
    }

    private ResponseEntity<MessageErrorResponse> getErrorMessage(Exception exception, HttpStatus httpStatus) {

        String messageError = "Internal Server Error";

        if(exception instanceof LeadException leadException) {
            messageError = leadException.getMessage();
        }else if(exception instanceof BindException bindException) {
            messageError = extractErrorMessages(bindException);
        }

        return new ResponseEntity<>(new MessageErrorResponse(List.of(messageError), httpStatus.value()), httpStatus);
    }

    private String extractErrorMessages(BindException exception) {
        return exception.getBindingResult().getAllErrors().stream()
                .map(this::buildMessageError)
                .collect(Collectors.joining(", "));
    }

    private String buildMessageError(ObjectError objectError) {

        if (objectError instanceof FieldError fieldError) {
            LOG.error("### The field {} {} ###", fieldError.getField(), fieldError.getDefaultMessage());
        }
        return "The field ".concat(defaultIfEmpty(objectError.getDefaultMessage(),"is invalid"));
    }
}
