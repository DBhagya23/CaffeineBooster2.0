package com.caffainbst.caffainbooster_20.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CaffainboosterUtilz {

    private CaffainboosterUtilz(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
