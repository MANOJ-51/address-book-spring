package com.bridgelabz.addressbookspring.exception.handler;

import com.bridgelabz.addressbookspring.exception.ContactNotFoundException;
import com.bridgelabz.addressbookspring.util.ContactResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactExceptionHandler {
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ContactResponse> handleHiringException (ContactNotFoundException he){
        ContactResponse response =new ContactResponse();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
