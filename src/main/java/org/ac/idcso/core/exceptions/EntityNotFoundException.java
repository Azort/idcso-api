package org.ac.idcso.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    /**
     * Seria version UID.
     */
    private static final long serialVersionUID = 1L;

    @Getter
    private final HttpStatus errorCode;

    /**
     * Constructor.
     *
     * @param message
     *            message of the exception.
     *
     * @param errorCode
     *            the error code.
     */
    public EntityNotFoundException(final String message, final HttpStatus errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
