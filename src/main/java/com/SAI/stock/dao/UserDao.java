package com.SAI.stock.dao;

import com.SAI.stock.dtoModules.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User getUserByPhone(Query query) {
        return mongoTemplate.findOne(query, User.class);

    }

    public User saveUser(User user) {
        return mongoTemplate.save(user, "users");
    }

    public UpdateResult updateUser(Query query, UpdateDefinition user) {
      return mongoTemplate.updateFirst(query,user,"users");
    }

    public List getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

}
