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


