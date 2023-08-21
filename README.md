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
java -jar lombok-1.18.28.jar

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

========

class can implement multiple interface [ implements] but can be specialized of only one [extends]

```
interface Comparable {
    int compareTo(Object o);
}
interface Flyable {
    void fly();
}

public class Eagle extends Bird implements Comparable, Flyable {

}
```
Interface Segreggation:

```
interface Swim {
    void swim();
}

interface Dance {
    void dance();
}

interface Fight {
    void fight();
}

class Actor implements Dance {
    // state and behaviour
    public void dance() {
        ...
    }
}

class Hero extends Actor implements Swim, Fight {
    // state and behaviour
    public void swim() {
        ..
    }
    public void fight() {
        ...
    }
}

Fight f = new Fight();

Fight f = new Actor();

Fight f = new Hero();
f.fight();
f.dance();
f.swim();

Dance d = (Dance) f;
d.dance();

```

Exception Handling
Exception ?
try / catch / finally 

==================
Anonymous class and Lambda --> InterfaceExample.java

Generics
```
public class Rectangle {
    int width;
    int breadth;
    //
}

public class DRectangle {
    double width;
    double breadth;
    //
}

public class LinkedList {
    Node[] nodes;
}

class Node {
    int data;
    int prev;
    int next;
}

---
public class Rectangle<T> {
    T width;
    T breadth;
    //
}

Rectangle<Integer> r1 = new Rectangle<>(4,5);

Rectangle<Double> r2 = new Rectangle<>(1.4,3.5);

Rectangle<String> r3 = new Rectangle<>("1 inch","5 cm");

Generics is limited to Object type in Java

Rectangle<int> r1 = new Rectangle<>(4,5); // ERROR

Integer, Double, Float, Long, Short, ... are type wrapper classes for primitive types

int x = 10;
Integer iX = x; // boxing
..
int y = iX; // unboxing
y++;
```

Java Data Containers ===> Java Collection Framework
Array is a datacontainer --> first choice as data container
Limitations --> Size is fixed, adding / remove from arbitrary position, Contiguos memory

JCF has:
1) interfaces
2) implementation classes
3) Utility / Algorithim classes which as methods like sort(), max(), binearySearch(), shuffle(), reverse(), ....

Comparable vs Comparator interface

Common: both are used for Comparision for sort(), max(), min(), ...

Difference:
Comparable --> is part of Object which we are comparing, generally based on PK [ unique field]
Comparator --> logic goes in client application and not in Object [ fields other than PK ]

String --> Comparable compare on lexical ordering
String --> compare based on length ---> Comparator

ByteCode Instrumentation

List is a interface --> JCF
* ordered collection
* index based operations
* supports duplicate elements
* re-order [ shuffle, reverse, sort]

Implementations:
ArrayList
LinkedList
Vector [ legacy ] --> slow because of locking mechanism --> methods are synchronized
Stack [ legacy ] --> slow because of locking mechanism --> methods are synchronized
* Apache collections
* https://www.vavr.io/

ArrayList
* like array but can grow / shrink
* internal mechaism takes care of moving objects if any arbitray add / remove operations

LinkedList
* doubly linkedlist

ArrayList list = new ArrayList(); // avoid this , always program to interface

List list = new ArrayList(); // avoid this, use generics for type-safety
list.add("A");
list.add(new Book());
list.add(3);

if(list.get(i) instanceof String) {
    String s = (String) list.get(i);
}

Prefer:
List<String> names = new ArrayList<>(); // type-safe collection
List<Employee> employees = new ArrayList<>();


Task:
Set, HashSet and TreeSet

java 8 streams:
 streams are wrappers around a data source, allowing us to operate with that data source and making bulk processing convenient and fast.

 HOF --> functions which accept function as argument
 * map() --> transformFn
 * filter() --> based on predicate
 * skip()
 * flatMap()
 * reduce()
 * forEach()
 * collect()

 map(transformFn) {
    list[]
    for( every elem from stream) {
            list.push(transformFn(elem));
    }
    return list;
 }

Terminal functions:
1) forEach()
2) reduce()
3) collect()

Intermediate functions:
1) filter()
2) map()
3) flatMap()
4) skip()
5) limit()

https://rxmarbles.com/

```
1) Filter needs Predicate
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

2) Map needs transform function
public interface Function<T, R> {
     R apply(T t);
}

3) forEach needs Consumer
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```


products.parallelStream()
		.filter(p -> p.getCategory().equals("computer"))
		.map(p -> p.getPrice())
		.reduce((v1,v2) -> v1 + v2);

====

Day 2 Task:
Set, HashSet, TreeSet
Exception Handling
Comments in Java, Naming Conventions

------

Recap: 
interface and its uses.

Comparable, Comparator interfaces
Arrays and Collections utility classes --> sort(), max(), binarySerach(), ...
Arrays can be used on array type of data container
Collections can be used on List type of data container

List interface
* ArrayList
* LinkedList

Iterable : all collections are iterable

```
public interface Iterable<T> {
    Iterator<T> iterator();
}

public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove();
}
List<Product> products = new ArrayList<>();

products.add(new Product(53, "Wacom", 5600.00, "computer"));
products.add(new Product(61, "Sony Bravia", 298000.00, "tv"));
products.add(new Product(891, "Logitech Mouse", 890.00, "computer"));
products.add(new Product(4, "iPhone 14", 78000.00, "mobile"));
products.add(new Product(62, "Oneplus Nord", 56000.00, "mobile"));

Iterator<Product> iter = products.iterator();
while(iter.hasNext()) {
    Product p = iter.next();
    if(condition) {
        iter.remove();
    }
}
```
Set --> unique collection, not ordered, can't be re-ordered

Map is a data container which produces collection; it's a key/value pair
Examples: Dictionary --> key is the word and value is meaning
unique --> key
duplicate --> value

any registry is a Map type of data container

HashCode? --> numerical representation of Object
* similar objects should have same hashcode
* dissimilar objects can also have same hashcode [ collision ]
* Hash based contaniers uses hashcode to find duplicates and positioning of element in container

HashBased containers: HashSet, Hashtable [ legacy ], HashMap


-----

Day 3:
Annotation, Maven, Database interaction and Web application

Metadata can be in the form of XML or Annotation.
java 1.5 introduced Annotation

Annotation: Metadata

1) Who uses it?
* Compiler
* ClassLoader
* Runtime
2) Where can I apply it?
* Type --> class, interface, Enum, Annotation, Record
* method
* field
* parameter
* constructor

built-in annotation --> override

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}

RetentionPolicy.SOURCE --> who uses Source --> Compiler 
Metadata is used by compiler and removes this metadata in .class

```
public class Base {
    public void test() {}
}

public class Derived extends Base {
    @Override
    public void test() {}
}
```

Derived.class won't have annotaion details

===================

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Mobile {
    String name();
}

@Mobile(name="Samsung")
public class CandyCrush extends Game {
    ///
}

@Mobile(name="iphone")
public class CandyCrushPhone extends Game {
    ///
}

javac CandyCrush.java ===> CandyCrush.class [ this class still has @Mobile metadata]

Samsung devices contain there own classloader; these classloader can read this metadata and decide
to allow the class to be loaded on the device or not

==============

Annotations  can't have state and methods, they contain only properties

RUNTIME annotation <-- most of annotations used from today 

We will create 2 annotations
Table and Column

```
@Table(name="books")
public class Book {
    int id;
    String title;
    double price;
    // constructors
    //setters()

    @Column(name="BOOK_ID", type="NUMERIC(10)")
    public int getId() {
        ..
    }

    @Column(name="BOOK_TITLE")
    public String getTitle() {
        ..
    }

     @Column(name="AMOUNT", type="NUMERIC(12,2)")
    public double getPrice() {
        ..
    }
}

books

BOOK_ID  BOOK_TITLE    AMOUNT

```

we will use Annotations to generate SQL for DDL [ create, alter, drop] and DML [insert, select, update, delete]

Property
property = x; // set property
x = property(); // get property

<?> is unknown type --> allows to read, but mutation is not allowed

```
	List<Product> products = new ArrayList<>();

		products.add(new Product(53, "Wacom", 5600.00, "computer"));
		products.add(new Product(61, "Sony Bravia", 298000.00, "tv"));
		products.add(new Product(891, "Logitech Mouse", 890.00, "computer"));
		products.add(new Product(4, "iPhone 14", 78000.00, "mobile"));
		products.add(new Product(62, "Oneplus Nord", 56000.00, "mobile"));

    getData(products);
  
    public void getData(List<?> products) {
        products.get(0); // valid
        products.set(3, new Product()); // fails --> ? allows read operation, but not write
        products.add(new Product()); // fails --> ? allows read operation, but not write
    }
```

String is immutable, use StringBuffer or StringBuilder to mutate a String.

createStatement(Book.class);

==================

Maven / Gradle:
Maven is a build automation tool used primarily for Java projects.
* Manage dependencies --> 3rd party dependency library
* compile
* test
* bundle
* deploy
* start server
...


3rd party dependencies --> "jar" files in repository --> Java Archive

pom.xml --> Project Object Model --> all configuration about dependencies and goals are configured in the pom.xml [ shared to all team member]

pom.xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.1.0</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.28</version>
    </dependency>
</dependencies>

https://repo1.maven.org/maven2/

Maven also manages trasitive dependencies
mysql-connector-j depends on "google protobuf --> GRPC" --> download protobuf.jar with correct version

-------------

JDBC --> Java Database Connectivity --> Integration API for integrating JAVA <---> RDBMS

JDBC provides set of interfaces to perform CRUD operations on RDBMS

implementation classes are provided by database vendors
mysql-connector-j-8.1.0.jar --> MySQL
ojdbc-7.jar --> Oracle

Steps to interact with RDBMS:
1) Load database vendor provided drivers

Class.forName("com.mysql.jdbc.cj.Driver");
Class.forName("oracle.jdbc.Driver");

2) Establish a database connection

java.sql.Connection con = DriverManager.getConnection(URL, USERNAME, PWD);

getConnection() is a factory method; 
if URL points to MySQL --> creates MySQLConnection
if URL points to Oracle --> creates OracleConnection

Connection is a interface

Examples of URL:
jdbc:mysql://192.24.134.11:3306/employee_db
jdbc:oracle:@thin:@192.24.134.11:1521/employee_db
...

3) use Statement, PreparedStatement, CallableStatement to Send SQL to database
3.1) Statement
    use this if SQL is fixed; same SQL for all requests
    Example: select * from products
3.2) PreparedStatement
    use this if SQL depends on IN parameter [?]

    select * from products where id = ?

    insert into products values(?, ?, ?);

4) ResultSet
    is a cursor to fetched records

5) close resources in finally block



Docker is a container to run applications

image --> software
container -> application running image

docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

mysql --> image
run --> pull mysql image from docker hub onto localmachine and run as --name local-mysql <<container>>

-p --> mysql on docker container runs on "3306" port expose it to other application on "3306"

-p 1234:3306 ==> mysql running on "3306" port in container is accessable on "1234" port for other application

====

docker run --name local-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

% docker exec -it local-mysql bash
# mysql -u root -p
Enter password: Welcome123

mysql> create database NCG_DB;

mysql> use NCG_DB;

mysql>  create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);

mysql> insert into products values (0, 'Wacom', 4500.00, 100);
mysql> insert into products values (0, 'Microsoft Mouse', 1500.00, 100);

mysql> select * from products;

executeUpdate() for INSERT, DELETE and UPDATE SQL
executeQuery() for SELECT statement

=============

Web Application development using Java
JSE --> Java Standard Edition --> core java
JEE --> Java Enterprise Edition
* enterprise application ==> large scale, heterogenous clients
* Web application
* Distributed computing
* Naming service
* mail service
...

Dynamic content
ASP engine, PHP engine, Servlet engine

Servlet --> server side java application --> Servlet engine

Servlet engines -> Jetty , Tomcat, Netty, ...


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

}

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

}

http://localhost:1234/register

HttpServletRequest encapsulates all data from client [ client data / form data + Browser + OS]

HttpServletResponse is used to write data back to client

Once Response is commited to client, HttpServletRequest and HttpServletResponse objects are destroyed
and Thread is released back to the pool

Servlet engine manages:
1) creating instance servlet
2) creates HttpServletRequest , HttpServletResponse
3) Dependency injection: HttpServletRequest , HttpServletResponse are passed to appropriate Servlet which has a matching URL
4) Once Response is commited to client, HttpServletRequest and HttpServletResponse objects are destroyed
and Thread is released back to the pool

---------

@WebServlet("/register") --> used to map URL to Servlet

Http Methods:
1) GET --> READ
2) POST --> CREATE
3) PUT --> UPDATE
4) DELETE --> DELETE
5) PATCH --> PARTIAL UPDATE

GET: address bar and hyperlink --> default GET request, no payload
POST: generally FORM data, payload contains user data

POST and PUT/ PATCH contains payload --> NOT SAFE METHODS

GET, DELETE --> No Payload --> SAFE METHODS

IDEMPOTENT 

```

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) {

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        
    }
}

```
GET http://localhost:1234/products

POST http://localhost:1234/products

=========

Servlet engine metadata can be XML or Annotation
Deployment descriptor:

SAXParser
1)
public class ProductServlet extends HttpServlet {}
web.xml
<web>
    <servlet>
        <servlet-name>First</servlet-name>
        <serlvet-class>com.adobe.prj.web.ProductServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>First</servlet-name>
        <url-pattern>/products</url-pattern>
    </servlet-mapping>
</web>

2) Annotation

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
}




				

        <dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<version>6.0.0</version>
		</dependency>

Day 4

Reacap: Database connectivity ==> JDBC [ integration API]

Java <---> RDBMS

java.sql package --> interfaces
implementation classes are provided by database vendors [jar file]
Class.forName(), DriverManager, Statement, PreparedStatement, ResultSet
finally block ---> to release resources [ like close file, connection, socket]

Task: getProduct by Id, update Statement.

Web application development using Servlet technology.

Web Server : which works on Request / Response based on HTTP protocol

Servlet engine / web container [ Tomcat / Jetty / Netty / ..]
these engines manages life-cycle of object
Things what Servlet engine does:
1) instantiate Servlets --> Singleton object
2) instantiate HttpServletRequest and HttpServletResponse per request from client
3) handle DI: inject HttpServletRequest and HttpServletResponse objects to HttpServlet
4) destroys HttpServletRequest and HttpServletResponse when response is commited to client
5) Manage Thread pool and assign one thread per client request.
6) Once response is commited, threads are released back to the pool.


Converting Standalone application to web application.

packaging: war ==> Web archive [ only "war" files are deployable on Servlet engine]

packaging can be "jar", "war", "ear", "sar" 

War and jar

for "jar" compiled code will be in "bin" folder
for "war" compiled code will be in "WEB-INF/classes" folder
"war" also contains static resources like "html", "css" and "js"

1) <packaging>war</packaging>
2) need Servlet API [ classes with "HttpServlet", "HttpServletRequest", ...]
 <dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<version>6.0.0</version>
</dependency>
3) We need "war" plugin
<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-war-plugin</artifactId>
					<version>3.4.0</version>
					<configuration>
						<failOnMissingWebXml>false</failOnMissingWebXml>
					</configuration>
				</plugin>

4) Embedded Jetty Server instead of installing a Servlet engine explicitly
<!-- embedded JETTY server -->
				<plugin>
					<groupId>org.eclipse.jetty</groupId>
					<artifactId>jetty-maven-plugin</artifactId>
					<version>11.0.15</version>
				</plugin>

Save "pom.xml" --> application should update, else Project --> Maven --> Update Project --> Force Update

src / main / webapp folder --> static resources are created here.

src/main/java --> servlets are created.

Project --> Run As --> Maven build --> Goals
jetty:run


http://localhost:8080

==============================

Spring Framework
Lightweight Container with Dependency Injection capabilities for building enterprise application.

Bean: any object managed by spring container --> bean

* Life-cycle management of beans
* Wires dependencies using Inversion Of Control

UI --> service --> DAO --> Database

Advantages: Loose Coupling and easy to test

Spring Framework instantiates classes which has one of these annotations:
1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController
7) @ControllerAdvice


public interface EmployeeDao {
    void addEmployee(Employee e);
}

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
     public void addEmployee(Employee e) {...}
}
Spring creates instance of EmployeeDaoJdbcImpl as "employeeDaoJdbcImpl"

@Service
public class AppService {
    @Autowired
    private EmployeeDao empDao; // interface
}
Spring creates instance of AppService as "appService"
employeeDaoJdbcImpl is wired to appService instance

@Controller
public class EmployeeController {
     @Autowired
    private AppService service; 
}
Spring creates instance of "EmployeeController" as "employeeController"
appService is wired employeeController instance

Eclipse --> Help --> Eclipse Martket Place --> Search "STS" --> GO --> install Spring Tools 4

Spring Boot Framework on top of Spring Framework

Spring Boot is highly opiniated Framework.
1) If we choose to connect to RDBMS, Spring Boot provides DataSource out of the box --> Pool of database connection

Use DataSource instead of DriverManager.getConnection() in enterprise application

Latency in opening and closing connection if  DriverManager.getConnection() is used

2) If we choose to build web application --> Tomcat Embedded WebServer is configured out of the box.

3) RESTful: Java <--> JSON library [Jackson] is provided out of the  box

--------
SpringApplication.run() starts the Spring Container

@SpringBootApplication is made of 3 features:
1) @ComponentScan
    scans for above mentioned 7 annotations and creates instance of classes
2) @EnableAutoConfiguration
    this takes care creating "DataSource", "EmbeddedTomcatContainer", "Jackson", ... based on type of project
3) @Configuration

-----------
```

Bean: -> Any object which is managed by spring container is a bean.
employeeDaoMongoImpl


Field employeeDao in com.adobe.prj.service.AppService required a single bean, but 2 were found:
	- employeeDaoJdbcImpl
	- employeeDaoMongoImpl

Solution 1:
1) @Primary
@Primary
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

2) @Qualifier
@Repository
public class EmployeeDaoMongoImpl implements EmployeeDao {

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

@Service
public class AppService {
	@Autowired
	@Qualifier("employeeDaoJdbcImpl")
	private EmployeeDao employeeDao; // interface

3) Based on Profile

@Profile("prod")
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {


@Profile("dev")
@Repository
public class EmployeeDaoMongoImpl implements EmployeeDao {

Run As --> Run configuration --> Arguments
Program arguments
--spring.profiles.active=prod

```

Factory Method in Spring?
1) We might need to instantiate objects of classes provided by 3rd party library which won't have any of the above mentioned "7" annotations
Spring has to mange the instance

2) Generally Spring uses default constructor for creating instances of class; sometimes we might need to pass our own values to constructor for creating instances.

=============
JPA and ORM

ORM --> Object Relational Mapping [ Java Object <----> RDBMS table, Java Fields <---> table columns]
ORM Frameworks:
1) Hibernate
2) Toplink
3) KODO
4) JDO
5) openJPA
6) EclipseLink
...

ORM Frameworks help in DDL and DML operations based on Mapping

JPA --> Java Persistence API is a specification for ORM [ think interfaces for ORM]

EntityManager em;

public void addProduct(Product p) {
    em.persist(p);
}

public List<Product> getProducts() {
    Query query = em.createQuery(Product.class);
    return query.getResultResult();
}

===

PersistenceContext: Environment where entities [@Entity] are managed [ sync with DB]
EntityManager is a class which manages PersistenceContext environment.
EntityManager uses db connection from db pool [ DataSource] and uses provided JPAVendor[ Hiberate/ Toplink/ OpenJPA]

===

Spring Data Jpa ==> Simplifies using ORM;
Spring Data Jpa which comes with Spring Boot; highly opinated
* Creates DataSource --> Pool of database connection using HikariCP using configurations persent in application.properties [ DRIVER, URL, USERNAME, PWD]
* uses Hibernate by default as ORM --> JPAVendor
* just create interface; implementation classes are created by Spring Data JPA
Example:
```
public interface ProductDao extends JpaRepository<Product, Integer> {
}

public interface CustomerDao extends JpaRepository<Customer, String> {
}
```
No need for @Repository class if JPA is used with Spring Data Jpa
Basic CRUD operations are created by class which inturn implements this interface.

New Spring boot starter project:
Screen 1:
groupId
artifactId
version
package

Next>>
Screen 2:
lombok, MySQL Driver, Spring Data Jpa

-----

Setup database details in application.properties [ src/main/resources]

to learn about which key to use --> look into global application.properties of spring boot

https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

1) ORM generates SQL, we need to tell ORM to generate SQL for MySQL
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

2) spring.jpa.hibernate.ddl-auto=update
update --> Map java class to existing table or if table is not present create it, if required alter
create -> drop table on application exist, create it when application starts
validate --> check if classes matches with existing table, if doesn't match application fail

3) spring.jpa.show-sql=true
logging SQLs generated

---

Only classes which has @Entity is managed by ORM/JPA
@Id --> to mark as PRIMARY KEY
@GeneratedValue(strategy = GenerationType.IDENTITY) ---> AUTO INCREMENT


