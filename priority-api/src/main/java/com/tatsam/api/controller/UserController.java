package com.tatsam.api.controller;

import com.tatsam.api.model.UserRatingRequest;
import com.tatsam.service.business.PriorityService;
import com.tatsam.service.business.UserRatingService;
import com.tatsam.service.business.UserService;
import com.tatsam.service.dao.UserRatingDao;
import com.tatsam.service.entity.PriorityEntity;
import com.tatsam.service.entity.UserEntity;
import com.tatsam.service.entity.UserRatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PriorityService priorityService;
    @Autowired
    private UserRatingService userRatingService;



    @RequestMapping(method = RequestMethod.POST,path = "/{id}",
            produces = "application/json;charset=UTF-8",consumes = "application/json;charset=UTF-8")
    public ResponseEntity<String> setUserRating(@PathVariable("id") final String id,
                                                @RequestBody final List<UserRatingRequest> userRatingRequests) {

        UserEntity userEntity = userService.getUserById(id);
        boolean flag = true;
        for (UserRatingRequest ure: userRatingRequests
        ) {
            if(ure.getUserId() != userEntity.getId()){
                flag = false;
                break;
            }
        }




        if(flag){
            userRatingRequests.forEach((indvRating)->{
                userRatingService.addUserRating(indvRating.getUserId(),indvRating.getPriorityId(),
                        indvRating.getRating());
            });
            return new ResponseEntity<>("User ratings have been saved successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something wrong in the provided data",
                    HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
