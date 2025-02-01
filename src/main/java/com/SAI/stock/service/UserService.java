package com.SAI.stock.service;

import com.SAI.stock.commonUtil.CommonUtil;
import com.SAI.stock.dao.UserDao;
import com.SAI.stock.dtoModules.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public ResponseEntity createUser(User user) {
        Query query=Query.query(Criteria.where("phoneNo").is(user.getPhoneNo()));
        User getUser=userDao.getUserByPhone(query);
        if (Objects.nonNull(getUser)) {
            return new ResponseEntity<>(CommonUtil.createResponse(HttpStatus.BAD_REQUEST.value(),"User already exists with this phone no",HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
        user.setId("USER_"+ UUID.randomUUID());
        user.createEntity(user.getId(),user.getId());
        return new ResponseEntity<>(CommonUtil.createResponse(HttpStatus.CREATED.value(),"User created successfully",userDao.saveUser(user)), HttpStatus.CREATED);
    }

    public ResponseEntity updateUser(User user) {
        Query query=Query.query(Criteria.where("_id").is(user.getId()));
        Update update=Update.update("name",user.getName());
        long count= userDao.updateUser(query,update).getModifiedCount();
        if(count>0){
            return new ResponseEntity<>(CommonUtil.createResponse(HttpStatus.OK.value(), "User updated successfully",count),HttpStatus.OK);
        }
        return new ResponseEntity<>(CommonUtil.createResponse(HttpStatus.OK.value(), "User not found to update",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(CommonUtil.createResponse(HttpStatus.OK.value(), "data found",userDao.getAllUsers()),HttpStatus.OK);
    }
}
