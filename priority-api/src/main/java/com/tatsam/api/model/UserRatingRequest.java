package com.tatsam.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRatingRequest {
    private String userId;
    private String priorityId;
    private int rating;

}
