package com.tatsam.service.dao;

import com.tatsam.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity getUserById(final String id){
        try {
            return entityManager.createNamedQuery("userById", UserEntity.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public UserEntity getUserByUsername(final String userName){
        try {
            return entityManager.createNamedQuery("userById", UserEntity.class)
                    .setParameter("userName", userName).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public UserEntity createUser(final UserEntity userEntity) {
        try {
            entityManager.persist(userEntity);
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
        return userEntity;
    }


}
