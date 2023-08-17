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

Packages:
1) logically group classes
2) avoid collusions usage classes with same name --> by using fully qualified name
Example:
java.util.Date [ Date is a class in "java.util" package]
java.sql.Date [ Date is a class in "java.sql" package]


All instance variables [Heap area] will have it's default values in heap area when created.
int, short, byte, long --> 0
double/float --> 0.0
char --> Null character
object --> NULL
boolean --> false

No Garbage / junk data in heap area

All local variables [ in stack ] should be initialized before using

How many instances of Account are created?
count variable

=====================

Task 1:
```
package com.adobe.prj.entity;
Time.java

public class Time {
    private int hours;
    private int min;
    // constructors
    // getters and setters
    // other methods
}


package com.adobe.prj.client
TimeClient.java

public class TimeClient {
    public static void main(String[] args) {
        Time t1 = new Time(4,30);
        Time t2 = new time(3,45);

        Time t3 = Time.add(t1, t2);

        System.out.println( t3.getHours() + " : " + t3.getMin()); // 8:15
        System.out.println( t1.getHours() + " : " + t2.getMin()); // 4:30
        System.out.println( t1.getHours() + " : " + t2.getMin()); // 3:45

        Time t4 = t1.add(t2);
        System.out.println( t4.getHours() + " : " + t4.getMin()); // 8:15
        System.out.println( t1.getHours() + " : " + t2.getMin()); // 4:30
        System.out.println( t1.getHours() + " : " + t1.getMin()); // 3:45
    }
}

```

Class & Object
instance variables --> heap area, created for every object --> initialized with default values
static variable --> Metaspace, created per class --> initialized with default values
local variable --> stack --> need to initialize before we use

instance method --> called with object context, first argument is implicit "this" --> context
static method --> called with class contenxt, no implicit "this" is passed as argument

--------

Relationship between objects:
1) Generalization and Specialization
2) Realization
3) Association
4) Uses A

Generalization and Specialization relationship --> Inheritance

Java build tools:
1) Maven / Gradle --> manage dependencies, compile, deploy, ...
2) SonarQube or [Checkstyle / PMD / findBugs] --> static code analyis
Checkstyle: naming conventions, comments
PMD or FindBugs: Good programming practice [ find duplicate code [ Copy & Paste code], unreachable code, bad exception handling, empty catch blocks, ...]
3) Jenkins: CI / CD
4) JUNIT: Testing framework for Unit testing
...

```
Constructor behaviour in inheritenace
// Product inheritance from Object [ implicit]
public class Product {
    Product() {
        s.o.p("P1");
    }

    Product(int id, String name, double price) {
        s.o.p("P2");
    }
}

public class Mobile extends Product {
    Mobile() {
        s.o.p("M1");
    }

    Mobile(int id, String name, double price, String connectivity) {
        s.o.p("M2");
    }
}

new Mobile(); // Object(), Product(), Mobile() ==> P1, M1
new Mobile(331, "iPhone 14", 89000.00, "4G"); ==> Object(), Product(),  Mobile(int id, String name, double price, String connectivity) ==> P1, M2

```

How methods work in inheritance

```
public class Product {
   public  double getPrice() {
    return 1000;
   }
}

public class Mobile extends Product {
    // override
   public double getPrice() {
    return 9999;
   }

   public String getConnectivity() {
    return "5G";
   }
}


public class Tv extends Product {
    public double getPrice() {
        return 5555;
    }
}
Mobile m = new Mobile();
m.getPrice(); // 9999
m.getConnectivity();  // 5G

Product p = new Mobile();
p.getPrice(); // 9999
p.getConnectivity(); // ERROR

p = new Tv();
p.getPrice(); // 5555
```

All instance methods in Java are virtual by default --> dynamic binding

Prefer:
"4G".equals(connectivity) --> true or false
over
connectivity.equals("4G") --> true/false and can result in NullPointerException

instanceof vs getClass()

Product p = new Tv();

p instanceof Tv ==> true
p instanceof Product ==> true
p instanceof Object ==> true
p instanceof Mobile ==> false

p.getClass() =====> Tv.class

p.getId(); ==> context is "object" when method name is know in advance
p.getPrice();

===

Day 2

Recap: OOP, SOLID design principle, instance and static variables and methods

Generalization and Specialization relationship --> inheritance "extends" in java

* java.lang.Object is the root class for every object
* Java doesn't support multiple inheritance [ extends A, B is not allowed]
* override [ specialized class is going to suppress existing behaviour with new behaviour]
* overload --> look into it. ==> based on arguments different methods are called

To SalesGuy: I want to buy a Product?
:-( 
Which Product

To Manager: I need to open a Account?
:-(
SA/CA/LA ?


abstract class --> can't instantiate abstract class --> too generic, doesn't exist in real world. meant only for pushing common state and behaviour in generalized class

abstract method --> can't provide logic, specialized ones should compulsorily override and provide appropriate logic.

====

Realization Relationship
One Element (client) realizes the behaviour that the other element (supplier) specifies.
Program to Contract

in Java we implement this relationship with "interface"

```
interface EmployeeDao {
    void addEmployee(Employee e); // methods are public and abstract by default
    Employee getEmployee(int id);
}

public class EmployeeDaoDbImpl implements EmployeeDao {
    // state and behaviour
    public void addEmployee(Employee e) {
        INSERT INTO ...
    }
    public Employee getEmployee(int id) {
        SELECT * from ...
    }
}


public class EmployeeDaoMongoDbImpl implements EmployeeDao {
    // state and behaviour
    public void addEmployee(Employee e) {
        db.employees.insert({...})
    }
    public Employee getEmployee(int id) {
        db.employees.findBy({...});
    }
}

public class AppService {
    EmployeeDao employeeDao = new EmployeeDaoMongoDbImpl();

    public void insert(Employee e) {
        employeeDao.addEmployee(e);
    }

    public Employee fetch(int id) {
        return employeeDao.getEmployee(id);
    }
}

```

Why Program to Interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING
6) OCP

you can't instantiate a interface like abstract class.

ClassLoader loads Book.class and Author.class into JVM metaspace
Book b; 
Author a;

If we know class name in advance: new ClassName();

If we don't know class name in advance, how to create object?
variable = "java.lang.String";
variable = "com.adobe.prj.entity.Book";

Class.forName(variable).getDeclaredConstructor().newInstance();

====
package java.lang;
public interface Comparable {
    public int compareTo(Object o);
}


"Scarlett".compareTo("Angelina"); > 0

Circle c1 ---
Circe c2 ---
c1.compareTo(c2) --> 0

Each of these classes like Circle, Rectangle, String should realize Comparable


