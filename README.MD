#General part

>When and why we will use Threads in our programs?

Multithreading in Java means running multiple lines of code simultainously. Multi-threading enables the programmer to better utilize systems with multiple CPU cores. Modern CPU designs favour cores over clock frequency which in return makes the CPU more energy-efficient while maintaining processing power. Multithreading can be used to make the software more responsive to user input. On a small scale, maintaining a responsive UI while performing processor intensive tasks or on a larger scale, having multiple users accessing and changing specific parts of the system simultainously. 

>Explain about the Race Condition Problem and ways to solve it in Java

A "race condition" happens when multiple threads, in an uncontrolled manner, change a shared resource. This can result in data inconsistencies. The solution is simply to ensure that the particular resource is only accessed by a single thread at a time and in Java this is typically done with synchronization. A method can be synchronized, ex. public synchronized void methodName() {} or inside a method with synchronized block, ex. synchronized (lockObject) {} or just synchronized (this) {}, although the latter has some pitfalls ( google it! :-) ). 
Primitive types can also be handled using Volatile when declaring the variable, ex. private volatile boolean isFinished. A volatile variable is written directly to memory thus bypassing the cache, which means that all threads see the same value for the variable at all times. 
Finally the Java.util.concurrent library expand on these basic principles further and provides more granular control and is possibly faster than synchronized (source: http://www.ibm.com/developerworks/library/j-jtp10264/).

>Explain how Threads can help us in making responsive User Interfaces

In this instance, seperating processes in threads, frees up the main thread so UI is responsive to user input.

#Practical part
Refer to code.