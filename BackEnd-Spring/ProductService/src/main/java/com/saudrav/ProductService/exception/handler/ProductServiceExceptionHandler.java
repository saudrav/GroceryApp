package com.saudrav.ProductService.exception.handler;

import com.saudrav.ProductService.exception.ProductNotFoundException;
import com.saudrav.ProductService.exception.ProductQuantityOverloadException;
import com.saudrav.ProductService.exception.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ProductServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProductQuantityOverloadException.class)
    public ResponseEntity<ErrorResponse> handleProductQuantityOverloadException(ProductQuantityOverloadException exp) {
        ErrorResponse erp = ErrorResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND)
                .errorMessage(exp.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(erp, HttpStatus.BAD_REQUEST);
    }

}
