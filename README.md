
# P_015 - DigiMedArchive

### Prerequisites
1. JDK version >= 8
2. MySQL

### Steps to run
1. Open a MySQL console in the terminal

    ```bash
    mysql -u <your-username> -p <your-password>
    ```

2. Create a database called "medarchive"
	
	```mysql
	CREATE DATABASE medarchive;
	```
	
3. Open the `application.properties` file located in `src/main/resources` and add your MySQL username and password like this:

    ```properties
    spring.datasource.username=<your-username-here>
    spring.datasource.password=<your-password-here>
    ```

4. Either run the main function in `src/main/java/dev/ayushm/med/Application.java ` in eclipse OR, 

    1.  Open a terminal in the root of the project

    2.  Run the following commands to build a jar file and then run it

        -   on Windows

            ```bash
            .\mvnw clean install
            java -jar target\medarchive.jar
            ```

        -   on Linux and Mac

            ```bash
            ./mvnw clean install
            java -jar target/medarchive.jar
            ```

5. Open `localhost:8080` in your browser. 

