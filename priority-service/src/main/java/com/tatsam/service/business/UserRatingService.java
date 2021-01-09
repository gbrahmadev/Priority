package com.tatsam.service.business;

import com.tatsam.service.dao.UserDao;
import com.tatsam.service.dao.UserRatingDao;
import com.tatsam.service.entity.PriorityEntity;
import com.tatsam.service.entity.UserEntity;
import com.tatsam.service.entity.UserRatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRatingService {
    @Autowired
    private UserRatingDao userRatingDao;
    @Autowired
    private UserService userService;
    @Autowired
    private PriorityService priorityService;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserRatingEntity addUserRating(final String userId, final String priorityId,
                                    final int rating) {

        UserEntity userEntity = userService.getUserById(userId);
        PriorityEntity priorityEntity = priorityService.getPriorityById(priorityId);

        UserRatingEntity userRatingEntity = new UserRatingEntity(userEntity,priorityEntity,rating);

        return userRatingDao.addUserRating(userRatingEntity);
    }


}
