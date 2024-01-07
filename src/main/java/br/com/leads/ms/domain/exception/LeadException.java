package br.com.leads.ms.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class LeadException extends LeadCommonException {

    public LeadException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getErrorCode() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }

    @Override
    public String getErrorMessage() {
        return getMessage();
    }
}
