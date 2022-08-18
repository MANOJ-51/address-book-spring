package com.bridgelabz.addressbookspring.exception.handler;

import com.bridgelabz.addressbookspring.exception.ContactNotFoundException;
import com.bridgelabz.addressbookspring.exception.ContactValidation;
import com.bridgelabz.addressbookspring.util.ContactResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactExceptionHandler {
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ContactResponse> handleHiringException (ContactNotFoundException exception){
        ContactResponse response =new ContactResponse();
        response.setErrorCode(400);
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ContactValidation> handleValidationException(MethodArgumentNotValidException exception){
        ContactValidation contactValidation = new ContactValidation();
        contactValidation.setErrorCode(400);
        contactValidation.setMessage(exception.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(contactValidation,HttpStatus.BAD_REQUEST);
    }
}
