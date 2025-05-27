package com.example.SBUdemy.DAO;

import com.example.SBUdemy.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public Student findById(Integer theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        //
        TypedQuery<Student> query = entityManager.createQuery("From Student", Student.class);

        //
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student Where lastName=:theData", Student.class);
        query.setParameter("theData", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    };

}
