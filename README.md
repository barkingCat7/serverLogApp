Spring Boot Log Parsing Application

Database settings are in application.properties
Schema and data are in logapp.sql
SQL queries are in queries.sql

Application can be run from command line using these parameters, for example:
java -jar target/serverLogApp-0.0.1-SNAPSHOT.jar --accesslog=/access.log --startDate=2017-01-01.13:00:00 --duration=daily --threshold=250