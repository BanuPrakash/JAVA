# Java Boot camp from 16th - 23rd August

Banuprakash C

Full Stack Architect, 

Co-founder & CTO of Lucida Technologies Pvt Ltd., 

Corporate Trainer,

Email: banuprakashc@yahoo.co.in; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/JAVA

===================================

Softwares Required:
1) JDK 17:
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
OR  
openJDK 17
https://jdk.java.net/java-se-ri/17

2) Eclipse for JEE  
    https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-enterprise-java-and-web-developers

Lombok
Download:
https://repo1.maven.org/maven2/org/projectlombok/lombok/1.18.28/lombok-1.18.28.jar
install:
java -jar lombok.1.18.28.jar

3) MySQL  

Install Docker Desktop
https://www.docker.com/products/docker-desktop/

MySQL installation on Docker steps:

```
a) docker pull mysql

b) 
For Windows:
docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit
```

OOP 
* Real world
* Object --> State and Behaviour
Object first approach
Blue print / Prototype to create object
class [Java / C++ / TypeScript], function [ JS ], Type

class Tv {
    int volume;
}

function Tv (volume) {
}

Type Tv
End Type

---------

SOLID design Principle
S --> Single Responsibility
Object to perform CRUD operations [ CREATE / READ/ UPDATE/ DELETE] --> File / DB / NOSQL
Object for UI
Object for Business logic

O --> Open Close Principle [ Closed for Change and Open for Extension]
L --> Liskov Substitution Principle
I --> Interface segregation
D --> Dependency Injection

-----------------

Java: Technology
Platform to execute bytecode [ portable ]

ByteCode

Source Code ===> Compiled ===> ByteCode
JDK         ==> Java Compiler ==> bytecode
KDK [ Kotlin] ==> Kotlin Compiler ==> bytecode
Groovy DK ==> Groovy Compliler ==> bytecode

============================

