package com.AiThinkers.jpaMappings;

import com.AiThinkers.jpaMappings.Entity.Course;
import com.AiThinkers.jpaMappings.Entity.Instructor;
import com.AiThinkers.jpaMappings.Entity.InstructorDetails;
import com.AiThinkers.jpaMappings.Entity.Review;
import com.AiThinkers.jpaMappings.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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


			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourse(appDAO);

			//One to Many Uni-directional

			//createCourseAndReview(appDAO);
			//retriveCourseAndReviews(appDAO);
			deleteCourseAndReview(appDAO);

		};
		}

		private void deleteCourseAndReview(AppDAO appDAO){

			int theId=10;

			System.out.println("Deleting Course by id :"+theId);

			appDAO.deleteCourseById(theId);
			

		}

		private void retriveCourseAndReviews(AppDAO appDAO){

		//get the course and reviews
		int theId=10;

		Course tempCourse =appDAO.findCourseAndReviewsByCourseId(theId);

		//print course
        System.out.println(tempCourse);

		//print review

			System.out.println(tempCourse.getReview());
		}

		private void createCourseAndReview(AppDAO appDAO){
		//create course
			Course tempCourse=new Course("Java-Njoy !!");
			//add review
			tempCourse.addReview(new Review("Great Job ..it was good to learn"));
			tempCourse.addReview(new Review("It was okieshh to learn... the examples were not so efficient"));
			tempCourse.addReview(new Review("too badd ..."));

			//save review
            System.out.println("Saving Reviews");
			System.out.println(tempCourse);

			System.out.println(tempCourse.getReview());

			appDAO.save(tempCourse);
		}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting Course id:" + theId);

		appDAO.deleteCourseById(theId);

	}


	private void updateCourse(AppDAO appDAO){
		int theId=10;

		System.out.println("Finding instructor id:"+theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating instructor id :"+theId);
		tempCourse.setTitle("Emjoy the things you have !!");

		appDAO.update(tempCourse);
	}

		private void updateInstructor(AppDAO appDAO){
		int theId=1;

		System.out.println("Finding instructor id:"+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id :"+theId);
		tempInstructor.setLastName("Tester");

		appDAO.update(tempInstructor);
		}

		private void findInstructorWithCoursesJoinFetch(AppDAO appDAO){
		int theId=1;

		System.out.println("Finding Instructor id: "+theId);
		Instructor tempInstructor =appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("The Associated Courses :"+tempInstructor.getCourses());
		}

		private void findCoursesForInstructor(AppDAO appDAO){
		int theId=1;

		//find instructor
		System.out.println("finding instructor id:"+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor :"+tempInstructor);

		//find courses by instructorID
			List<Course> courses =appDAO.findCoursesByInstructorId(theId);

			tempInstructor.setCourses(courses);

			System.out.println("The Associated Courses :"+tempInstructor.getCourses());
		}


		private void findInstructorWithCourses(AppDAO appDAO){
		int theId=1;

		System.out.println("Finding by id :"+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor :"+tempInstructor);
		System.out.println("the Associated courses to Instructor Id"+ tempInstructor.getCourses());
		}

		private void createInstructorWithCourses(AppDAO appDAO){
			//create the instructor
			Instructor tempInstructor=
					new  Instructor("sandeep","kasi","sandeepsunny@gmail.com");
			//create the instructordetails
			InstructorDetails tempInstructorDetails =
					new InstructorDetails(
							"http;//www/indiagamming.com/youtube",
							"gamming !!");

			//associate the objects
			tempInstructor.setInstructorDetails(tempInstructorDetails);

			//creating or add some courses

			Course tempCourse1 = new Course("Guitar - Guided video");
			Course tempCourse2 = new Course("VideoGamming - Get ready for CoC Game War");

			//add courses to instructor

			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			//save the instructor
			//This will save courses too
			//because of CascadeType.persist

			System.out.println("Saving instructor :"+tempInstructor);
			System.out.println("the courses :"+ tempInstructor.getCourses());
			appDAO.save(tempInstructor);
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
