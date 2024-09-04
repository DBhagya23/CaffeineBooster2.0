package com.caffainbst.caffainbooster_20.restimpl;

import com.caffainbst.caffainbooster_20.constents.CaffainboosterConstants;
import com.caffainbst.caffainbooster_20.rest.UserRest;
import com.caffainbst.caffainbooster_20.service.UserService;
import com.caffainbst.caffainbooster_20.utils.CaffainboosterUtilz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
       try{
            return userService.signup(requestMap);
       }catch (Exception ex){
           ex.printStackTrace();
       }
        return CaffainboosterUtilz.getResponseEntity(CaffainboosterConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
