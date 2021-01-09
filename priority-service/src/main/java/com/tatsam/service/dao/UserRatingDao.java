package com.tatsam.service.dao;

import com.tatsam.service.entity.PriorityEntity;
import com.tatsam.service.entity.UserEntity;
import com.tatsam.service.entity.UserRatingEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRatingDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRatingEntity addUserRating(final UserRatingEntity userRatingEntity){
        try {
            entityManager.persist(userRatingEntity);
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
        return userRatingEntity;
    }

    public UserRatingEntity UpdateUserRating(final UserRatingEntity userRatingEntity){
        try {
            entityManager.merge(userRatingEntity);
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
        return userRatingEntity;
    }

    public void deleteUserRating(final UserRatingEntity userRatingEntity){
        try {
            entityManager.remove(userRatingEntity);
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public List<UserRatingEntity> getAllUsersFromPriority (final PriorityEntity priorityEntity){
        try {
            return entityManager.createNamedQuery("allPrioritiesFromUser", UserRatingEntity.class)
                    .setParameter("userId", priorityEntity.getId()).getResultList();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public List<UserRatingEntity> getAllPrioritiesFromUser (final UserEntity userEntity){
        try {
            return entityManager.createNamedQuery("allPrioritiesFromUser", UserRatingEntity.class)
                    .setParameter("userId", userEntity.getId()).getResultList();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }



}
