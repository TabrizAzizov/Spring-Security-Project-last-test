# Student-List-Project
The Student List project is a simple web application that allows users to manage a list of students. Users can add new students, update existing student information, and delete students from the list. The project includes user authentication and authorization using Spring Security, with different user roles that have different levels of access. The project also uses BCrypt to securely store user passwords and connects to a MySQL database using Spring Data JPA for database access and manipulation. The user interface is built using Thymeleaf templates.  It includes the following features:
## Features
* Add new students to the database
* Update student information such as name and student number
* Delete students from the database<br/>
* User authentication and authorization using Spring Security
* Different user roles with different levels of access
* Responsive user interface using Thymeleaf templates
* Secure password storage using BCrypt
* Connection to a MySQL database using Spring Data JPA
## Technologies
* Java Development Kit (JDK) 17 or later
* Apache Maven 3.8.3 or later
* Spring Boot for building the web application
* Spring Security for user authentication and authorization
* BCrypt for secure password storage
* MySQL for the database management system
* Spring Data JPA for database access and manipulation
* Thymeleaf for building the user interface
* HTML, CSS, and JavaScript for web development
* Git and GitHub for version control and collaboration
* IntelliJ IDEA or any other IDE for Java development
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:
* JDK 17+
* Maven 3+
* MySQL database<br/><br/>
To build and run the project, follow these steps:
* Clone the repository:`https://github.com/TabrizAzizov/Student-List-Project.git` 
* Navigate to the project directory: cd student-list-project
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run
* The application will prompt you to login. Use the following default credentials to log in:
* Admin role: Username: admin, Password: 1234
* User role: Username: user, Password: 1235
* The application will be available at http://localhost:8080
