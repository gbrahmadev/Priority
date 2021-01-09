package com.tatsam.service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS_RATING",schema = "priority")
public class UserRatingEntity {



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "priority_id")
    private PriorityEntity priorityEntity;

    private int rating;

    public UserRatingEntity(UserEntity userEntity, PriorityEntity priorityEntity, int rating) {
        this.userEntity = userEntity;
        this.priorityEntity = priorityEntity;
        this.rating = rating;
    }
}
