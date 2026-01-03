# **OOPs Piller**

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

## Wrapper Class
Wrapper class create object of primitive data type as collection work on objects and not primitive data type.


### Comparable vs Comparator
Comparable is usally used inside a class.
Where as Comparator is called outside the class seprately whenever it's require.
so, for custom sorting and multiple fields sorting require we use comparator and when just a simple sorting is require we use comparable


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
