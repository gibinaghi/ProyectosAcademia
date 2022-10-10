package com.ayi.curso.rest.serv.ayispringrestful.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<ErrorKeyMessage> handleNotFoundException(
            Exception ex, WebRequest request) {
        ErrorKeyMessage errorMessage =
                new ErrorKeyMessage(
                        String.valueOf(
                                HttpStatus.NOT_FOUND.value()), ex.getMessage()
                );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler({InternalException.class})
    public final ResponseEntity<ErrorKeyMessage> handleInternalException(
            Exception ex, WebRequest request) {
        ErrorKeyMessage errorMessage =
                new ErrorKeyMessage(
                        String.valueOf(
                                HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage()
                );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler({BadRequestException.class})
    public final ResponseEntity<ErrorKeyMessage> handleBadRequestException(
            Exception ex, WebRequest request) {
        ErrorKeyMessage errorMessage =
                new ErrorKeyMessage(
                        String.valueOf(
                                HttpStatus.BAD_REQUEST.value()), ex.getMessage()
                );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
