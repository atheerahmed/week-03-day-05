package com.example.banksystem.advice;

import com.example.banksystem.DTO.Api;
import com.example.banksystem.exception.CustomerFoundsException;
import com.example.banksystem.exception.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

    @RestControllerAdvice
    public class ControllerAdviseHandler {
        Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);

        @ExceptionHandler(value = CustomerFoundsException.class)
        public ResponseEntity<Api> handleCustomerFounds(CustomerFoundsException customerFoundsException){
            logger.error("error of CustomerFounds ");

            String message=customerFoundsException.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
        }


        @ExceptionHandler(value = InvalidIdException.class)
        public ResponseEntity<Api> handleInvalidId(InvalidIdException invalidIDException){
            logger.error("error of InvalidId ");
            String message=invalidIDException.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api(message,400));
        }

        @ExceptionHandler(value = Exception.class)
        public ResponseEntity<Api> handleException(Exception exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api("SERVER ERROR !",500));
        }
    }
