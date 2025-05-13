package com.AiThinkers.jpaMappings.dao;

import com.AiThinkers.jpaMappings.Entity.Course;
import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;
import com.AiThinkers.jpaMappings.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        List<Course> courses =tempInstructor.getCourses();

        for(Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query= entityManager.createQuery("from Course where instructor.id = data",Course.class);
        query.setParameter("data",theId);

        List<Course> courses =query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId){

        //create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from instructor i"
                        +"JOIN FETCH i.courses"+
                        "where i.id = :data", Instructor.class);
        query.setParameter("data",theId);

        Instructor instructor =query.getSingleResult();

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
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class,theId);

        entityManager.remove(tempCourse);

    }
 //one to many uni
    @Override
    @Transactional
    public void save(Course theCourse) {

        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theid) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c"
                        +"JOIN FETCH c.review"+
                        "where c.id = :data", Course.class);
        query.setParameter("data",theid);

        Course course =query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c"
                        +"JOIN FETCH c.student"+
                        "where c.id = :data", Course.class);
        query.setParameter("data",theId);
        Course course =query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s"
                        +"JOIN FETCH s.Course"+
                        "where s.id = :data", Student.class);
        query.setParameter("data",theId);
        Student student =query.getSingleResult();

        return student;

    }

    @Override
    @Transactional
    public void update(Student tempstudent) {
        entityManager.merge(tempstudent);
    }


}
