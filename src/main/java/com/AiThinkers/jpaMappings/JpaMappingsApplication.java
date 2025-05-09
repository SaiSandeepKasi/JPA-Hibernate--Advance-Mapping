package com.AiThinkers.jpaMappings;

import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;
import com.AiThinkers.jpaMappings.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaMappingsApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner ->{
	        //createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
/*
			//using bidirectional

 */
			//findInstructorDetails(appDAO);
			//deleteInstructorDetails(appDAO);

		};
		}


	private void deleteInstructorDetails(AppDAO appDAO){
		int theId=1;

		System.out.println("Deleting instructor id:"+ theId);

		appDAO.deleteInstructorDetailsById(theId);

		System.out.println("Done !");
	}

		private void findInstructorDetails(AppDAO appDAO){
		int theId=1;
			System.out.println("Finding instructor id : "+ theId);

			InstructorDetails tempInstructorDetails = appDAO.findInstructorDetailById(theId);

			System.out.println("tempInstructor" + tempInstructorDetails);
			System.out.println("the associated instructorDetail only :"+ tempInstructorDetails.getInstructor());



		}


		private void deleteInstructor(AppDAO appDAO){
		int theId=1;

		System.out.println("Deleting instructor id:"+ theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done !");
		}



		private void findInstructor(AppDAO appDAO){

		int theId=1;
		System.out.println("Finding instructor id : "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated instructorDetail only :"+ tempInstructor.getInstructorDetails());
		}


	private void createInstructor(AppDAO appDAO) {

		//create the instructor
		Instructor tempInstructor=
				new  Instructor("chad","Darby","darby@gmail.com");
		//create the instructordetails
		InstructorDetails tempInstructorDetails =
				new InstructorDetails(
						"http;//www/hellonamaste.com/youtube",
						"Programming !!");

		//associate the objects
		tempInstructor.setInstructorDetails(tempInstructorDetails);

		//save the instructor
		//NOTE:this will also save the  instructor_Details object also
		//because we use cascadeType.All
		System.out.println("saving instructor"+ tempInstructor);
		appDAO.save(tempInstructor);
	}


}
