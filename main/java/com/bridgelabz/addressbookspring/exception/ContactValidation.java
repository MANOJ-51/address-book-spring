package com.bridgelabz.addressbookspring.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactValidation {
    private int errorCode;
    private String message;

    public ContactValidation() {
    }
}
