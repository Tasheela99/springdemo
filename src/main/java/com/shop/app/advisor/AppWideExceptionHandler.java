package com.shop.app.advisor;

import com.shop.app.exception.NotFoundException;
import com.shop.app.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException message) {
        return new ResponseEntity<>(
                new StandardResponse(
                        404, "Error", message.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
