package com.AiThinkers.jpaMappings.dao;

import com.AiThinkers.jpaMappings.Entity.Course;
import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;
import com.AiThinkers.jpaMappings.Entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

   public  Instructor findInstructorById(int theId);

   void deleteInstructorById(int theId);


    //using bidirectional
   InstructorDetails findInstructorDetailById(int theId);

   void deleteInstructorDetailsById(int theId);

   List<Course> findCoursesByInstructorId(int theId);

   Instructor findInstructorByIdJoinFetch(int theId);

   void update(Instructor tempInstructor);

   void update(Course tempCourse);

   Course findCourseById(int theId);

   void deleteCourseById(int theId);

   //one to many uni directional
   void save(Course theCourse);

   Course findCourseAndReviewsByCourseId(int theid);

   Course findCourseAndStudentByCourseId(int theId);

   Student findStudentAndCoursesByStudentId(int theId);

   void update(Student tempstudent);
}
