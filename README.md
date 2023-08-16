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
visibility : public, private, protected and default scope

```
Book.java

public class Book {
    private String title; // state, instance varible
    private double price; // state, instance varible

    public void setTitle(String t) {
        this.title = t;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }
}

javac Book.java ---> Book.class [ bytecode]

Example.java
public class Example {
    public static void main(String[] args) {
        Book java = new Book();
        java.setTitle("Head First Java");
        java.setPrice(560.00);

        Book react = new Book();
        react.setTitle("React Unleashed");
        react.setPrice(890.00);

        System.out.println(java.getTitle() + ", " + java.getPrice());
    }
}

javac Example.java ---> Example.class

Java Compiletime Environment

Java Runtime Environment

Classloader
Default classloader, Network based classloader, Custom Classloader [ CISCO settop box, Samsung Harman, ..]

bytecode from secondary storage to primary storage
Search in current folder or CLASSPATH [ environment variable]
set classpath=.;/users/banuprakash/code;/users/banprakash/project

* findLoadedClass()
* loadClass()
* findSystemClass() --> platform has APIs loaded
* defineClass()

java Example 
1) check Example.class if already present in JVM
2) NO --> loadClass() is exectuted
3) String.class --> findLoadedClass() --? false --> loadClass() --> false --> findSystemClass() --> load into JVM

4) load Book.class ---> loadClass()
5) System.class --> findSystemClass()

Around 132+ files are loaded into JVM

defineClass() ---> convert bytecode to system specific code [ architecture/os]

bytecode --> Metaspace / Method Area [prior to java 8]

-----
java.setTitle("Head First Java"); 
setTitle(java, "Head First Java"); // context becomes implicit first argument


public void setTitle(String t) {
        this.title = t;
}
becomes

public void setTitle(Book this, String t) {
        this.title = t;
}

java.getTitle() ==> on stack getTitle(Book this) {} ==> "this" --> context here is "java"

```

Logically grouping of class for enterprise application
* entity class / domain class / model class
business data, data is long lived beyond the life of application 
they are used to map to persist store [ RDBMS / NoSQL / File ...]
example:
One entity Object maps to one table of RDBMS or Collection of MongoDB
java fields --> map to columns of database table
-> Uber application: Customer, Driver, Vehicle, Trip, Payment
-> Swiggy: Customer, Product, Order, LineItem , ShipAddress, Payment, Supplier

these classes are the simplest to create: --> no CRUD operations, no business logic,
generally they only contain getters / setter

* DAO --> Data Access object
perform CRUD operations
--> RDBMS : insert, select, update and delete SQL

* Business 
* Service 
--> facade over DAO and business logic
--> generally they contain atomic operations and make coarse grained operations over DAO fine grained operations

* Exception classes --> to represent any abnormal condition
* Utility classes --> Helpers
* UI --> User interface / client code

---

Package --> folders for different types of logically grouped classes.

DAO vs Service
```
public class AccountDao {
    updateAccount(..)
    createAccount(..)
    deleteAccount(..)
    lockAccount(..)
    getBalance()
    getTransactions()
}

public class CustomerService {
    AccountDao accountDao = new AccountDao();

    // this code should be Atomic in nature
    public void transaction(Account from, Account to, double amt) {
        getBalance();
        run logic to check balance --> sufficient
        updateAccount(from);
        updateAccount(to);
        insertIntoTxTable(..);
        sendSMS();
    }
}

Client calls transaction() one call which in turn has many fine grained operations

public class ManagerService {
     AccountDao accountDao = new AccountDao();

    createAccount() {
        accountDao.createAccount()
    }

    lockAccount()...
}
```