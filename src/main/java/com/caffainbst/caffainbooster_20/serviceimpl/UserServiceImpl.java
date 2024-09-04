package com.caffainbst.caffainbooster_20.serviceimpl;

import com.caffainbst.caffainbooster_20.POJO.User;
import com.caffainbst.caffainbooster_20.constents.CaffainboosterConstants;
import com.caffainbst.caffainbooster_20.dao.UserDao;
import com.caffainbst.caffainbooster_20.service.UserService;
import com.caffainbst.caffainbooster_20.utils.CaffainboosterUtilz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        log.info("inside signup{}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return CaffainboosterUtilz.getResponseEntity("Sucessfully Registered", HttpStatus.OK);
                } else {
                    return CaffainboosterUtilz.getResponseEntity("Email already exist.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return CaffainboosterUtilz.getResponseEntity(CaffainboosterConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
    }
        return CaffainboosterUtilz.getResponseEntity(CaffainboosterConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String,String>requestMap){
        if(requestMap.containsKey("name")&& requestMap.containsKey("contactNumber") && requestMap.containsKey("email")&&requestMap.containsKey("password"))
        {
            return true;
        }
        return false;
    }

    private User getUserFromMap(Map<String,String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;
    }
}
