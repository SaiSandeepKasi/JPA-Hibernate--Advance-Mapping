package com.AiThinkers.jpaMappings.dao;

import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;

public interface AppDAO {
    void save(Instructor theInstructor);

   public  Instructor findInstructorById(int theId);

   void deleteInstructorById(int theId);


    //using bidirectional
   InstructorDetails findInstructorDetailById(int theId);

   void deleteInstructorDetailsById(int theId);
}
