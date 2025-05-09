package com.AiThinkers.jpaMappings.dao;

import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    //define Entity Managaer
    private EntityManager entityManager;
    //inject entity manager in to constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId){
        //retrive the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        //remove or delete the instructor
        entityManager.remove(tempInstructor);
    }
    //using bidirectional
    @Override
    public InstructorDetails findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetails.class,theId);
    }
    //using bidirectional
    @Override
    @Transactional
    public void deleteInstructorDetailsById(int theId) {

        InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class,theId);

        entityManager.remove(tempInstructorDetails);
    }
}
