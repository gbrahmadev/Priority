package com.tatsam.api.controller;

import com.tatsam.api.model.PriorityArea;
import com.tatsam.api.model.PriorityRequest;
import com.tatsam.service.business.PriorityService;
import com.tatsam.service.entity.PriorityEntity;
import com.tatsam.service.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/priorityAreas")
public class PriorityController {

    @Autowired
    private PriorityService  priorityService;

    @RequestMapping(method = RequestMethod.GET,path = "/",produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<PriorityArea>> getAllCategories(){
        List<PriorityArea> priorityAreas = null;
        priorityService.getAllPriorities();
        return new ResponseEntity<>(priorityAreas, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/",
            produces = "application/json;charset=UTF-8",consumes = "application/json;charset=UTF-8")
    public ResponseEntity<String> addPriorityArea(
            @RequestBody final PriorityRequest priorityRequest,
            @RequestHeader("user") UserEntity userEntity) {
        PriorityEntity priorityEntity = new PriorityEntity();
        priorityEntity.setPriorityName(priorityRequest.getPriorityName());

        priorityService.createPriority(priorityEntity,userEntity);
        return new ResponseEntity<>("New Priority added successfully",HttpStatus.OK);
    }

}
