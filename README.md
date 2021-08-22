# Address Book
__Description__

This is a sample back-end API to handle Address book related query and mutation
requests.

<p>
The application has been built using Springboot, Java and GraphQL.
</p>
<p>
The application uses H2 database and the flyway script to load initial data used in the application can be found
in the file data.sql
</p>

__Build__
<br>To build the executable Jar, run the following maven command in the project root directory:<br>
``$ mvn clean package``

It will create a jar address-book.jar in <project root>/target directory.<br>

<br>To run the program:<br>

``$ mvn spring-boot:run``
