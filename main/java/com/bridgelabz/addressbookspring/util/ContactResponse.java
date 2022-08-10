package com.bridgelabz.addressbookspring.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactResponse {
    private int errorCode;
    private String message;
    private Object token;
    public ContactResponse() {
    }
}
