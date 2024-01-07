package br.com.leads.ms.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class LeadCommonException extends RuntimeException {

    protected LeadCommonException(String message) {
        super(message);
    }

    protected LeadCommonException(List<String> messages) {
        super(String.join(", ", messages));
    }

    protected abstract HttpStatus getErrorCode();

    protected abstract String getErrorMessage();
}
