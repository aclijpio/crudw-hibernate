package ru.pio.aclij.services.service;

import jakarta.persistence.criteria.CriteriaQuery;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.pio.aclij.exceptions.ModelRemoveException;
import ru.pio.aclij.exceptions.ModelSaveException;
import ru.pio.aclij.models.Model;

import java.util.List;

public abstract class ModelService<T extends Model> {
    protected Session session;

    public ModelService(Session session) {
        this.session = session;
    }

    public void save(@NonNull T model) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(model);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new ModelSaveException("Failed to save the model.", e);
        }
    }

    public void remove(@NonNull T model) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(model);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new ModelRemoveException("Failed to remove the model.", e);
        }
    }

    public T findModel(Class<T> modelClass, int id) {
        return session.get(modelClass, id);
    }
    public List<T> findAll(Class<T> modelClass){
        CriteriaQuery<T> cq = session
                .getCriteriaBuilder()
                .createQuery(modelClass);
        return session.createQuery(
                cq.select(cq.from(modelClass))
            ).getResultList();
    }

}