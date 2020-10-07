package repository.base;

import repository.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<Entity, ID extends Number> {
    protected abstract Class<Entity> getEntityClass();

    EntityManager entityManager = JPAUtil.getEntityManager();

    public Entity insert(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return entity;
    }

    public List<Entity> findAll() {
        List<Entity> entityList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Entity> query = entityManager.createQuery("select entity from " + getEntityClass().getName() + " entity", getEntityClass());
            entityList = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return entityList;
    }

    public Entity findByID(ID id) {
        Entity entity = null;
        try {
            entityManager.getTransaction().begin();
            entity = entityManager.find(getEntityClass(), id);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return entity;
    }

    public Entity update(Entity entity) {
        Entity merge = null;
        try {
            entityManager.getTransaction().begin();
            merge = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }
        return merge;
    }

    public void delete(Entity entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            System.out.println(exception.getMessage());
        }

    }

    public void deleteByID(ID id) throws Exception {
        Entity entity = findByID(id);
        if (entity == null) {
            throw new Exception("This Entity -> Class Name: " + getEntityClass().getName() + " \tAnd \tID: " + id + " Not Exist.");
        } else {
            delete(entity);
        }
    }
}
