学习笔记

**1.（选做）**自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

命令：

//生成Hello.class

 javac -encoding utf-8  .\Hello.java (有中文，需转码-encoding utf-8)

//生成字节码

javap -c .\Hello.class

//更多信息字节码信息

javap -c -v .\Hello.class

**2.（必做）**自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件群里提供。

输出  Hello, classLoader!

3.**（必做）**画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。

Xmx : 堆的最大可用内存大小

Xms:堆的初始内存大小

Xmn:年轻代大小

meta:元空间大小

directmemory:直接内存

Xss: 设置每个线程的堆栈大小

**4.（选做）**检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

**注意：**

- 对于线上有流量的系统，慎重使用 jmap 命令。
- 如果没有线上系统，可以自己 run 一个 web/java 项目。或者直接查看 idea 进程。

jps 拿到端口号  29748

jmap 命令  jmap -heap 端口号

PS C:\WINDOWS\system32> jmap -heap 29748
Attaching to process ID 29748, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 25.231-b11

using thread-local object allocation.
Parallel GC with 10 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 4259315712 (4062.0MB)
   NewSize                  = 88604672 (84.5MB)
   MaxNewSize               = 1419771904 (1354.0MB)
   OldSize                  = 177733632 (169.5MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)

Heap Usage:
PS Young Generation
Eden Space:
   capacity = 202375168 (193.0MB)
   used     = 130412256 (124.37081909179688MB)
   free     = 71962912 (68.62918090820312MB)
   64.44083890766677% used
From Space:
   capacity = 9437184 (9.0MB)
   used     = 9425632 (8.988983154296875MB)
   free     = 11552 (0.011016845703125MB)
   99.87759060329861% used
To Space:
   capacity = 12582912 (12.0MB)
   used     = 0 (0.0MB)
   free     = 12582912 (12.0MB)
   0.0% used
PS Old Generation
   capacity = 99614720 (95.0MB)
   used     = 11533448 (10.999153137207031MB)
   free     = 88081272 (84.00084686279297MB)
   11.578055933902139% used

15876 interned Strings occupying 2120992 bytes.

 jstack命令   jstack -l 端口号

PS C:\WINDOWS\system32> jstack -l 29748
2021-01-13 15:01:07
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):

"DestroyJavaVM" #34 prio=5 os_prio=0 tid=0x00000000249e7800 nid=0x1de4 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"http-nio-8088-AsyncTimeout" #32 daemon prio=5 os_prio=0 tid=0x00000000249e8800 nid=0x7c20 waiting on condition [0x000000002a29f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.coyote.AbstractProtocol$AsyncTimeout.run(AbstractProtocol.java:1143)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-Acceptor-0" #31 daemon prio=5 os_prio=0 tid=0x00000000249ec000 nid=0x1f64 runnable [0x000000002a19f000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.ServerSocketChannelImpl.accept0(Native Method)
        at sun.nio.ch.ServerSocketChannelImpl.accept(Unknown Source)
        at sun.nio.ch.ServerSocketChannelImpl.accept(Unknown Source)
        - locked <0x00000007727bf388> (a java.lang.Object)
        at org.apache.tomcat.util.net.NioEndpoint$Acceptor.run(NioEndpoint.java:455)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-ClientPoller-1" #30 daemon prio=5 os_prio=0 tid=0x00000000249df800 nid=0x77cc runnable [0x000000002a09f000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x0000000772abff70> (a sun.nio.ch.Util$3)
        - locked <0x0000000772abff60> (a java.util.Collections$UnmodifiableSet)
        - locked <0x0000000772abfe10> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:798)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-ClientPoller-0" #29 daemon prio=5 os_prio=0 tid=0x00000000249e1800 nid=0x268 runnable [0x0000000029f9f000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x0000000772abbd18> (a sun.nio.ch.Util$3)
        - locked <0x0000000772abbd08> (a java.util.Collections$UnmodifiableSet)
        - locked <0x0000000772abbbb8> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:798)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-10" #28 daemon prio=5 os_prio=0 tid=0x00000000249e5800 nid=0x1520 waiting on condition [0x0000000029e9f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-9" #27 daemon prio=5 os_prio=0 tid=0x00000000249e0000 nid=0x29e8 waiting on condition [0x0000000029d9e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-8" #26 daemon prio=5 os_prio=0 tid=0x00000000249e4000 nid=0x6500 waiting on condition [0x0000000029c9e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-7" #25 daemon prio=5 os_prio=0 tid=0x00000000249e3000 nid=0x70ec waiting on condition [0x0000000029b9f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-6" #24 daemon prio=5 os_prio=0 tid=0x00000000249e6000 nid=0x543c waiting on condition [0x0000000029a9f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-5" #23 daemon prio=5 os_prio=0 tid=0x00000000249de800 nid=0x3cac waiting on condition [0x000000002999e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-4" #22 daemon prio=5 os_prio=0 tid=0x00000000249e4800 nid=0x3214 waiting on condition [0x000000002989e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-3" #21 daemon prio=5 os_prio=0 tid=0x00000000249e2800 nid=0x4780 waiting on condition [0x000000002969f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-2" #20 daemon prio=5 os_prio=0 tid=0x00000000249e1000 nid=0x5338 waiting on condition [0x000000002959e000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"http-nio-8088-exec-1" #19 daemon prio=5 os_prio=0 tid=0x0000000024002000 nid=0x835c waiting on condition [0x000000002949f000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x0000000772820968> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(Unknown Source)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(Unknown Source)
        at java.util.concurrent.LinkedBlockingQueue.take(Unknown Source)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"NioBlockingSelector.BlockPoller-1" #18 daemon prio=5 os_prio=0 tid=0x0000000024000800 nid=0x3f38 runnable [0x0000000028f5e000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll0(Native Method)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.poll(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl$SubSelector.access$400(Unknown Source)
        at sun.nio.ch.WindowsSelectorImpl.doSelect(Unknown Source)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(Unknown Source)
        - locked <0x00000007727c1e78> (a sun.nio.ch.Util$3)
        - locked <0x00000007727c1df0> (a java.util.Collections$UnmodifiableSet)
        - locked <0x00000007727c19f0> (a sun.nio.ch.WindowsSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(Unknown Source)
        at org.apache.tomcat.util.net.NioBlockingSelector$BlockPoller.run(NioBlockingSelector.java:298)

   Locked ownable synchronizers:
        - None

"container-0" #17 prio=5 os_prio=0 tid=0x0000000024005000 nid=0x79c0 waiting on condition [0x000000002919f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.catalina.core.StandardServer.await(StandardServer.java:427)
        at org.springframework.boot.web.embedded.tomcat.TomcatWebServer$1.run(TomcatWebServer.java:182)

   Locked ownable synchronizers:
        - None

"ContainerBackgroundProcessor[StandardEngine[Tomcat]]" #16 daemon prio=5 os_prio=0 tid=0x0000000023fff000 nid=0x22d4 waiting on condition [0x000000002909f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1357)
        at java.lang.Thread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"Service Thread" #10 daemon prio=9 os_prio=0 tid=0x000000001e286800 nid=0x5844 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C1 CompilerThread3" #9 daemon prio=9 os_prio=2 tid=0x000000001e1f6800 nid=0x551c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread2" #8 daemon prio=9 os_prio=2 tid=0x000000001e1f5800 nid=0x4650 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=2 tid=0x000000001e1f1000 nid=0x4f6c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=2 tid=0x000000001e1eb000 nid=0x6808 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001e1ea000 nid=0x8128 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001e1e7000 nid=0x6764 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001e183000 nid=0x5970 in Object.wait() [0x000000001f4ef000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000006c22160a0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(Unknown Source)
        - locked <0x00000006c22160a0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(Unknown Source)
        at java.lang.ref.Finalizer$FinalizerThread.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000002ed9000 nid=0x730 in Object.wait() [0x000000001f3ef000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x00000006c22250c0> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Unknown Source)
        at java.lang.ref.Reference.tryHandlePending(Unknown Source)
        - locked <0x00000006c22250c0> (a java.lang.ref.Reference$Lock)
        at java.lang.ref.Reference$ReferenceHandler.run(Unknown Source)

   Locked ownable synchronizers:
        - None

"VM Thread" os_prio=2 tid=0x000000001e162800 nid=0x5160 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002df7000 nid=0x36c runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002df9000 nid=0x1624 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002dfa800 nid=0x55d8 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002dfd000 nid=0x44f4 runnable

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000002dfe000 nid=0x30ec runnable

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000002e00000 nid=0x4638 runnable

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x0000000002e03800 nid=0x2018 runnable

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x0000000002e04800 nid=0x6b0 runnable

"GC task thread#8 (ParallelGC)" os_prio=0 tid=0x0000000002e05800 nid=0x26c4 runnable

"GC task thread#9 (ParallelGC)" os_prio=0 tid=0x0000000002e07000 nid=0x13cc runnable

"VM Periodic Task Thread" os_prio=2 tid=0x000000001e29f800 nid=0x6ac waiting on condition

JNI global references: 930

jstat命令  jstat -gc -h3 端口号 间隔时间 次数

 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
9216.0 12288.0 9204.7  0.0   197632.0 127355.7  97280.0    11263.1   32816.0 31352.7 4400.0 4070.2      6    0.028   1      0.016    0.043



