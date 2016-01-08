#General part

>When and why will we use Threads in our programs?

Multithreading in Java means running multiple lines of code simultainously. Multi-threading enables the programmer to better utilize systems with multiple CPU cores, which can improve the performance of the application. Modern CPU designs favour cores over clock frequency. This CPU-design makes the CPU more energy-efficient while maintaining processing power. 
In practice, when creating swing-applications, the GUI will appear to freeze up when running longer proccesses on a single thread. When we introduce multiple threads, it is possible to always have one thread dedicated to user input while other threads can take care of the other relevant processes. 
Multithreading can also be utilized when creating network applications that have to service several users simultainously.

>Explain about the Race Condition Problem and ways to solve it in Java

A "race condition" happens when multiple threads, in an uncontrolled manner, change a shared resource - they race to the shared resource. This can result in data inconsistencies. A "race condition" is one element of various concurrency problems in Java.

The solution is simply to ensure that the particular resource is only accessed by a single thread at one time. In Java this is typically done with synchronization. A method can be synchronized, ex. public synchronized void methodName() {} or inside a method with synchronized block, ex. synchronized (lockObject) {} or just synchronized (this) {}, although the latter has some pitfalls ( google it! :-) ). 
Primitive types can also be handled using Volatile when declaring the variable, ex. private volatile boolean isFinished. A volatile variable is written directly to memory thus bypassing the cache, which means that all threads see the same value for the variable at all times. 
Finally the Java.util.concurrent library expand on these basic principles further and provides more granular control and is possibly faster than synchronized (source: http://www.ibm.com/developerworks/library/j-jtp10264/).

>Explain how Threads can help us in making responsive User Interfaces

In this instance, seperating processes in threads, frees up the main thread so UI is responsive to user input.

>Explain how we can write reusable non-blocking Java Controls using Threads and the observer Pattern

Using this program as example: Initially, when pressing "Add New Test User", the single thread will block the program until the data has been fetched. This behaviour is especially problematic in programs with a GUI, because we want the GUI to responsive at all times. Using threads and the observer pattern we can avoid this "freezing up" entirely by placing the various processes in their own threads. When an user invokes some kind of functionality of the program, we spawn a new thread which will be responsible for making the calculation/or whatever and return the result once it is done. Once the process is done it will notify the GUI (our observer) which can then update the GUI accordingly.      

>8.  Finally, make sure that the code running on the GUI thread in the Forms update(..) method is 
thread-safe (see guidelines for threads and Swing ) 

huh?