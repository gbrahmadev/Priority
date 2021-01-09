package com.tatsam.service.business;

import com.tatsam.service.dao.PriorityDao;
import com.tatsam.service.dao.UserDao;
import com.tatsam.service.entity.PriorityEntity;
import com.tatsam.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PriorityService {

    @Autowired
    private PriorityDao priorityDao;
    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public PriorityEntity createPriority(final PriorityEntity priorityEntity, final UserEntity userEntity) {

        //check whether the user is admin or not
        if(!userEntity.isAdmin()){
            throw new Error(
                    "userName is not Admin", null);
        }
        if (priorityDao.getPriorityFromPriorityName(priorityEntity.getPriorityName()) != null) {
            throw new Error(
                    "userName is already present", null);
        } else {
            return priorityDao.addNewPriority(priorityEntity);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<PriorityEntity> getAllPriorities() {
        return priorityDao.getAllPriorities();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PriorityEntity getPriorityById(final String id) {
        return priorityDao.getPriorityFromId(id);
    }



}
