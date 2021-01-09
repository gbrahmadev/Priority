package com.tatsam.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS",schema = "priority")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_NAME")
    @Size(max = 255)
    private String userName;

    @Column(name ="IS_ADMIN")
    private boolean isAdmin =false;

    @OneToMany(mappedBy = "USERS")
    private List<UserRatingEntity> userRatingEntities;

    public UserEntity(@Size(max = 255) String userName, List<UserRatingEntity> userRatingEntities) {
        this.userName = userName;
        for (UserRatingEntity ure : userRatingEntities) {
            this.userRatingEntities.add(ure);
        }
    }
}
