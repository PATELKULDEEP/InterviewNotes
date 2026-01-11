# **OOPs Piller**

**Encapsulation** : is about data hiding and binding data with behavior. We achieve it using private fields and public getters/setters.
For example, in an Employee class, fields like id, name, and salary are private and accessed via getters/setters to control validation.  

**Inheritance** : allows code reuse by extending a parent class.
For example, a base User class can be extended by Employee and Customer to reuse common fields like id and email.

**Polymorphism** : allows the same method to behave differently based on the object.
Example: calculateSalary() implemented differently for PermanentEmployee and ContractEmployee.

**Abstraction** : hides implementation details and exposes only behavior.
We achieve this using abstract classes and interfaces. Abstract classes can have both abstract and concrete methods, while interfaces provide full abstraction (with default/static methods since Java 8).

## Class 
A class is a blueprint or template that define properties(variables) and behaviors(methods).


# Java 8 Features
Java 8 mainly introduced support for functional-style programming in Java. The key features include lambda expressions and Stream API, which help write cleaner, more readable, and efficient code.

Java 8 also enhanced interfaces by adding default and static methods to maintain backward compatibility, so existing implementations don’t break when new methods are added.

Another important feature is the Optional class, which helps handle null values more safely by forcing explicit null checks.
Java 8 also introduced a new Date and Time API, and it brought performance improvements such as parallel streams and better internal optimizations. 

# Java 17 Features
Java 17 is a Long-Term Support version of Java that focuses on performance, security, and language improvements. It introduces features like sealed classes to control inheritance, pattern matching improvements to simplify code, and records to reduce boilerplate code for data objects.

Java 17 also includes strong encapsulation of internal APIs, better garbage collection performance, and several JVM optimizations that make applications more secure and efficient.

## Java 8 -> Java 17
1. Upgrade the JDK 
2. javax.* to jakarta.*
3. Update Spring Boot and Hibernate
4. 

## Wrapper Class
Wrapper class create object of primitive data type as collection work on objects and not primitive data type.


### Comparable vs Comparator
Comparable is usally used inside a class.
Where as Comparator is called outside the class seprately whenever it's require.
so, for custom sorting and multiple fields sorting require we use comparator and when just a simple sorting is require we use comparable


# **SOLID**
There is a set of five principles for writing clean, scalable, maintainable object-oriented code.


# Thread
Threads are used to perform multitasking by allowing a program to execute multiple tasks concurrently.

## Ways to create a Thread
1. Extending the Thread class
2. Implementing Runnable interface in Java

Extending Thread binds our class to single inheritance, so if a class already extends another class, you must use Runnable, which is interface-based and support multiple inheritance.

We use .join like thread.join() to main thread wait for completing this ongoing thread.


## Thread LifeCycle

1. New (Thread Created)
2. Runnable (start() called)
3. Running (CPU executing thread)
4. Waiting/Blocked (sleep, wait, IO)
5. Terminated (run() finished)



## Runnable
Runnable is used to execute task in a separate thread but does not return and can't throw exception.

## Callable
Callable is used to execute task that returns a result and can throw checked exception. 
Callable work with ExecutorService and Future.


## Thread Pool
Thread pool is a group of reusable threads managed by ExecutorService. Instead of creating a new thread every time, tasks are submitted to the pool.
That improves performance.

## Executors Framework

Executor framework helps to manage multiple thread easily without creating and handling them manually.

| Interface                | Purpose                               |
| ------------------------ | ------------------------------------- |
| Executor                 | Executes tasks                        |
| ExecutorService          | Manages lifecycle                     |
| ScheduledExecutorService | Runs tasks after delay / periodically |

**Future** is a blocking way to achieve async results.  
**CompletableFuture** is a non-blocking asynchronous processing with better error handling.

Future Interface: The Future interface represents the result of an asynchronous computation. You can use it to:

Retrieve the result: The get() method blocks the main thread until the task completes and returns the result.

Check the status: Methods like isDone() and isCancelled() help you check if the task is completed or canceled.

Cancel the task: The cancel() method attempts to cancel the task before it finishes.


## Thread Communication
wait, notify, notifyAll
1 producer and multiple consumer then use notifyAll otherwise notify only.

## Thread Starvation
When thread are occupied and task's are waiting for thread to get free that is known as thread starvation.
for that we can use priority queues or separate pools
like if one task which take long time like 10s and another will take 1s then 10s job is occuiped the thread then 1s task is starving to executre it's like that. 

## Lock
**Intrinsic** : These are built into every object of Java. When we are using synchronized keyword we're using automatic lock.

**Explicit** : These are more advanced locks we can control ourself using Lock class from java.util.concurrent.locks. These gives more control. 

Reentrant Lock prevent the deadlock. ReadWrite Lock

## What is volatile
Volatile ensures visibility of changes across threads. 
If one thread updates a variable, other threads see the updated value immediately. Used for flags, status, etc.

Volatile only ensures visibility but can't prevent race conditions.

**Synchronized** ensures both atomicity and visibility using locks, but at a performance cost.

**Atomic** variables provide atomic operations without locks using CAS, making them faster than synchronized for simple operations like counters.

#### **How does immutable helps in multithreading**
As immutable objects can't change state after creation, so multiple threads can safely access the same object without synchronization. This avoids race conditions and makes concurrent code simpler and more reliable.


# Exception Handling



# Design Pattern

## Creational Design Pattern

### Singleton Design Pattern
In certain scenarios like logging, configuration handling or managing database connection we need just one instance to avoid redundancy, excessive memory use or inconsistent behaviour. 

### Factory Pattern


### Abstract Factory


### Builder Pattern


### Prototype Pattern



| Feature               | HashMap    | LinkedHashMap | TreeMap        | Hashtable    | **SynchronizedMap**        | ConcurrentHashMap       | EnumMap        |
| --------------------- | ---------- | ------------- | -------------- | ------------ | -------------------------- | ----------------------- | -------------- |
| Thread-safe           | ❌ No       | ❌ No          | ❌ No           | ✅ Yes        | ✅ Yes                      | ✅ Yes                   | ❌ No           |
| Synchronization level | None       | None          | None           | Method-level | **Method-level (wrapper)** | **Bucket / Node-level** | None           |
| Performance           | ⭐⭐⭐        | ⭐⭐            | ⭐              | ❌ Slow       | ❌ Slow                     | ⭐⭐⭐⭐                    | ⭐⭐⭐⭐           |
| Allows `null` key     | ✅ One      | ✅ One         | ❌ No           | ❌ No         | ❌ No*                      | ❌ No                    | ❌ No           |
| Allows `null` values  | ✅ Yes      | ✅ Yes         | ❌ No           | ❌ No         | ❌ No*                      | ❌ No                    | ❌ No           |
| Maintains order       | ❌ No       | ✅ Yes         | ✅ Sorted       | ❌ No         | ❌ No                       | ❌ No                    | ✅ Enum order   |
| Sorting support       | ❌ No       | ❌ No          | ✅ Comparator   | ❌ No         | ❌ No                       | ❌ No                    | ✅ Enum ordinal |
| Fail-fast iterator    | ✅ Yes      | ✅ Yes         | ✅ Yes          | ❌ No         | ❌ No                       | ❌ No                    | ✅ Yes          |
| Legacy class          | ❌ No       | ❌ No          | ❌ No           | ✅ Yes        | ❌ No                       | ❌ No                    | ❌ No           |
| Introduced in         | Java 1.2   | Java 1.4      | Java 1.2       | Java 1.0     | Java 1.2                   | Java 1.5                | Java 5         |
| Underlying DS         | Hash table | Hash + DLL    | Red-Black Tree | Hash table   | Depends on Map             | Hash table              | Array          |




## Eager v/s Lazy

**Eager** : When we are doing things before it require like database connections if application is going to use later or not we have started.
Resource is utilizing here which can be waste but there will be no delay if require in future. 

**Lazy** : When the task require then only doing like connecting the database when the client is going to perform database connection, so resource is saving here but it's delaying


### How does equals() and hashCode() work internally? What happens if they’re not overridden properly?
hashCode() is used to identify the bucket in hash-based collections, and equals() is used to compare actual objects.  
Contract:  
If two objects are equal, they must have the same hashCode.  
Same hashCode does not guarantee equality.

If not overridden properly, collections like HashMap may store duplicate keys or fail to retrieve objects correctly.