Authorization Service:
----------------------
----------------------

Requirement:         
------------
-Java 8

-Spring Boot

-Maven

-Kafka

-Download Kafka Zip file Unzip it and run below command to start zookeeper and kafka server


kafka_2.12-2.0.0\bin\windows>zookeeper-server-start.bat ..\..\config\zo
okeeper.properties



kafka_2.12-2.0.0\bin\windows>kafka-server-start.bat ..\..\config\server
.properties

Run authorization and user-profile service by using below command

mvn clean install

mvn spring-boot:run

Use Below Url:
--------------
http://localhost:9090/assignment

username:admin

password:admin