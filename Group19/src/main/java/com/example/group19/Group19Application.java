package com.example.group19;

import com.example.group19.model.*;
import com.example.group19.repository.CourseRepository;
import com.example.group19.repository.CourseReviewRepository;
import com.example.group19.repository.QuizRepository;
import com.example.group19.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Group19Application {

	public static void main(String[] args) {
		SpringApplication.run(Group19Application.class, args);
	}
}

@Component
class DataInitializer implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	CourseReviewRepository reviewRepo;
	@Autowired
	QuizRepository quizRepo;

	@Override
	public void run(String... args) {
		ArrayList<Object> courses = new ArrayList<>();

		Course course1 = new Course();
		course1.setCourseName("Data Fundamentals");
		course1.setCourseId(1);
		course1.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-5ce6af3f-f3a2-4eb9-9d44-690812d45210git");
		course1.setStarted(false);
		course1.setFinished(false);
		courseRepo.save(course1);

		Course course2 = new Course();
		course2.setCourseName("Information Technology Fundamentals");
		course2.setCourseId(2);
		course2.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-3419c178-70ff-4f57-8d51-e92d646186ad");
		course2.setStarted(false);
		course2.setFinished(false);
		courseRepo.save(course2);

		Course course3 = new Course();
		course3.setCourseName("Natural Language Processing and Computer Vision");
		course3.setCourseId(3);
		course3.setCourseLink("https://students.yourlearning.ibm.com/activity/MDLPT-223?channelId=CNL_LCB_1701806632885&channelNavigation=true");
		course3.setStarted(false);
		course3.setFinished(false);
		courseRepo.save(course3);

		Course course4 = new Course();
		course4.setCourseName("Web development");
		course4.setCourseId(4);
		course4.setCourseLink("https://students.yourlearning.ibm.com/recommended/aoi/TECHNICAL_SKILLS/WEB_DEVELOPMENT");
		course4.setStarted(false);
		course4.setFinished(false);
		courseRepo.save(course4);

		Course course5 = new Course();
		course5.setCourseName("Explore Emerging Tech");
		course5.setCourseId(5);
		course5.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-ce897036-6f39-4466-863f-0aa873f82213");
		course5.setStarted(false);
		course5.setFinished(false);
		courseRepo.save(course5);

		Course course6 = new Course();
		course6.setCourseName("Cloud Computing Fundamentals");
		course6.setCourseId(6);
		course6.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-fd600bd9-7565-458c-b5d2-7b5b8b856eeb");
		course6.setStarted(false);
		course6.setFinished(false);
		courseRepo.save(course6);

		Course course7 = new Course();
		course7.setCourseName("Cloud Core");
		course7.setCourseId(7);
		course7.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-a130b737-7295-4e48-a5ef-2c04299929a1");
		course7.setStarted(false);
		course7.setFinished(false);
		courseRepo.save(course7);

		Course course8 = new Course();
		course8.setCourseName("Blockchain - Getting Started");
		course8.setCourseId(8);
		course8.setCourseLink("https://students.yourlearning.ibm.com/channel/CNL_LCB_1568409227723");
		course8.setStarted(false);
		course8.setFinished(false);
		courseRepo.save(course8);

		Course course9 = new Course();
		course9.setCourseName("Cybersecurity Fundamentals");
		course9.setCourseId(9);
		course9.setCourseLink("https://students.yourlearning.ibm.com/channel/CNL_LCB_1582315125987");
		course9.setStarted(false);
		course9.setFinished(false);
		courseRepo.save(course9);

		Course course10 = new Course();
		course10.setCourseName("Quantum Computing");
		course10.setCourseId(10);
		course10.setCourseLink("https://students.yourlearning.ibm.com/channel/CNL_LCB_1596832013328");
		course10.setStarted(false);
		course10.setFinished(false);
		courseRepo.save(course10);

		Course course11 = new Course();
		course11.setCourseName("User Experience Design Fundamentals");
		course11.setCourseId(11);
		course11.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-ae2e453d-5311-41a0-be95-b217e0c4670f");
		course11.setStarted(false);
		course11.setFinished(false);
		courseRepo.save(course11);

		Course course12 = new Course();
		course12.setCourseName("Exploring Virtual Reality");
		course12.setCourseId(12);
		course12.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-ae2e453d-5311-41a0-be95-b217e0c4670f");
		course12.setStarted(false);
		course12.setFinished(false);
		courseRepo.save(course12);

		Course course13 = new Course();
		course13.setCourseName("IBM Z Xplore");
		course13.setCourseId(13);
		course13.setCourseLink("https://students.yourlearning.ibm.com/credential/CREDLY-ae2e453d-5311-41a0-be95-b217e0c4670f");
		course13.setStarted(false);
		course13.setFinished(false);
		courseRepo.save(course13);


		// Creating users here
		User user1 = new User();
		user1.setUsername("Mike123");
		user1.setName("Micheal");
		user1.setPassword("passkey");
		user1.setCoursesCompleted(3);
		user1.setId(1);
		userRepo.save(user1);

		//creating lists of courses for demo user
		List<Course> courses1 = new ArrayList<>();
		courses1.add(course1);
		courses1.add(course2);
		courses1.add(course3);
		courses1.add(course4);
		courses1.add(course5);
		user1.setEnrolled(courses1);
		userRepo.save(user1);

		List<Course> courses2 = new ArrayList<>();
		courses2.add(course2);
		courses2.add(course3);
		courses2.add(course1);
		user1.setCompleted(courses2);
		userRepo.save(user1);




		//testing leaderboard status

		User u = new User(2,"Zod", "Zach", "password", 4);
		u.setEnrolled(courses1);
		userRepo.save(u);
		User u1 = new User(3,"Iamspeed", "McQueen", "password", 8);
		u1.setEnrolled(courses1);
		userRepo.save(u1);
		User u2 = new User(4,"Ghost", "Jm", "password", 9);
		u2.setEnrolled(courses1);
		userRepo.save(u2);
		User u3 = new User(5,"BlazeIt420", "Blythe", "password", 0);
		u3.setEnrolled(courses1);
		userRepo.save(u3);
		User u4 = new User(6,"ABC", "Kevin", "password", 0);
		u4.setEnrolled(courses1);
		userRepo.save(u4);
		User u5 = new User(7,"Wick", "Obi", "password", 2);
		userRepo.save(u5);
		User u6 = new User(8,"Reese", "Kevin", "password", 0);
		userRepo.save(u6);
		User u7 = new User(9,"Sarah", "Obi", "password", 2);
		userRepo.save(u7);
		User u8 = new User(10,"Jack", "Kevin", "password", 0);
		userRepo.save(u8);
		User u9 = new User(11,"Leon", "Obi", "password", 2);
		userRepo.save(u9);

		//creating list of friends for demo user
		List<User>Friends = new ArrayList<>();
		Friends.add(u7);
		Friends.add(u3);
		Friends.add(u2);
		Friends.add(u6);

		user1.setFriends(Friends);
		userRepo.save(user1);

		CourseReview review1 = new CourseReview(course1,u5,"Excellent course", 5);
		CourseReview review2 = new CourseReview(course1,u9,"Found it quite challenging", 3);
		reviewRepo.save(review1);
		reviewRepo.save(review2);

		//Data for Quiz questions
		Quiz quiz = new Quiz();
		quiz.setCourseId(1); // Assuming the courseId for "Data Fundamentals" is 1

		// Define questions and answers
		List<Question> questions = new ArrayList<>();

		// Question 1
		Question q1 = new Question();
		q1.setQuestion("What is the primary purpose of data normalization?");
		q1.setOptions(List.of("Reduce redundancy", "Improve data security", "Increase data accuracy", "Enhance data visualization"));
		q1.setCorrectAnswerIndex(0); // Index of correct answer in the options list
		questions.add(q1);

		// Question 2
		Question q2 = new Question();
		q2.setQuestion("Which of the following is NOT a type of database model?");
		q2.setOptions(List.of("Relational", "NoSQL", "Hierarchical", "Linear"));
		q2.setCorrectAnswerIndex(3); // Index of correct answer in the options list
		questions.add(q2);

		//Question 3
		Question q3 = new Question();
		q3.setQuestion("What is data modeling?");
		q3.setOptions(List.of("Data modeling is the process of creating a data model for a database.","Data modeling is the process of designing clothes.", "Data modeling is the process of building cars.", "Data modeling is the process of cooking food."));
		q3.setCorrectAnswerIndex(0);
		questions.add(q3);


		// Question 4
		Question q4 = new Question();
		q4.setQuestion("What is the primary difference between structured and unstructured data?");
		q4.setOptions(List.of("Structured data is organized into a predefined format, while unstructured data lacks a specific structure.",
				"Structured data is unorganized and messy, while unstructured data is neatly arranged.",
				"Structured data contains only numerical values, while unstructured data contains textual information.",
				"Structured data is only used in relational databases, while unstructured data is used in NoSQL databases."));
		q4.setCorrectAnswerIndex(0);
		questions.add(q4);

		// Question 5
		Question q5 = new Question();
		q5.setQuestion("In the context of databases, what does ACID stand for?");
		q5.setOptions(List.of("Atomicity, Consistency, Integrity, Durability",
				"Association, Control, Isolation, Direction",
				"Accuracy, Compliance, Integration, Dependency",
				"Authorization, Configuration, Implementation, Deployment"));
		q5.setCorrectAnswerIndex(0);
		questions.add(q5);

		// Question 6
		Question q6 = new Question();
		q6.setQuestion("Which of the following is an example of a NoSQL database?");
		q6.setOptions(List.of("MySQL", "PostgreSQL", "MongoDB", "Oracle"));
		q6.setCorrectAnswerIndex(2);
		questions.add(q6);

		// Question 7
		Question q7 = new Question();
		q7.setQuestion("What is the purpose of a foreign key in a relational database?");
		q7.setOptions(List.of("To ensure each row in a table is uniquely identifiable.",
				"To enforce referential integrity between two related tables.",
				"To speed up data retrieval operations.",
				"To store large binary data efficiently."));
		q7.setCorrectAnswerIndex(1);
		questions.add(q7);

		// Question 8
		Question q8 = new Question();
		q8.setQuestion("What is the role of a database index?");
		q8.setOptions(List.of("To encrypt sensitive data stored in the database.",
				"To provide a backup of the database in case of failure.",
				"To optimize query performance by allowing faster data retrieval.",
				"To restrict unauthorized access to the database."));
		q8.setCorrectAnswerIndex(2);
		questions.add(q8);

		// Question 9
		Question q9 = new Question();
		q9.setQuestion("What is the purpose of a primary key in a database table?");
		q9.setOptions(List.of("To establish a relationship between two tables.",
				"To uniquely identify each record in the table.",
				"To store sensitive information securely.",
				"To facilitate data visualization processes."));
		q9.setCorrectAnswerIndex(1);
		questions.add(q9);

		// Question 10
		Question q10 = new Question();
		q10.setQuestion("What is the difference between OLTP and OLAP databases?");
		q10.setOptions(List.of("OLTP databases are optimized for complex analytical queries, while OLAP databases are designed for transaction processing.",
				"OLTP databases are used for online transaction processing, while OLAP databases are used for online analytical processing.",
				"OLTP databases are schema-less, while OLAP databases adhere to a strict schema.",
				"OLTP databases are typically used in data warehousing, while OLAP databases are used in e-commerce platforms."));
		q10.setCorrectAnswerIndex(1);
		questions.add(q10);


		quiz.setQuestions(questions);
		quiz.setCreatedAt(new Date());

		//You can save the 'quiz' object to your repository here
		quizRepo.save(quiz);


	// Data for Information Technology Fundamentals questions
		Quiz itFundamentalsQuiz = new Quiz();
		itFundamentalsQuiz.setCourseId(2); // Assuming the courseId for "Information Technology Fundamentals" is 2

	// Define questions and answers
		List<Question> itQuestions = new ArrayList<>();

// Question 1
		Question itQ1 = new Question();
		itQ1.setQuestion("What is the primary function of an operating system?");
		itQ1.setOptions(List.of("Manage computer hardware and software resources", "Create graphical user interfaces", "Run web servers", "Develop mobile applications"));
		itQ1.setCorrectAnswerIndex(0);
		itQuestions.add(itQ1);

// Question 2
		Question itQ2 = new Question();
		itQ2.setQuestion("What does CPU stand for?");
		itQ2.setOptions(List.of("Central Processing Unit", "Computer Processing Unit", "Central Program Unit", "Core Programming Unit"));
		itQ2.setCorrectAnswerIndex(1); // Change correct answer index
		itQuestions.add(itQ2);

// Question 3
		Question itQ3 = new Question();
		itQ3.setQuestion("What is the purpose of RAM in a computer?");
		itQ3.setOptions(List.of("To temporarily store data and program instructions for quick access by the CPU", "To permanently store data even when the computer is turned off", "To manage input and output devices", "To execute arithmetic and logic operations"));
		itQ3.setCorrectAnswerIndex(2); // Change correct answer index
		itQuestions.add(itQ3);

// Question 4
		Question itQ4 = new Question();
		itQ4.setQuestion("Which programming language is commonly used for web development?");
		itQ4.setOptions(List.of("JavaScript", "C++", "Python", "Java"));
		itQ4.setCorrectAnswerIndex(3); // Change correct answer index
		itQuestions.add(itQ4);

// Question 5
		Question itQ5 = new Question();
		itQ5.setQuestion("What does HTML stand for?");
		itQ5.setOptions(List.of("Hypertext Markup Language", "Hyperlinks and Text Markup Language", "High-Level Text Management Language", "Hyperlink Textual Markup Language"));
		itQ5.setCorrectAnswerIndex(0);
		itQuestions.add(itQ5);

// Question 6
		Question itQ6 = new Question();
		itQ6.setQuestion("What is the purpose of a firewall?");
		itQ6.setOptions(List.of("To protect a network by monitoring and controlling incoming and outgoing traffic", "To enhance the performance of computer processors", "To manage user authentication and access control", "To store and manage databases"));
		itQ6.setCorrectAnswerIndex(1); // Change correct answer index
		itQuestions.add(itQ6);

// Question 7
		Question itQ7 = new Question();
		itQ7.setQuestion("What does DNS stand for?");
		itQ7.setOptions(List.of("Domain Name System", "Dynamic Network Server", "Data Network Security", "Digital Naming Service"));
		itQ7.setCorrectAnswerIndex(0);
		itQuestions.add(itQ7);

// Question 8
		Question itQ8 = new Question();
		itQ8.setQuestion("What is the purpose of an IP address?");
		itQ8.setOptions(List.of("To uniquely identify a device on a network", "To encrypt data transmissions", "To manage internet protocols", "To create dynamic web content"));
		itQ8.setCorrectAnswerIndex(2); // Change correct answer index
		itQuestions.add(itQ8);

// Question 9
		Question itQ9 = new Question();
		itQ9.setQuestion("What is the function of a router in a network?");
		itQ9.setOptions(List.of("To forward data packets between computer networks", "To store and retrieve data files", "To manage database transactions", "To provide web hosting services"));
		itQ9.setCorrectAnswerIndex(0);
		itQuestions.add(itQ9);

// Question 10
		Question itQ10 = new Question();
		itQ10.setQuestion("What is the purpose of software version control systems like Git?");
		itQ10.setOptions(List.of("To track changes to source code and coordinate work among multiple developers", "To optimize database performance", "To manage server hardware resources", "To secure network communications"));
		itQ10.setCorrectAnswerIndex(3); // Change correct answer index
		itQuestions.add(itQ10);

		itFundamentalsQuiz.setQuestions(itQuestions);
		itFundamentalsQuiz.setCreatedAt(new Date());

// You can save the 'itFundamentalsQuiz' object to your repository here
		quizRepo.save(itFundamentalsQuiz);

		// Data for Quiz questions
		Quiz nlpAndCVQuiz = new Quiz();
		nlpAndCVQuiz.setCourseId(3); // Assuming the courseId for "Natural Language Processing and Computer Vision" is 3

// Define questions and answers
		List<Question> nlpAndCVQuestions = new ArrayList<>();

// Question 1
		Question nlpAndCVQ1 = new Question();
		nlpAndCVQ1.setQuestion("What is the primary goal of Natural Language Processing (NLP)?");
		nlpAndCVQ1.setOptions(List.of("To enable computers to understand, interpret, and generate human language", "To develop advanced graphical user interfaces", "To analyze and visualize complex data structures", "To optimize computer networks for high-speed data transmission"));
		nlpAndCVQ1.setCorrectAnswerIndex(0);
		nlpAndCVQuestions.add(nlpAndCVQ1);

// Question 2
		Question nlpAndCVQ2 = new Question();
		nlpAndCVQ2.setQuestion("Which of the following is a common task in Natural Language Processing?");
		nlpAndCVQ2.setOptions(List.of("Named Entity Recognition", "Image Classification", "Speech Synthesis", "Face Detection"));
		nlpAndCVQ2.setCorrectAnswerIndex(1); // Change correct answer index
		nlpAndCVQuestions.add(nlpAndCVQ2);

// Question 3
		Question nlpAndCVQ3 = new Question();
		nlpAndCVQ3.setQuestion("What is the purpose of tokenization in Natural Language Processing?");
		nlpAndCVQ3.setOptions(List.of("To break text into smaller units such as words or sentences", "To convert text into images", "To analyze the sentiment of text data", "To translate text between different languages"));
		nlpAndCVQ3.setCorrectAnswerIndex(0);
		nlpAndCVQuestions.add(nlpAndCVQ3);

// Question 4
		Question nlpAndCVQ4 = new Question();
		nlpAndCVQ4.setQuestion("Which of the following is an application of Computer Vision?");
		nlpAndCVQ4.setOptions(List.of("Object Detection", "Speech Recognition", "Text Summarization", "Network Security"));
		nlpAndCVQ4.setCorrectAnswerIndex(3); // Change correct answer index
		nlpAndCVQuestions.add(nlpAndCVQ4);

// Question 5
		Question nlpAndCVQ5 = new Question();
		nlpAndCVQ5.setQuestion("What is the purpose of Convolutional Neural Networks (CNNs) in Computer Vision?");
		nlpAndCVQ5.setOptions(List.of("To automatically and adaptively learn spatial hierarchies of features from images", "To generate human-like speech from text input", "To classify text documents into categories", "To predict stock market trends"));
		nlpAndCVQ5.setCorrectAnswerIndex(0);
		nlpAndCVQuestions.add(nlpAndCVQ5);

// Question 6
		Question nlpAndCVQ6 = new Question();
		nlpAndCVQ6.setQuestion("Which technique is commonly used for image segmentation in Computer Vision?");
		nlpAndCVQ6.setOptions(List.of("Mask R-CNN", "Recurrent Neural Networks (RNNs)", "Naive Bayes Classification", "K-means Clustering"));
		nlpAndCVQ6.setCorrectAnswerIndex(1); // Change correct answer index
		nlpAndCVQuestions.add(nlpAndCVQ6);

// Question 7
		Question nlpAndCVQ7 = new Question();
		nlpAndCVQ7.setQuestion("What does OCR stand for in the context of Computer Vision?");
		nlpAndCVQ7.setOptions(List.of("Optical Character Recognition", "Object Class Recognition", "Online Content Rendering", "Optimized Convolutional Reconstruction"));
		nlpAndCVQ7.setCorrectAnswerIndex(0);
		nlpAndCVQuestions.add(nlpAndCVQ7);

// Question 8
		Question nlpAndCVQ8 = new Question();
		nlpAndCVQ8.setQuestion("What is the purpose of pre-trained word embeddings in Natural Language Processing?");
		nlpAndCVQ8.setOptions(List.of("To represent words in a dense vector space capturing semantic meanings", "To convert images into text descriptions", "To detect anomalies in time-series data", "To compress large textual datasets"));
		nlpAndCVQ8.setCorrectAnswerIndex(2); // Change correct answer index
		nlpAndCVQuestions.add(nlpAndCVQ8);

// Question 9
		Question nlpAndCVQ9 = new Question();
		nlpAndCVQ9.setQuestion("Which evaluation metric is commonly used for image classification tasks in Computer Vision?");
		nlpAndCVQ9.setOptions(List.of("Accuracy", "F1 Score", "Precision", "Recall"));
		nlpAndCVQ9.setCorrectAnswerIndex(0);
		nlpAndCVQuestions.add(nlpAndCVQ9);

// Question 10
		Question nlpAndCVQ10 = new Question();
		nlpAndCVQ10.setQuestion("What is the purpose of data augmentation in training deep learning models for Computer Vision?");
		nlpAndCVQ10.setOptions(List.of("To increase the diversity of training data and improve model generalization", "To compress images for faster processing", "To remove noise from images", "To encrypt sensitive information in images"));
		nlpAndCVQ10.setCorrectAnswerIndex(3); // Change correct answer index
		nlpAndCVQuestions.add(nlpAndCVQ10);

		nlpAndCVQuiz.setQuestions(nlpAndCVQuestions);
		nlpAndCVQuiz.setCreatedAt(new Date());

// You can save the 'nlpAndCVQuiz' object to your repository here
		quizRepo.save(nlpAndCVQuiz);


		// Data for WEB DEVELOPMENT questions
		Quiz webDevelopmentQuiz = new Quiz();
		webDevelopmentQuiz.setCourseId(4); // Assuming the courseId for "Web Development" is 4

// Define questions and answers
		List<Question> webDevelopmentQuestions = new ArrayList<>();

// Question 1
		Question webDevQ1 = new Question();
		webDevQ1.setQuestion("What is the primary language used for styling web pages?");
		webDevQ1.setOptions(List.of("CSS (Cascading Style Sheets)", "HTML (Hypertext Markup Language)", "JavaScript", "Java"));
		webDevQ1.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ1);

// Question 2
		Question webDevQ2 = new Question();
		webDevQ2.setQuestion("Which of the following is NOT a valid HTTP status code?");
		webDevQ2.setOptions(List.of("600", "404", "200", "503"));
		webDevQ2.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ2);

// Question 3
		Question webDevQ3 = new Question();
		webDevQ3.setQuestion("What does MVC stand for in the context of web development?");
		webDevQ3.setOptions(List.of("Model-View-Controller", "Markup-Validation-Check", "Main-View-Control", "Mobile-View-Creation"));
		webDevQ3.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ3);

// Question 4
		Question webDevQ4 = new Question();
		webDevQ4.setQuestion("Which of the following is NOT a commonly used web development framework?");
		webDevQ4.setOptions(List.of("TensorFlow", "React", "Angular", "Vue.js"));
		webDevQ4.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ4);

// Question 5
		Question webDevQ5 = new Question();
		webDevQ5.setQuestion("What is the purpose of the 'alt' attribute in HTML image tags?");
		webDevQ5.setOptions(List.of("To provide alternative text for screen readers and search engines", "To specify the alignment of the image", "To apply styling to the image", "To link the image to another web page"));
		webDevQ5.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ5);

// Question 6
		Question webDevQ6 = new Question();
		webDevQ6.setQuestion("Which of the following is NOT a valid CSS selector?");
		webDevQ6.setOptions(List.of("+-element", ".class", "#id", "element > element"));
		webDevQ6.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ6);

// Question 7
		Question webDevQ7 = new Question();
		webDevQ7.setQuestion("What is the purpose of responsive web design?");
		webDevQ7.setOptions(List.of("To ensure that web pages display well on various devices and screen sizes", "To encrypt sensitive data transmitted over the internet", "To optimize web server performance", "To automate software testing"));
		webDevQ7.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ7);

// Question 8
		Question webDevQ8 = new Question();
		webDevQ8.setQuestion("Which of the following is NOT a commonly used database in web development?");
		webDevQ8.setOptions(List.of("XML", "MySQL", "PostgreSQL", "MongoDB"));
		webDevQ8.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ8);

// Question 9
		Question webDevQ9 = new Question();
		webDevQ9.setQuestion("What is the purpose of the 'href' attribute in HTML anchor tags?");
		webDevQ9.setOptions(List.of("To specify the URL of the linked page", "To add a tooltip to the link", "To change the color of the link", "To hide the link from search engine crawlers"));
		webDevQ9.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ9);

// Question 10
		Question webDevQ10 = new Question();
		webDevQ10.setQuestion("What does AJAX stand for in the context of web development?");
		webDevQ10.setOptions(List.of("Asynchronous JavaScript and XML", "Advanced JavaScript and XHTML", "Automated JSON and XML", "Asynchronous jQuery and XHTML"));
		webDevQ10.setCorrectAnswerIndex(0);
		webDevelopmentQuestions.add(webDevQ10);

		webDevelopmentQuiz.setQuestions(webDevelopmentQuestions);
		webDevelopmentQuiz.setCreatedAt(new Date());

// You can save the 'webDevelopmentQuiz' object to your repository here
		quizRepo.save(webDevelopmentQuiz);


		// Data for Quiz questions
		Quiz emergingTechQuiz = new Quiz();
		emergingTechQuiz.setCourseId(5); // Assuming the courseId for "Explore Emerging Tech" is 5

// Define questions and answers
		List<Question> emergingTechQuestions = new ArrayList<>();

// Question 1
		Question etQ1 = new Question();
		etQ1.setQuestion("What is Blockchain technology primarily known for?");
		etQ1.setOptions(List.of("Decentralized and secure transactions", "High-speed data processing", "Real-time language translation", "Advanced image recognition"));
		etQ1.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ1);

// Question 2
		Question etQ2 = new Question();
		etQ2.setQuestion("Which of the following is an application of Augmented Reality (AR)?");
		etQ2.setOptions(List.of("Enhancing real-world environments with digital overlays", "Simulating three-dimensional environments", "Creating virtual social networks", "Predicting future weather patterns"));
		etQ2.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ2);

// Question 3
		Question etQ3 = new Question();
		etQ3.setQuestion("What does IoT stand for in the context of emerging technologies?");
		etQ3.setOptions(List.of("Internet of Things", "Interactive Online Technologies", "Integrated Optical Transmitters", "Intelligent Operating Technologies"));
		etQ3.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ3);

// Question 4
		Question etQ4 = new Question();
		etQ4.setQuestion("Which technology is commonly associated with the term 'Big Data'?");
		etQ4.setOptions(List.of("Data analytics and processing of large datasets", "Quantum computing", "Virtual reality gaming", "Nanotechnology"));
		etQ4.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ4);

// Question 5
		Question etQ5 = new Question();
		etQ5.setQuestion("What is the primary goal of Artificial Intelligence (AI)?");
		etQ5.setOptions(List.of("To simulate human-like intelligence and decision-making", "To create realistic computer-generated images", "To improve internet connection speed", "To design energy-efficient hardware"));
		etQ5.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ5);

// Question 6
		Question etQ6 = new Question();
		etQ6.setQuestion("Which technology is associated with the term 'Quantum Computing'?");
		etQ6.setOptions(List.of("Using quantum-mechanical phenomena to perform operations on data", "Creating interactive virtual environments", "Improving wireless communication protocols", "Developing advanced robotic systems"));
		etQ6.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ6);

// Question 7
		Question etQ7 = new Question();
		etQ7.setQuestion("What is the purpose of Edge Computing?");
		etQ7.setOptions(List.of("To process data closer to the source or destination, reducing latency and bandwidth usage", "To encrypt sensitive information during transmission", "To optimize database queries", "To enhance user interface design"));
		etQ7.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ7);

// Question 8
		Question etQ8 = new Question();
		etQ8.setQuestion("Which technology is commonly used in the development of autonomous vehicles?");
		etQ8.setOptions(List.of("Machine Learning", "3D Printing", "Biotechnology", "Cloud Computing"));
		etQ8.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ8);

// Question 9
		Question etQ9 = new Question();
		etQ9.setQuestion("What is the purpose of 5G technology?");
		etQ9.setOptions(List.of("To provide faster wireless communication and support a higher density of connected devices", "To increase the number of dimensions in virtual reality simulations", "To improve data storage efficiency", "To develop advanced medical imaging techniques"));
		etQ9.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ9);

// Question 10
		Question etQ10 = new Question();
		etQ10.setQuestion("What is the significance of CRISPR technology?");
		etQ10.setOptions(List.of("For gene editing and genetic engineering", "For quantum cryptography", "For real-time language translation", "For developing blockchain applications"));
		etQ10.setCorrectAnswerIndex(0);
		emergingTechQuestions.add(etQ10);

		emergingTechQuiz.setQuestions(emergingTechQuestions);
		emergingTechQuiz.setCreatedAt(new Date());

// You can save the 'emergingTechQuiz' object to your repository here
		quizRepo.save(emergingTechQuiz);

		// Data for Quiz questions
		Quiz cloudComputingQuiz = new Quiz();
		cloudComputingQuiz.setCourseId(6); // Assuming the courseId for "Cloud Computing Fundamentals" is 6

// Define questions and answers
		List<Question> cloudComputingQuestions = new ArrayList<>();

// Question 1
		Question ccQ1 = new Question();
		ccQ1.setQuestion("What is the primary advantage of cloud computing?");
		ccQ1.setOptions(List.of("Scalability and flexibility of resources", "Low-level hardware access", "Offline data storage", "Limited accessibility"));
		ccQ1.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ1);

// Question 2
		Question ccQ2 = new Question();
		ccQ2.setQuestion("Which of the following is a characteristic of Infrastructure as a Service (IaaS)?");
		ccQ2.setOptions(List.of("Providers offer virtualized computing resources over the internet", "Developers focus on building and maintaining applications", "Users access software applications via a web browser", "Services are typically accessed via APIs"));
		ccQ2.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ2);

// Question 3
		Question ccQ3 = new Question();
		ccQ3.setQuestion("What is the purpose of auto-scaling in cloud computing?");
		ccQ3.setOptions(List.of("To automatically adjust the number of resources based on demand", "To secure cloud infrastructure against cyber threats", "To schedule routine maintenance tasks", "To optimize database queries"));
		ccQ3.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ3);

// Question 4
		Question ccQ4 = new Question();
		ccQ4.setQuestion("Which cloud deployment model provides resources exclusively for a single organization?");
		ccQ4.setOptions(List.of("Private Cloud", "Public Cloud", "Hybrid Cloud", "Community Cloud"));
		ccQ4.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ4);

// Question 5
		Question ccQ5 = new Question();
		ccQ5.setQuestion("What does SaaS stand for in the context of cloud computing?");
		ccQ5.setOptions(List.of("Software as a Service", "Storage as a Service", "Security as a Service", "Serverless as a Service"));
		ccQ5.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ5);

// Question 6
		Question ccQ6 = new Question();
		ccQ6.setQuestion("Which cloud computing service model allows developers to focus solely on building and deploying applications?");
		ccQ6.setOptions(List.of("Platform as a Service (PaaS)", "Infrastructure as a Service (IaaS)", "Software as a Service (SaaS)", "Function as a Service (FaaS)"));
		ccQ6.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ6);

// Question 7
		Question ccQ7 = new Question();
		ccQ7.setQuestion("What is the purpose of a Virtual Private Cloud (VPC) in cloud computing?");
		ccQ7.setOptions(List.of("To create a logically isolated section of the cloud dedicated to a specific organization", "To optimize database performance", "To automate software testing", "To manage internet protocols"));
		ccQ7.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ7);

// Question 8
		Question ccQ8 = new Question();
		ccQ8.setQuestion("Which cloud service model is also known as 'on-demand software'?");
		ccQ8.setOptions(List.of("Software as a Service (SaaS)", "Platform as a Service (PaaS)", "Infrastructure as a Service (IaaS)", "Function as a Service (FaaS)"));
		ccQ8.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ8);

// Question 9
		Question ccQ9 = new Question();
		ccQ9.setQuestion("What is the purpose of multi-tenancy in cloud computing?");
		ccQ9.setOptions(List.of("To allow multiple users to share resources on the same infrastructure", "To create a dedicated virtual network for each user", "To synchronize data across multiple cloud regions", "To encrypt sensitive information during transmission"));
		ccQ9.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ9);

// Question 10
		Question ccQ10 = new Question();
		ccQ10.setQuestion("What does CDN stand for in the context of cloud computing?");
		ccQ10.setOptions(List.of("Content Delivery Network", "Cloud Development Network", "Centralized Data Network", "Cloud Distribution Node"));
		ccQ10.setCorrectAnswerIndex(0);
		cloudComputingQuestions.add(ccQ10);

		cloudComputingQuiz.setQuestions(cloudComputingQuestions);
		cloudComputingQuiz.setCreatedAt(new Date());

// You can save the 'cloudComputingQuiz' object to your repository here
		quizRepo.save(cloudComputingQuiz);

		// Data for Quiz questions
		Quiz cloudCoreQuiz = new Quiz();
		cloudCoreQuiz.setCourseId(7); // Assuming the courseId for "Cloud Core" is 7

// Define questions and answers
		List<Question> cloudCoreQuestions = new ArrayList<>();

// Question 1
		Question cccQ1 = new Question();
		cccQ1.setQuestion("What is a virtual machine (VM) in the context of cloud computing?");
		cccQ1.setOptions(List.of("A software emulation of a physical computer", "A physical server hosted in a data center", "A network device for routing data packets", "An advanced machine learning algorithm"));
		cccQ1.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ1);

// Question 2
		Question cccQ2 = new Question();
		cccQ2.setQuestion("What is the purpose of load balancing in cloud computing?");
		cccQ2.setOptions(List.of("To evenly distribute incoming network traffic across multiple servers", "To store and manage large volumes of data", "To synchronize data across different cloud regions", "To optimize database queries"));
		cccQ2.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ2);

// Question 3
		Question cccQ3 = new Question();
		cccQ3.setQuestion("Which cloud computing service model provides developers with pre-configured software environments?");
		cccQ3.setOptions(List.of("Platform as a Service (PaaS)", "Infrastructure as a Service (IaaS)", "Software as a Service (SaaS)", "Function as a Service (FaaS)"));
		cccQ3.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ3);

// Question 4
		Question cccQ4 = new Question();
		cccQ4.setQuestion("What is the purpose of network security groups (NSGs) in cloud computing?");
		cccQ4.setOptions(List.of("To control inbound and outbound traffic to virtual machines", "To optimize network performance", "To automate software deployment", "To manage user authentication and access control"));
		cccQ4.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ4);

// Question 5
		Question cccQ5 = new Question();
		cccQ5.setQuestion("Which cloud computing service model allows users to run code in response to events without managing server infrastructure?");
		cccQ5.setOptions(List.of("Function as a Service (FaaS)", "Platform as a Service (PaaS)", "Infrastructure as a Service (IaaS)", "Software as a Service (SaaS)"));
		cccQ5.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ5);

// Question 6
		Question cccQ6 = new Question();
		cccQ6.setQuestion("What is the purpose of a virtual private network (VPN) in cloud computing?");
		cccQ6.setOptions(List.of("To securely connect on-premises networks to the cloud", "To optimize database performance", "To automate software testing", "To manage internet protocols"));
		cccQ6.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ6);

// Question 7
		Question cccQ7 = new Question();
		cccQ7.setQuestion("Which of the following is NOT a key characteristic of cloud computing?");
		cccQ7.setOptions(List.of("Physical hardware ownership", "On-demand self-service", "Scalability", "Resource pooling"));
		cccQ7.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ7);

// Question 8
		Question cccQ8 = new Question();
		cccQ8.setQuestion("What is the purpose of a cloud service level agreement (SLA)?");
		cccQ8.setOptions(List.of("To define the level of service provided by the cloud provider and the rights and responsibilities of the customer", "To encrypt sensitive information during transmission", "To manage internet protocols", "To synchronize data across multiple cloud regions"));
		cccQ8.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ8);

// Question 9
		Question cccQ9 = new Question();
		cccQ9.setQuestion("Which cloud deployment model provides resources shared across multiple organizations?");
		cccQ9.setOptions(List.of("Public Cloud", "Private Cloud", "Hybrid Cloud", "Community Cloud"));
		cccQ9.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ9);

// Question 10
		Question cccQ10 = new Question();
		cccQ10.setQuestion("What is the purpose of a cloud gateway in cloud computing?");
		cccQ10.setOptions(List.of("To provide secure connectivity between on-premises infrastructure and cloud resources", "To optimize database performance", "To automate software deployment", "To manage user authentication and access control"));
		cccQ10.setCorrectAnswerIndex(0);
		cloudCoreQuestions.add(cccQ10);

		cloudCoreQuiz.setQuestions(cloudCoreQuestions);
		cloudCoreQuiz.setCreatedAt(new Date());

// You can save the 'cloudCoreQuiz' object to your repository here
		quizRepo.save(cloudCoreQuiz);

		// Data for Quiz questions
		Quiz blockchainQuiz = new Quiz();
		blockchainQuiz.setCourseId(8); // Assuming the courseId for "Blockchain - Getting Started" is 8

// Define questions and answers
		List<Question> blockchainQuestions = new ArrayList<>();

// Question 1
		Question bcQ1 = new Question();
		bcQ1.setQuestion("What is a blockchain?");
		bcQ1.setOptions(List.of("A decentralized, distributed ledger technology", "A centralized database managed by a single entity", "A type of cryptocurrency", "An encryption algorithm"));
		bcQ1.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ1);

// Question 2
		Question bcQ2 = new Question();
		bcQ2.setQuestion("What is the primary purpose of blockchain technology?");
		bcQ2.setOptions(List.of("To provide secure and transparent transactions without the need for intermediaries", "To store large volumes of data in a centralized database", "To manage user authentication and access control", "To optimize database performance"));
		bcQ2.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ2);

// Question 3
		Question bcQ3 = new Question();
		bcQ3.setQuestion("What is a smart contract in the context of blockchain?");
		bcQ3.setOptions(List.of("Self-executing contracts with the terms of the agreement directly written into code", "A legally binding contract between two parties", "An agreement enforced by a third-party intermediary", "A contract stored on a traditional paper document"));
		bcQ3.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ3);

// Question 4
		Question bcQ4 = new Question();
		bcQ4.setQuestion("Which consensus mechanism is commonly used in public blockchain networks like Bitcoin and Ethereum?");
		bcQ4.setOptions(List.of("Proof of Work (PoW)", "Proof of Stake (PoS)", "Delegated Proof of Stake (DPoS)", "Practical Byzantine Fault Tolerance (PBFT)"));
		bcQ4.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ4);

// Question 5
		Question bcQ5 = new Question();
		bcQ5.setQuestion("What is the role of a miner in a blockchain network?");
		bcQ5.setOptions(List.of("To validate transactions and add them to the blockchain", "To provide liquidity to the network", "To facilitate peer-to-peer transactions", "To secure private keys of users"));
		bcQ5.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ5);

// Question 6
		Question bcQ6 = new Question();
		bcQ6.setQuestion("What is the function of a nonce in the context of blockchain mining?");
		bcQ6.setOptions(List.of("A random number used to generate a valid hash value", "A cryptographic key used to sign transactions", "A data structure used to store transactions", "A unique identifier for each block in the blockchain"));
		bcQ6.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ6);

// Question 7
		Question bcQ7 = new Question();
		bcQ7.setQuestion("What is the difference between public and private blockchains?");
		bcQ7.setOptions(List.of("Public blockchains are open and decentralized, while private blockchains are permissioned and centralized", "Public blockchains are only accessible to authorized users, while private blockchains are open to the public", "Public blockchains have faster transaction speeds than private blockchains", "Private blockchains are primarily used for cryptocurrencies, while public blockchains are used for enterprise applications"));
		bcQ7.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ7);

// Question 8
		Question bcQ8 = new Question();
		bcQ8.setQuestion("What is the purpose of cryptographic hashing in blockchain?");
		bcQ8.setOptions(List.of("To ensure data integrity and secure transactions", "To generate new cryptocurrency tokens", "To verify the identity of network participants", "To store and retrieve data from the blockchain"));
		bcQ8.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ8);

// Question 9
		Question bcQ9 = new Question();
		bcQ9.setQuestion("What is the role of a node in a blockchain network?");
		bcQ9.setOptions(List.of("To maintain a copy of the blockchain and validate transactions", "To execute smart contracts", "To mine new cryptocurrency tokens", "To act as an intermediary in transactions"));
		bcQ9.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ9);

// Question 10
		Question bcQ10 = new Question();
		bcQ10.setQuestion("What is the concept of immutability in blockchain?");
		bcQ10.setOptions(List.of("Once data is recorded on the blockchain, it cannot be altered or deleted", "The ability to scale blockchain networks horizontally", "The process of verifying transactions on the blockchain", "The encryption of data stored on the blockchain"));
		bcQ10.setCorrectAnswerIndex(0);
		blockchainQuestions.add(bcQ10);

		blockchainQuiz.setQuestions(blockchainQuestions);
		blockchainQuiz.setCreatedAt(new Date());

// You can save the 'blockchainQuiz' object to your repository here
		quizRepo.save(blockchainQuiz);

		// Data for Quiz questions
		Quiz cybersecurityQuiz = new Quiz();
		cybersecurityQuiz.setCourseId(9); // Assuming the courseId for "Cybersecurity Fundamentals" is 9

// Define questions and answers
		List<Question> cybersecurityQuestions = new ArrayList<>();

// Question 1
		Question csQ1 = new Question();
		csQ1.setQuestion("What is cybersecurity?");
		csQ1.setOptions(List.of("The practice of protecting systems, networks, and data from digital attacks", "The process of analyzing big data sets", "The study of human-computer interaction", "The development of artificial intelligence algorithms"));
		csQ1.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ1);

// Question 2
		Question csQ2 = new Question();
		csQ2.setQuestion("What is the primary goal of cybersecurity?");
		csQ2.setOptions(List.of("To prevent unauthorized access, data breaches, and other cyberattacks", "To enhance system performance", "To increase network bandwidth", "To develop new software applications"));
		csQ2.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ2);

// Question 3
		Question csQ3 = new Question();
		csQ3.setQuestion("What is a firewall?");
		csQ3.setOptions(List.of("A network security device that monitors and controls incoming and outgoing network traffic", "A hardware component used to store data", "A programming language for web development", "A type of malware"));
		csQ3.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ3);

// Question 4
		Question csQ4 = new Question();
		csQ4.setQuestion("What is the purpose of encryption in cybersecurity?");
		csQ4.setOptions(List.of("To protect data by converting it into a code that can only be deciphered with the correct decryption key", "To detect and remove malware from systems", "To optimize database performance", "To authenticate users"));
		csQ4.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ4);

// Question 5
		Question csQ5 = new Question();
		csQ5.setQuestion("What is a phishing attack?");
		csQ5.setOptions(List.of("A type of social engineering attack in which attackers deceive individuals into providing sensitive information", "A denial-of-service attack that floods a network with traffic", "A hardware failure that causes data loss", "A software vulnerability exploited by hackers"));
		csQ5.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ5);

// Question 6
		Question csQ6 = new Question();
		csQ6.setQuestion("What is malware?");
		csQ6.setOptions(List.of("Malicious software designed to disrupt, damage, or gain unauthorized access to computer systems", "A network protocol for securely transferring files", "A programming language used for web development", "A type of encryption algorithm"));
		csQ6.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ6);

// Question 7
		Question csQ7 = new Question();
		csQ7.setQuestion("What is the purpose of multi-factor authentication (MFA) in cybersecurity?");
		csQ7.setOptions(List.of("To enhance security by requiring users to provide multiple forms of identification", "To encrypt data stored in databases", "To optimize network performance", "To detect and respond to security incidents"));
		csQ7.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ7);

// Question 8
		Question csQ8 = new Question();
		csQ8.setQuestion("What is a vulnerability assessment?");
		csQ8.setOptions(List.of("A process of identifying, quantifying, and prioritizing security vulnerabilities in systems", "A type of cyberattack targeting web applications", "A method for recovering lost data from backups", "A technique for bypassing security controls"));
		csQ8.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ8);

// Question 9
		Question csQ9 = new Question();
		csQ9.setQuestion("What is the role of a Security Operations Center (SOC) in cybersecurity?");
		csQ9.setOptions(List.of("To monitor and analyze security events and incidents on an ongoing basis", "To develop new cybersecurity policies and procedures", "To provide technical support to end-users", "To manage software updates and patches"));
		csQ9.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ9);

// Question 10
		Question csQ10 = new Question();
		csQ10.setQuestion("What is the concept of least privilege in cybersecurity?");
		csQ10.setOptions(List.of("The principle of providing users with the minimum level of access required to perform their job functions", "The practice of encrypting sensitive data at rest and in transit", "The process of implementing security controls based on user roles", "The idea of regularly updating security software to protect against new threats"));
		csQ10.setCorrectAnswerIndex(0);
		cybersecurityQuestions.add(csQ10);

		cybersecurityQuiz.setQuestions(cybersecurityQuestions);
		cybersecurityQuiz.setCreatedAt(new Date());

// You can save the 'cybersecurityQuiz' object to your repository here
		quizRepo.save(cybersecurityQuiz);

		// Data for Quiz questions
		Quiz quantumComputingQuiz = new Quiz();
		quantumComputingQuiz.setCourseId(10); // Assuming the courseId for "Quantum Computing" is 10

// Define questions and answers
		List<Question> quantumComputingQuestions = new ArrayList<>();

// Question 1
		Question qcQ1 = new Question();
		qcQ1.setQuestion("What is quantum computing?");
		qcQ1.setOptions(List.of("A computing paradigm that utilizes the principles of quantum mechanics to perform calculations", "A type of cloud computing specialized for scientific research", "A programming language for quantum algorithms", "An encryption method used to secure data"));
		qcQ1.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ1);

// Question 2
		Question qcQ2 = new Question();
		qcQ2.setQuestion("What is a qubit?");
		qcQ2.setOptions(List.of("The basic unit of quantum information, analogous to a classical bit", "A type of software application for quantum computers", "A measurement device used in quantum experiments", "A component of a quantum algorithm"));
		qcQ2.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ2);

// Question 3
		Question qcQ3 = new Question();
		qcQ3.setQuestion("What is superposition in quantum computing?");
		qcQ3.setOptions(List.of("The ability of a qubit to exist in multiple states simultaneously", "A quantum algorithm for factoring large numbers", "A quantum error correction technique", "A hardware component of a quantum computer"));
		qcQ3.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ3);

// Question 4
		Question qcQ4 = new Question();
		qcQ4.setQuestion("What is entanglement in quantum computing?");
		qcQ4.setOptions(List.of("A phenomenon where qubits become correlated with each other, regardless of the distance between them", "A type of quantum error that causes decoherence", "A quantum algorithm for database search", "A hardware component of a quantum computer"));
		qcQ4.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ4);

// Question 5
		Question qcQ5 = new Question();
		qcQ5.setQuestion("What is quantum parallelism?");
		qcQ5.setOptions(List.of("The ability of quantum computers to perform multiple calculations simultaneously", "A quantum error correction technique", "A quantum algorithm for optimization problems", "A type of quantum error that causes decoherence"));
		qcQ5.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ5);

// Question 6
		Question qcQ6 = new Question();
		qcQ6.setQuestion("What is decoherence in quantum computing?");
		qcQ6.setOptions(List.of("The loss of coherence or information in a quantum system, leading to errors in calculations", "A quantum algorithm for prime factorization", "A quantum error correction technique", "A measurement device used in quantum experiments"));
		qcQ6.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ6);

// Question 7
		Question qcQ7 = new Question();
		qcQ7.setQuestion("What is a quantum gate?");
		qcQ7.setOptions(List.of("A basic quantum circuit element that operates on qubits to perform quantum operations", "A quantum algorithm for solving linear equations", "A measurement device used in quantum experiments", "A hardware component of a quantum computer"));
		qcQ7.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ7);

// Question 8
		Question qcQ8 = new Question();
		qcQ8.setQuestion("What is quantum supremacy?");
		qcQ8.setOptions(List.of("The theoretical advantage of quantum computers over classical computers for certain tasks", "A type of quantum error that causes decoherence", "A quantum algorithm for cryptographic encryption", "A hardware component of a quantum computer"));
		qcQ8.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ8);

// Question 9
		Question qcQ9 = new Question();
		qcQ9.setQuestion("What is the potential impact of quantum computing on cryptography?");
		qcQ9.setOptions(List.of("It could render many existing cryptographic algorithms insecure due to its ability to quickly factor large numbers", "It would have no impact on cryptography", "It could improve the security of cryptographic algorithms by enhancing key generation", "It could optimize the performance of cryptographic algorithms"));
		qcQ9.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ9);

// Question 10
		Question qcQ10 = new Question();
		qcQ10.setQuestion("What are some current challenges in quantum computing?");
		qcQ10.setOptions(List.of("Scalability, decoherence, and error correction are among the primary challenges", "Quantum computers are already fully mature and face no significant challenges", "Quantum computing has no practical applications", "Quantum computers are not expected to outperform classical computers"));
		qcQ10.setCorrectAnswerIndex(0);
		quantumComputingQuestions.add(qcQ10);

		quantumComputingQuiz.setQuestions(quantumComputingQuestions);
		quantumComputingQuiz.setCreatedAt(new Date());

// You can save the 'quantumComputingQuiz' object to your repository here
		quizRepo.save(quantumComputingQuiz);

		// Data for Quiz questions
		Quiz uxDesignQuiz = new Quiz();
		uxDesignQuiz.setCourseId(11); // Assuming the courseId for "User Experience Design Fundamentals" is 11

// Define questions and answers
		List<Question> uxDesignQuestions = new ArrayList<>();

// Question 1
		Question uxQ1 = new Question();
		uxQ1.setQuestion("What is User Experience (UX) design?");
		uxQ1.setOptions(List.of("The process of creating products that provide meaningful and relevant experiences to users", "The process of optimizing websites for search engines", "A programming language for web development", "The process of designing user interfaces"));
		uxQ1.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ1);

// Question 2
		Question uxQ2 = new Question();
		uxQ2.setQuestion("What is the primary goal of UX design?");
		uxQ2.setOptions(List.of("To enhance user satisfaction by improving the usability, accessibility, and pleasure provided in the interaction with a product", "To increase website traffic", "To minimize development costs", "To create visually appealing designs"));
		uxQ2.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ2);

// Question 3
		Question uxQ3 = new Question();
		uxQ3.setQuestion("What is a persona in UX design?");
		uxQ3.setOptions(List.of("A fictional character created to represent a user type that might use a product in a similar way", "A type of graphic element used in user interfaces", "A programming language for web development", "A type of user interaction pattern"));
		uxQ3.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ3);

// Question 4
		Question uxQ4 = new Question();
		uxQ4.setQuestion("What is wireframing in UX design?");
		uxQ4.setOptions(List.of("A visual representation of a website or app's layout, focusing on content and functionality", "A technique for testing user interfaces with actual users", "A programming language for web development", "A method for tracking user behavior on websites"));
		uxQ4.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ4);

// Question 5
		Question uxQ5 = new Question();
		uxQ5.setQuestion("What is usability testing?");
		uxQ5.setOptions(List.of("A method for evaluating a product by testing it with representative users", "A technique for optimizing website performance", "A programming language for web development", "A process for creating user personas"));
		uxQ5.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ5);

// Question 6
		Question uxQ6 = new Question();
		uxQ6.setQuestion("What is the purpose of prototyping in UX design?");
		uxQ6.setOptions(List.of("To create a preliminary version of a product for testing and evaluation", "To optimize website rankings on search engines", "To analyze user behavior on websites", "To design visual interfaces"));
		uxQ6.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ6);

// Question 7
		Question uxQ7 = new Question();
		uxQ7.setQuestion("What is the difference between UI (User Interface) design and UX (User Experience) design?");
		uxQ7.setOptions(List.of("UI design focuses on the look and feel of the product's interfaces, while UX design encompasses the overall experience of the user", "UI design is the same as UX design", "UI design is less important than UX design", "UI design deals only with visual aspects, while UX design focuses on functionality"));
		uxQ7.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ7);

// Question 8
		Question uxQ8 = new Question();
		uxQ8.setQuestion("What is accessibility in UX design?");
		uxQ8.setOptions(List.of("The practice of designing products that can be used by people with a wide range of abilities and disabilities", "The process of optimizing websites for search engines", "A programming language for web development", "The process of designing visual interfaces"));
		uxQ8.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ8);

// Question 9
		Question uxQ9 = new Question();
		uxQ9.setQuestion("What is information architecture in UX design?");
		uxQ9.setOptions(List.of("The organization and structure of information in products, systems, or websites", "The process of optimizing website performance", "A programming language for web development", "The process of creating visual design elements"));
		uxQ9.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ9);

// Question 10
		Question uxQ10 = new Question();
		uxQ10.setQuestion("What is the importance of user feedback in UX design?");
		uxQ10.setOptions(List.of("User feedback helps designers understand how users interact with products and identify areas for improvement", "User feedback is irrelevant in UX design", "User feedback should only be considered after a product is launched", "User feedback is mainly used for marketing purposes"));
		uxQ10.setCorrectAnswerIndex(0);
		uxDesignQuestions.add(uxQ10);

		uxDesignQuiz.setQuestions(uxDesignQuestions);
		uxDesignQuiz.setCreatedAt(new Date());

// You can save the 'uxDesignQuiz' object to your repository here
		quizRepo.save(uxDesignQuiz);

		// Data for Quiz questions
		Quiz vrExplorationQuiz = new Quiz();
		vrExplorationQuiz.setCourseId(12); // Assuming the courseId for "Exploring Virtual Reality" is 12

// Define questions and answers
		List<Question> vrExplorationQuestions = new ArrayList<>();

// Question 1
		Question vrQ1 = new Question();
		vrQ1.setQuestion("What is Virtual Reality (VR)?");
		vrQ1.setOptions(List.of("A computer-generated simulation of an immersive environment that can be interacted with in a seemingly real way", "A type of augmented reality", "A programming language for web development", "A technique for optimizing website performance"));
		vrQ1.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ1);

// Question 2
		Question vrQ2 = new Question();
		vrQ2.setQuestion("What are some common applications of Virtual Reality?");
		vrQ2.setOptions(List.of("Gaming, training simulations, virtual tours, education, healthcare, and entertainment", "Website development, social media, e-commerce, and email", "Search engine optimization, content marketing, and digital advertising", "Cryptocurrency mining and blockchain technology"));
		vrQ2.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ2);

// Question 3
		Question vrQ3 = new Question();
		vrQ3.setQuestion("What is the difference between immersive and non-immersive VR experiences?");
		vrQ3.setOptions(List.of("Immersive VR fully immerses users in a virtual environment, while non-immersive VR provides a partial or limited virtual experience", "There is no difference between immersive and non-immersive VR experiences", "Immersive VR is cheaper to develop than non-immersive VR", "Non-immersive VR is more popular than immersive VR"));
		vrQ3.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ3);

// Question 4
		Question vrQ4 = new Question();
		vrQ4.setQuestion("What is the purpose of VR headsets?");
		vrQ4.setOptions(List.of("To provide users with a visual and auditory immersion in virtual environments", "To optimize website performance", "To track user behavior on websites", "To create visual interfaces"));
		vrQ4.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ4);

// Question 5
		Question vrQ5 = new Question();
		vrQ5.setQuestion("What are haptic devices in VR?");
		vrQ5.setOptions(List.of("Devices that provide tactile feedback to users, enhancing the sense of immersion in virtual environments", "Devices for visualizing data in VR", "Devices used for tracking user movement in VR", "Devices for rendering graphics in VR"));
		vrQ5.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ5);

// Question 6
		Question vrQ6 = new Question();
		vrQ6.setQuestion("What is the concept of presence in VR?");
		vrQ6.setOptions(List.of("The feeling of being physically present in a virtual environment, despite knowing it's not real", "The process of optimizing website performance", "The process of designing visual interfaces", "The ability to interact with virtual objects in a realistic way"));
		vrQ6.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ6);

// Question 7
		Question vrQ7 = new Question();
		vrQ7.setQuestion("What is locomotion in VR?");
		vrQ7.setOptions(List.of("The method by which users navigate and move within virtual environments", "The process of optimizing website performance", "The process of creating visual design elements", "The ability to interact with virtual objects in a realistic way"));
		vrQ7.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ7);

// Question 8
		Question vrQ8 = new Question();
		vrQ8.setQuestion("What are some challenges of VR development?");
		vrQ8.setOptions(List.of("Motion sickness, hardware limitations, content creation, and user experience design are among the challenges", "VR development has no significant challenges", "VR development is cheaper and easier than traditional software development", "VR development is primarily focused on gaming applications"));
		vrQ8.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ8);

// Question 9
		Question vrQ9 = new Question();
		vrQ9.setQuestion("What is the role of VR in education?");
		vrQ9.setOptions(List.of("To provide immersive and interactive learning experiences, allowing students to explore concepts in a virtual environment", "To optimize website performance", "To track user behavior on websites", "To create visual interfaces"));
		vrQ9.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ9);

// Question 10
		Question vrQ10 = new Question();
		vrQ10.setQuestion("What is the future potential of VR technology?");
		vrQ10.setOptions(List.of("To revolutionize various industries, including entertainment, healthcare, education, and training", "VR technology has no significant future potential", "VR technology is limited to gaming applications", "VR technology will be replaced by augmented reality (AR)"));
		vrQ10.setCorrectAnswerIndex(0);
		vrExplorationQuestions.add(vrQ10);

		vrExplorationQuiz.setQuestions(vrExplorationQuestions);
		vrExplorationQuiz.setCreatedAt(new Date());

// You can save the 'vrExplorationQuiz' object to your repository here
		quizRepo.save(vrExplorationQuiz);

		// Data for Quiz questions
		Quiz ibmZXploreQuiz = new Quiz();
		ibmZXploreQuiz.setCourseId(13); // Assuming the courseId for "IBM Z Xplore" is 13

// Define questions and answers
		List<Question> ibmZXploreQuestions = new ArrayList<>();

// Question 1
		Question ibmZQ1 = new Question();
		ibmZQ1.setQuestion("What is IBM Z?");
		ibmZQ1.setOptions(List.of("IBM Z is a family of mainframe computers designed and manufactured by IBM", "IBM Z is a programming language", "IBM Z is an operating system", "IBM Z is a cloud computing platform"));
		ibmZQ1.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ1);

// Question 2
		Question ibmZQ2 = new Question();
		ibmZQ2.setQuestion("What are some key features of IBM Z mainframes?");
		ibmZQ2.setOptions(List.of("High security, reliability, scalability, and performance are among the key features of IBM Z mainframes", "Low cost, low power consumption, and ease of maintenance", "Compatibility with legacy systems and simplicity of operation", "Real-time data processing and advanced analytics capabilities"));
		ibmZQ2.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ2);

// Question 3
		Question ibmZQ3 = new Question();
		ibmZQ3.setQuestion("What is the purpose of IBM Z mainframes?");
		ibmZQ3.setOptions(List.of("IBM Z mainframes are used for mission-critical applications, such as banking, finance, healthcare, and government services", "IBM Z mainframes are used for gaming and entertainment", "IBM Z mainframes are used for web development", "IBM Z mainframes are used for scientific research"));
		ibmZQ3.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ3);

// Question 4
		Question ibmZQ4 = new Question();
		ibmZQ4.setQuestion("What is Parallel Sysplex in IBM Z?");
		ibmZQ4.setOptions(List.of("Parallel Sysplex is a clustering technology that allows multiple IBM Z systems to work together as a single, highly available and scalable computing environment", "Parallel Sysplex is a programming language", "Parallel Sysplex is a database management system", "Parallel Sysplex is a virtualization platform"));
		ibmZQ4.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ4);

// Question 5
		Question ibmZQ5 = new Question();
		ibmZQ5.setQuestion("What is the IBM Z Integrated Information Processor (zIIP)?");
		ibmZQ5.setOptions(List.of("The zIIP is a specialty engine designed to offload specific processing workloads from the general-purpose processors in IBM Z mainframes", "The zIIP is a high-speed networking interface", "The zIIP is a database management system", "The zIIP is a virtualization platform"));
		ibmZQ5.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ5);

// Question 6
		Question ibmZQ6 = new Question();
		ibmZQ6.setQuestion("What is z/OS?");
		ibmZQ6.setOptions(List.of("z/OS is the primary operating system for IBM Z mainframes", "z/OS is a programming language", "z/OS is a database management system", "z/OS is a cloud computing platform"));
		ibmZQ6.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ6);

// Question 7
		Question ibmZQ7 = new Question();
		ibmZQ7.setQuestion("What is IBM Z Virtualization?");
		ibmZQ7.setOptions(List.of("IBM Z Virtualization is a technology that allows multiple virtual servers to run on a single physical IBM Z system, improving resource utilization and flexibility", "IBM Z Virtualization is a networking protocol", "IBM Z Virtualization is an encryption algorithm", "IBM Z Virtualization is a programming language"));
		ibmZQ7.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ7);

// Question 8
		Question ibmZQ8 = new Question();
		ibmZQ8.setQuestion("What is the IBM Z hardware-based encryption feature called?");
		ibmZQ8.setOptions(List.of("The IBM Z hardware-based encryption feature is called CryptoExpress", "The IBM Z hardware-based encryption feature is called HyperSwap", "The IBM Z hardware-based encryption feature is called Sysplex", "The IBM Z hardware-based encryption feature is called zIIP"));
		ibmZQ8.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ8);

// Question 9
		Question ibmZQ9 = new Question();
		ibmZQ9.setQuestion("What are some advantages of IBM Z mainframes over other computing platforms?");
		ibmZQ9.setOptions(List.of("High security, reliability, scalability, and performance, as well as support for legacy applications, are among the advantages of IBM Z mainframes", "Low cost, low power consumption, and ease of maintenance", "Real-time data processing and advanced analytics capabilities", "Compatibility with mobile devices and cloud services"));
		ibmZQ9.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ9);

// Question 10
		Question ibmZQ10 = new Question();
		ibmZQ10.setQuestion("What is IBM Z System Recovery Boost?");
		ibmZQ10.setOptions(List.of("IBM Z System Recovery Boost is a feature that accelerates system recovery after planned or unplanned outages on IBM Z mainframes", "IBM Z System Recovery Boost is a networking protocol", "IBM Z System Recovery Boost is a programming language", "IBM Z System Recovery Boost is a cloud computing platform"));
		ibmZQ10.setCorrectAnswerIndex(0);
		ibmZXploreQuestions.add(ibmZQ10);

		ibmZXploreQuiz.setQuestions(ibmZXploreQuestions);
		ibmZXploreQuiz.setCreatedAt(new Date());

// You can save the 'ibmZXploreQuiz' object to your repository here
		quizRepo.save(ibmZXploreQuiz);


	}
}



