package ru.pio.aclij.services.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.pio.aclij.exceptions.ModelRemoveException;
import ru.pio.aclij.exceptions.ModelSaveException;
import ru.pio.aclij.models.Model;

import java.util.HashMap;
import java.util.List;

public abstract class ModelService<T extends Model> {
    protected SessionFactory sessionFactory;

    public ModelService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(@NonNull T model) {
        Transaction transaction = null;
        Session session = openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(model);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
            throw new ModelSaveException("Failed to save the model.", e);
        }
    }

    public void remove(@NonNull T model) {
        Transaction transaction = null;
        Session session = openSession();
        try {
            transaction = session.beginTransaction();
            session.remove(model);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
            throw new ModelRemoveException("Failed to remove the model.", e);

        }
    }
    public T findModel(Class<T> modelClass, int id) {
        Session session = sessionFactory.openSession();
        return session.get(modelClass, id);
    }
    public List<T> findAll(Class<T>  modelClass){
        Session session = openSession();
        CriteriaQuery<T> cq = session
                .getCriteriaBuilder()
                .createQuery(modelClass);
        return session.createQuery(
                cq.select(cq.from(modelClass))
            ).getResultList();
    }
    public List<T> findAllFromColumn(Class<T> modelClass, String column, String target){
        Session session = openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(modelClass);

        Root<T> root = cq.from(modelClass);
        cq.select(root);
        cq.where(cb.equal(root.get(column), target));
        return session.createQuery(cq).getResultList();
    }

    protected Session openSession(){
        return sessionFactory.getCurrentSession();
    }
    protected void rollbackTransaction(Transaction transaction){
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }

}