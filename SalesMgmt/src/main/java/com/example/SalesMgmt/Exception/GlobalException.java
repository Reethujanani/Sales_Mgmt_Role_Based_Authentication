package com.example.SalesMgmt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception(BadRequestException exception ){
        return new ResponseEntity<>( "Bad Request", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> exception(NotFoundException exception){
        return new ResponseEntity<>( "Not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = UnAuthException.class)
    public ResponseEntity<Object> exception(UnAuthException exception){
        return new ResponseEntity<>(  "Un Auth", HttpStatus.UNAUTHORIZED);
    }
}

