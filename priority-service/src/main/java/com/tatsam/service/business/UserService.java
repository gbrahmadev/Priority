package com.tatsam.service.business;

import com.tatsam.service.dao.UserDao;
import com.tatsam.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity addUser(final UserEntity userEntity) {

        if (userDao.getUserByUsername(userEntity.getUserName()) != null) {
            throw new Error(
                    "userName Already Exists", null);
        } else {
            return userDao.createUser(userEntity);
        }
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity getUserById(final String id) {
        return userDao.getUserById(id);
    }


}
