Project Name: Employee Management Web App

Installation:
- Download whole project file from this git repo
- Require Java 17 or latest
- Require MySQL database constructed

MySQL database configurations:
- Create database named as: employee_management_system
- Create a table named as: employees
- Create 3 fields: firstName, lastName, emailId
- Change the jdbc settings in src\main\resources\application.properties file to connect localhosted MySQL database

Run the App:
- Through terminal:
  - Go to project directory
  - Run: mvn spring-boot:run
- Through IDE:
  - Import project to IDE
  - Run EmployeeApplication.java
- Then, user can access the data by enter this url "http://localhost:8080/api/v1/employees". User will see json response through the link.

Documentation on endpoints:
- Obtain all employee records through Get request
  - http://localhost:8080/api/v1/employees
- Create an employee record through Post request
  - http://localhost:8080/api/v1/employees
- Obtain a single employee record through Get request
  - http://localhost:8080/api/v1/employees/{id}
- Update a single employee record through Put request
  - http://localhost:8080/api/v1/employees/{id}
- Delete a single employee record through Delete request
  - http://localhost:8080/api/v1/employees/{id}

- Json payload sample:
{
    "firstName": "employee first name",
    "lastName": "employee last name",
    "emailId": "employee email"
}
