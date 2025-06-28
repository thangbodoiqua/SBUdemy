package com.example.SBUdemy.DAO;

import com.example.SBUdemy.entity.Course;
import com.example.SBUdemy.entity.Instructor;
import com.example.SBUdemy.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class AppDAOImpl implements AppDAO{


    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        Instructor theInstructor = entityManager.find(Instructor.class, theId);
        List<Course> courses = theInstructor.getCourses();
        for (Course tempCourse: courses) {
            tempCourse.setInstructor(null);
        }

        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        theInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(theInstructorDetail);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses= query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        /*TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        +  "JOIN FETCH i.courses "
                        + "where i.id = :data", Instructor.class
        );*/
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        +  "JOIN FETCH i.courses "
                        +  "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class
        );
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }
    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {

        return entityManager.find(Course.class, theId);
    }

}
