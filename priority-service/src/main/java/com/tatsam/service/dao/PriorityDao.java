package com.tatsam.service.dao;

import com.tatsam.service.entity.PriorityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PriorityDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<PriorityEntity> getAllPriorities(){
        try {
            return entityManager.createNamedQuery("listOfAllPriorities", PriorityEntity.class)
                    .getResultList();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public PriorityEntity getPriorityFromPriorityName (final String priorityName) {
        try {
            return entityManager.createNamedQuery("priorityByPriorityName", PriorityEntity.class)
                    .setParameter("priorityName", priorityName).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public PriorityEntity getPriorityFromId (final String id) {
        try {
            return entityManager.createNamedQuery("priorityById", PriorityEntity.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
    }

    public PriorityEntity addNewPriority(final PriorityEntity priorityEntity) {
        try {
            entityManager.persist(priorityEntity);
        } catch (Exception e) {
            throw new Error("DB-001 : something's wrong with DB.", null);
        }
        return priorityEntity;
    }

    public void deletePriority(final PriorityEntity priorityEntity){
        entityManager.remove(priorityEntity);
    }

    public PriorityEntity updatePriorityName(final PriorityEntity priorityEntity) {
        PriorityEntity updatedPriority = entityManager.merge(priorityEntity);
        return updatedPriority;
    }

}
