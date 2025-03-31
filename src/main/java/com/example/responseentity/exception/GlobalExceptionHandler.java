package com.example.responseentity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ProblemDetail> handle(final ProductNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        exception.getMessage())
        );
    }

    @ExceptionHandler(value = InsufficientStockException.class)
    public ResponseEntity<ProblemDetail> handle(final InsufficientStockException exception) {
        return ResponseEntity.badRequest().body(
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        exception.getMessage()
                )
        );
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handle(final IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        exception.getMessage()
                )
        );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ProblemDetail> handle(final Exception exception) {
        return ResponseEntity.badRequest().body(
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        exception.getMessage()
                )
        );
    }
}
