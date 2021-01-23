# **GC演练**

## **准备工作：**

dome :  GCLogAnalysis.java

？==内存大小

串行GC  >> SerialGC

命令：java -Xmx？ -Xms？ -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

并行GC>>ParallelGC

命令：java -Xmx？ -Xms？  -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

CMSGC>>CMSGC

命令：java -Xmx？ -Xms？ -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

G1GC>>G1GC

命令：java -Xmx？ -Xms？ -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis



------



## 串行GC>>SerialGC

### 环境：-Xmx128m -Xms128m

java -Xmx128m -Xms128m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis



```
2021-01-19T19:34:01.934+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.936+0800: [DefNew: 34944K->4351K(39296K), 0.0124430 secs] 34944K->13240K(126720K), 0.0137389 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
2021-01-19T19:34:01.956+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.956+0800: [DefNew: 39268K->4349K(39296K), 0.0076533 secs] 48157K->23509K(126720K), 0.0081867 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T19:34:01.970+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.971+0800: [DefNew: 39207K->4351K(39296K), 0.0067214 secs] 58367K->34778K(126720K), 0.0071787 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
2021-01-19T19:34:01.982+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.983+0800: [DefNew: 39213K->4344K(39296K), 0.0065032 secs] 69639K->46625K(126720K), 0.0069797 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:01.994+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.994+0800: [DefNew: 38695K->4350K(39296K), 0.0067625 secs] 80975K->60049K(126720K), 0.0073868 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.005+0800: [GC (Allocation Failure) 2021-01-19T19:34:02.006+0800: [DefNew: 38621K->4343K(39296K), 0.0053718 secs] 94320K->69940K(126720K), 0.0058580 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.014+0800: [GC (Allocation Failure) 2021-01-19T19:34:02.015+0800: [DefNew: 39007K->4341K(39296K), 0.0065395 secs] 104604K->82933K(126720K), 0.0070729 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.026+0800: [GC (Allocation Failure) 2021-01-19T19:34:02.027+0800: [DefNew: 39285K->39285K(39296K), 0.0008379 secs]2021-01-19T19:34:02.028+0800: [Tenured: 78592K->87326K(87424K), 0.0107276 secs] 117877K->92913K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0130154 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.043+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.044+0800: [Tenured: 87326K->87062K(87424K), 0.0095149 secs] 126481K->102908K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0112894 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.058+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.059+0800: [Tenured: 87062K->87241K(87424K), 0.0101371 secs] 126289K->108437K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0110728 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.072+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.072+0800: [Tenured: 87385K->87410K(87424K), 0.0129426 secs] 126626K->106849K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0141134 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.089+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.090+0800: [Tenured: 87410K->87410K(87424K), 0.0028133 secs] 125946K->114308K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0036829 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.094+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.095+0800: [Tenured: 87410K->87410K(87424K), 0.0024144 secs] 126363K->116102K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0037569 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.100+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.100+0800: [Tenured: 87410K->87410K(87424K), 0.0051261 secs] 126570K->120055K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0057900 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.105+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.106+0800: [Tenured: 87410K->87400K(87424K), 0.0133510 secs] 126686K->120794K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0145748 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.121+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.121+0800: [Tenured: 87400K->87400K(87424K), 0.0045643 secs] 126647K->122203K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0053660 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.127+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.128+0800: [Tenured: 87400K->87400K(87424K), 0.0018596 secs] 126619K->122728K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0028176 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.131+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.131+0800: [Tenured: 87400K->87400K(87424K), 0.0032659 secs] 126627K->124899K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0038358 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.136+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.136+0800: [Tenured: 87400K->87053K(87424K), 0.0148202 secs] 126695K->125007K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0206278 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T19:34:02.158+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.162+0800: [Tenured: 87053K->87053K(87424K), 0.0019172 secs] 125601K->125085K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0082057 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.167+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.171+0800: [Tenured: 87383K->87383K(87424K), 0.0017060 secs] 126363K->125579K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0079617 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.175+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.180+0800: [Tenured: 87383K->87383K(87424K), 0.0019786 secs] 126621K->126334K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0089172 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.185+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.190+0800: [Tenured: 87383K->87207K(87424K), 0.0090355 secs] 126671K->125119K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0142297 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T19:34:02.205+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.207+0800: [Tenured: 87351K->87351K(87424K), 0.0021021 secs] 126551K->125665K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0065713 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.213+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.214+0800: [Tenured: 87351K->87351K(87424K), 0.0017674 secs] 126209K->126004K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0028928 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.222+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.223+0800: [Tenured: 87351K->87323K(87424K), 0.0161513 secs] 126004K->125644K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0185872 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T19:34:02.242+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.246+0800: [Tenured: 87323K->87323K(87424K), 0.0017124 secs] 126612K->125788K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0066797 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.254+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.256+0800: [Tenured: 87323K->87323K(87424K), 0.0025003 secs] 126568K->125788K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0050767 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
2021-01-19T19:34:02.266+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.272+0800: [Tenured: 87395K->87395K(87424K), 0.0052952 secs] 126657K->125731K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0114285 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.279+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.280+0800: [Tenured: 87395K->87395K(87424K), 0.0014934 secs] 126455K->126036K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0023188 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.282+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.283+0800: [Tenured: 87395K->87323K(87424K), 0.0016675 secs] 126517K->125820K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0036478 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.287+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.290+0800: [Tenured: 87323K->87323K(87424K), 0.0015267 secs] 126482K->126241K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0056800 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.293+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.293+0800: [Tenured: 87323K->87323K(87424K), 0.0014653 secs] 126494K->126264K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0035257 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T19:34:02.297+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.300+0800: [Tenured: 87323K->87323K(87424K), 0.0026744 secs] 126430K->126419K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0075196 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.307+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.308+0800: [Tenured: 87323K->87416K(87424K), 0.0141996 secs] 126419K->126376K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0171961 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)
        at GCLogAnalysis.main(GCLogAnalysis.java:25)
Heap
 def new generation   total 39296K, used 39122K [0x00000000f8000000, 0x00000000faaa0000, 0x00000000faaa0000)
  eden space 34944K, 100% used [0x00000000f8000000, 0x00000000fa220000, 0x00000000fa220000)
  from space 4352K,  96% used [0x00000000fa660000, 0x00000000faa74920, 0x00000000faaa0000)
  to   space 4352K,   0% used [0x00000000fa220000, 0x00000000fa220000, 0x00000000fa660000)
 tenured generation   total 87424K, used 87416K [0x00000000faaa0000, 0x0000000100000000, 0x0000000100000000)
   the space 87424K,  99% used [0x00000000faaa0000, 0x00000000ffffe160, 0x00000000ffffe200, 0x0000000100000000)
 Metaspace       used 2662K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 294K, capacity 386K, committed 512K, reserved 1048576K
```

分析：

```
2021-01-19T19:34:01.934+0800: [GC (Allocation Failure) 2021-01-19T19:34:01.936+0800: [DefNew: 34944K->4351K(39296K), 0.0124430 secs] 34944K->13240K(126720K), 0.0137389 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
```

 第一次创建 youngGC， young区总共 38M左右 ， young区从34M 变为 4M， 总共堆大小从34M 变为 12M ， 说明其中有 8M 进入了 老年区 总共花了 0.01s 。

```
2021-01-19T19:34:02.026+0800: [GC (Allocation Failure) 2021-01-19T19:34:02.027+0800: [DefNew: 39285K->39285K(39296K), 0.0008379 secs]2021-01-19T19:34:02.028+0800: [Tenured: 78592K->87326K(87424K), 0.0107276 secs] 117877K->92913K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0130154 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T19:34:02.043+0800: [Full GC (Allocation Failure) 2021-01-19T19:34:02.044+0800: [Tenured: 87326K->87062K(87424K), 0.0095149 secs] 126481K->102908K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0112894 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

进入 FullGC，fullGC=yoingGC+OldGC，因为是串行化所以有先后, young区 并无变化，由于young区 无法回收掉， 就做了Old区的 GC，内存得不到释放，导致内存用光

###  环境：-Xmx512m -Xms512m

java -Xmx512m -Xms512m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:13:07.320+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.322+0800: [DefNew: 139776K->17472K(157248K), 0.0192067 secs] 139776K->46107K(506816K), 0.0215935 secs] [Times: user=0.00 sys=0.01, real=0.02 secs]
2021-01-19T20:13:07.358+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.358+0800: [DefNew: 157248K->17471K(157248K), 0.0256770 secs] 185883K->89917K(506816K), 0.0266097 secs] [Times: user=0.00 sys=0.03, real=0.03 secs]
2021-01-19T20:13:07.399+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.399+0800: [DefNew: 156894K->17468K(157248K), 0.0212899 secs] 229340K->138696K(506816K), 0.0220670 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
2021-01-19T20:13:07.435+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.436+0800: [DefNew: 157244K->17471K(157248K), 0.0223481 secs] 278472K->190175K(506816K), 0.0229093 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
2021-01-19T20:13:07.474+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.475+0800: [DefNew: 157000K->17470K(157248K), 0.0211195 secs] 329704K->237756K(506816K), 0.0220848 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
2021-01-19T20:13:07.511+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.511+0800: [DefNew: 157246K->17471K(157248K), 0.0182407 secs] 377532K->278289K(506816K), 0.0189755 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T20:13:07.544+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.544+0800: [DefNew: 157163K->17468K(157248K), 0.0193509 secs] 417981K->322587K(506816K), 0.0199328 secs] [Times: user=0.00 sys=0.02, real=0.02 secs]
2021-01-19T20:13:07.578+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.578+0800: [DefNew: 157207K->157207K(157248K), 0.0006633 secs]2021-01-19T20:13:07.579+0800: [Tenured: 305118K->276617K(349568K), 0.0286505 secs] 462326K->276617K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0305351 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
2021-01-19T20:13:07.623+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.624+0800: [DefNew: 139776K->17470K(157248K), 0.0068881 secs] 416393K->323504K(506816K), 0.0078232 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:13:07.646+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.646+0800: [DefNew: 157246K->157246K(157248K), 0.0006740 secs]2021-01-19T20:13:07.647+0800: [Tenured: 306034K->311196K(349568K), 0.0362263 secs] 463280K->311196K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0382809 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
2021-01-19T20:13:07.698+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.699+0800: [DefNew: 139776K->139776K(157248K), 0.0008638 secs]2021-01-19T20:13:07.700+0800: [Tenured: 311196K->336289K(349568K), 0.0411040 secs] 450972K->336289K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0432188 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T20:13:07.754+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.755+0800: [DefNew: 139776K->139776K(157248K), 0.0003812 secs]2021-01-19T20:13:07.755+0800: [Tenured: 336289K->331839K(349568K), 0.0363050 secs] 476065K->331839K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0381236 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
2021-01-19T20:13:07.806+0800: [GC (Allocation Failure) 2021-01-19T20:13:07.806+0800: [DefNew: 139776K->139776K(157248K), 0.0002555 secs]2021-01-19T20:13:07.806+0800: [Tenured: 331839K->349495K(349568K), 0.0240934 secs] 471615K->355100K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0250361 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
2021-01-19T20:13:07.846+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:07.846+0800: [Tenured: 349495K->349518K(349568K), 0.0321034 secs] 506655K->358701K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0328187 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
2021-01-19T20:13:07.894+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:07.895+0800: [Tenured: 349554K->349082K(349568K), 0.0349845 secs] 506783K->365636K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0362507 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
2021-01-19T20:13:07.947+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:07.948+0800: [Tenured: 349415K->348911K(349568K), 0.0455151 secs] 506516K->348911K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0470134 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2021-01-19T20:13:08.009+0800: [GC (Allocation Failure) 2021-01-19T20:13:08.009+0800: [DefNew: 139776K->139776K(157248K), 0.0003806 secs]2021-01-19T20:13:08.010+0800: [Tenured: 348911K->349449K(349568K), 0.0309785 secs] 488687K->367469K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0333955 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
2021-01-19T20:13:08.058+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:08.058+0800: [Tenured: 349449K->349475K(349568K), 0.0353259 secs] 506587K->362478K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0372887 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T20:13:08.111+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:08.111+0800: [Tenured: 349523K->349506K(349568K), 0.0365737 secs] 506755K->365337K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0377589 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
2021-01-19T20:13:08.164+0800: [Full GC (Allocation Failure) 2021-01-19T20:13:08.165+0800: [Tenured: 349506K->344649K(349568K), 0.0414912 secs] 506051K->344649K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0433886 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T20:13:08.222+0800: [GC (Allocation Failure) 2021-01-19T20:13:08.223+0800: [DefNew: 139776K->139776K(157248K), 0.0004146 secs]2021-01-19T20:13:08.224+0800: [Tenured: 344649K->349438K(349568K), 0.0321713 secs] 484425K->368776K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0344110 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
执行结束!共生成对象次数:11124
Heap
 def new generation   total 157248K, used 25594K [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden space 139776K,  18% used [0x00000000e0000000, 0x00000000e18fe888, 0x00000000e8880000)
  from space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
  to   space 17472K,   0% used [0x00000000e9990000, 0x00000000e9990000, 0x00000000eaaa0000)
 tenured generation   total 349568K, used 349438K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
   the space 349568K,  99% used [0x00000000eaaa0000, 0x00000000fffdf970, 0x00000000fffdfa00, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成11124次，发生24次GC

###  环境：-Xmx1g -Xms1g

```
java -Xmx1g -Xms1g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

2021-01-19T20:16:49.530+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.531+0800: [DefNew: 279616K->34944K(314560K), 0.0353202 secs] 279616K->90207K(1013632K), 0.0365989 secs] [Times: user=0.01 sys=0.01, real=0.04 secs]
2021-01-19T20:16:49.599+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.599+0800: [DefNew: 314560K->34943K(314560K), 0.0443437 secs] 369823K->171518K(1013632K), 0.0449627 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2021-01-19T20:16:49.673+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.674+0800: [DefNew: 314559K->34943K(314560K), 0.0342245 secs] 451134K->250134K(1013632K), 0.0350430 secs] [Times: user=0.02 sys=0.02, real=0.04 secs]
2021-01-19T20:16:49.736+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.736+0800: [DefNew: 314557K->34943K(314560K), 0.0333797 secs] 529748K->325954K(1013632K), 0.0337653 secs] [Times: user=0.00 sys=0.03, real=0.03 secs]
2021-01-19T20:16:49.799+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.799+0800: [DefNew: 314559K->34943K(314560K), 0.0337344 secs] 605570K->406149K(1013632K), 0.0344274 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
2021-01-19T20:16:49.861+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.861+0800: [DefNew: 314559K->34942K(314560K), 0.0341915 secs] 685765K->488339K(1013632K), 0.0348505 secs] [Times: user=0.01 sys=0.02, real=0.03 secs]
2021-01-19T20:16:49.923+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.924+0800: [DefNew: 314558K->34944K(314560K), 0.0322000 secs] 767955K->564978K(1013632K), 0.0330409 secs] [Times: user=0.02 sys=0.01, real=0.03 secs]
2021-01-19T20:16:49.984+0800: [GC (Allocation Failure) 2021-01-19T20:16:49.985+0800: [DefNew: 314560K->34943K(314560K), 0.0320941 secs] 844594K->638196K(1013632K), 0.0328503 secs] [Times: user=0.01 sys=0.02, real=0.03 secs]
2021-01-19T20:16:50.045+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.045+0800: [DefNew: 314559K->34943K(314560K), 0.0329581 secs] 917812K->716453K(1013632K), 0.0337309 secs] [Times: user=0.00 sys=0.03, real=0.03 secs]
2021-01-19T20:16:50.106+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.106+0800: [DefNew: 314559K->314559K(314560K), 0.0006916 secs]2021-01-19T20:16:50.107+0800: [Tenured: 681509K->376969K(699072K), 0.0391830 secs] 996069K->376969K(1013632K), [Metaspace: 2632K->2632K(1056768K)], 0.0413581 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T20:16:50.177+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.178+0800: [DefNew: 279616K->34943K(314560K), 0.0106617 secs] 656585K->465093K(1013632K), 0.0115490 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:16:50.218+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.218+0800: [DefNew: 314559K->34943K(314560K), 0.0133815 secs] 744709K->539974K(1013632K), 0.0142110 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T20:16:50.261+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.261+0800: [DefNew: 314559K->34943K(314560K), 0.0138586 secs] 819590K->623609K(1013632K), 0.0146393 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T20:16:50.304+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.305+0800: [DefNew: 314559K->34942K(314560K), 0.0143123 secs] 903225K->697877K(1013632K), 0.0152088 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T20:16:50.349+0800: [GC (Allocation Failure) 2021-01-19T20:16:50.350+0800: [DefNew: 314558K->314558K(314560K), 0.0006310 secs]2021-01-19T20:16:50.351+0800: [Tenured: 662934K->398578K(699072K), 0.0427003 secs] 977493K->398578K(1013632K), [Metaspace: 2632K->2632K(1056768K)], 0.0445422 secs] [Times: user=0.03 sys=0.00, real=0.05 secs]
执行结束!共生成对象次数:16411
Heap
 def new generation   total 314560K, used 167638K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  59% used [0x00000000c0000000, 0x00000000ca3b5858, 0x00000000d1110000)
  from space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
  to   space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
 tenured generation   total 699072K, used 398578K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  57% used [0x00000000d5550000, 0x00000000eda8c908, 0x00000000eda8ca00, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成16411次，发生16次GC

###  环境：-Xmx2g -Xms2g

java -Xmx2g -Xms2g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:26:03.419+0800: [GC (Allocation Failure) 2021-01-19T20:26:03.419+0800: [DefNew: 559232K->69888K(629120K), 0.0624273 secs] 559232K->159713K(2027264K), 0.0632030 secs] [Times: user=0.03 sys=0.03, real=0.06 secs]
2021-01-19T20:26:03.543+0800: [GC (Allocation Failure) 2021-01-19T20:26:03.544+0800: [DefNew: 629120K->69887K(629120K), 0.0746698 secs] 718945K->286442K(2027264K), 0.0756144 secs] [Times: user=0.02 sys=0.06, real=0.08 secs]
2021-01-19T20:26:03.672+0800: [GC (Allocation Failure) 2021-01-19T20:26:03.673+0800: [DefNew: 629119K->69888K(629120K), 0.0550694 secs] 845674K->409673K(2027264K), 0.0559484 secs] [Times: user=0.05 sys=0.02, real=0.06 secs]
2021-01-19T20:26:03.778+0800: [GC (Allocation Failure) 2021-01-19T20:26:03.779+0800: [DefNew: 629120K->69887K(629120K), 0.0631404 secs] 968905K->554713K(2027264K), 0.0639045 secs] [Times: user=0.03 sys=0.03, real=0.06 secs]
2021-01-19T20:26:03.895+0800: [GC (Allocation Failure) 2021-01-19T20:26:03.896+0800: [DefNew: 629119K->69887K(629120K), 0.0589600 secs] 1113945K->690921K(2027264K), 0.0599021 secs] [Times: user=0.02 sys=0.05, real=0.06 secs]
2021-01-19T20:26:04.012+0800: [GC (Allocation Failure) 2021-01-19T20:26:04.013+0800: [DefNew: 629119K->69887K(629120K), 0.0558980 secs] 1250153K->824484K(2027264K), 0.0566753 secs] [Times: user=0.01 sys=0.03, real=0.06 secs]
2021-01-19T20:26:04.123+0800: [GC (Allocation Failure) 2021-01-19T20:26:04.123+0800: [DefNew: 629119K->69887K(629120K), 0.0542537 secs] 1383716K->951276K(2027264K), 0.0548678 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]
执行结束!共生成对象次数:15488
Heap
 def new generation   total 629120K, used 253945K [0x0000000080000000, 0x00000000aaaa0000, 0x00000000aaaa0000)
  eden space 559232K,  32% used [0x0000000080000000, 0x000000008b3be638, 0x00000000a2220000)
  from space 69888K,  99% used [0x00000000a6660000, 0x00000000aaa9fff8, 0x00000000aaaa0000)
  to   space 69888K,   0% used [0x00000000a2220000, 0x00000000a2220000, 0x00000000a6660000)
 tenured generation   total 1398144K, used 881388K [0x00000000aaaa0000, 0x0000000100000000, 0x0000000100000000)
   the space 1398144K,  63% used [0x00000000aaaa0000, 0x00000000e075b178, 0x00000000e075b200, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成15488次，发生7次GC

###  环境：-Xmx4g -Xms4g

java -Xmx4g -Xms4g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:30:45.193+0800: [GC (Allocation Failure) 2021-01-19T20:30:45.194+0800: [DefNew: 1118528K->139775K(1258304K), 0.0913269 secs] 1118528K->244866K(4054528K), 0.0925411 secs] [Times: user=0.03 sys=0.05, real=0.09 secs]
2021-01-19T20:30:45.405+0800: [GC (Allocation Failure) 2021-01-19T20:30:45.405+0800: [DefNew: 1258303K->139775K(1258304K), 0.1029424 secs] 1363394K->384184K(4054528K), 0.1038433 secs] [Times: user=0.02 sys=0.09, real=0.10 secs]
2021-01-19T20:30:45.621+0800: [GC (Allocation Failure) 2021-01-19T20:30:45.621+0800: [DefNew: 1258303K->139776K(1258304K), 0.0754907 secs] 1502712K->535793K(4054528K), 0.0766020 secs] [Times: user=0.03 sys=0.05, real=0.08 secs]
执行结束!共生成对象次数:14649
Heap
 def new generation   total 1258304K, used 701394K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)
  eden space 1118528K,  50% used [0x00000006c0000000, 0x00000006e2474a98, 0x0000000704450000)
  from space 139776K, 100% used [0x000000070ccd0000, 0x0000000715550000, 0x0000000715550000)
  to   space 139776K,   0% used [0x0000000704450000, 0x0000000704450000, 0x000000070ccd0000)
 tenured generation   total 2796224K, used 396017K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 2796224K,  14% used [0x0000000715550000, 0x000000072d80c5b8, 0x000000072d80c600, 0x00000007c0000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成14649次，发生4次GC

#### 结论：串行GC,使用的堆内存越大，GC频率越低，但每次耗时却越多，反之堆内存越小，GC越活跃，每次GC耗时小。

------

## 并行GC>>ParallelGC

###  环境：-Xmx128m -Xms128m

java -Xmx128m -Xms128m -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:44:04.608+0800: [GC (Allocation Failure) [PSYoungGen: 32833K->5118K(38400K)] 32833K->10850K(125952K), 0.0030887 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.619+0800: [GC (Allocation Failure) [PSYoungGen: 38398K->5097K(38400K)] 44130K->21632K(125952K), 0.0039534 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.629+0800: [GC (Allocation Failure) [PSYoungGen: 38282K->5103K(38400K)] 54817K->32827K(125952K), 0.0032939 secs] [Times: user=0.05 sys=0.13, real=0.00 secs]
2021-01-19T20:44:04.637+0800: [GC (Allocation Failure) [PSYoungGen: 37786K->5116K(38400K)] 65510K->42796K(125952K), 0.0035909 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.646+0800: [GC (Allocation Failure) [PSYoungGen: 38296K->5116K(38400K)] 75975K->53806K(125952K), 0.0038856 secs] [Times: user=0.06 sys=0.09, real=0.00 secs]
2021-01-19T20:44:04.655+0800: [GC (Allocation Failure) [PSYoungGen: 38396K->5116K(19968K)] 87086K->64063K(107520K), 0.0033983 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.660+0800: [GC (Allocation Failure) [PSYoungGen: 19798K->9659K(29184K)] 78745K->69959K(116736K), 0.0032706 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.665+0800: [GC (Allocation Failure) [PSYoungGen: 24372K->11316K(29184K)] 84672K->74351K(116736K), 0.0027151 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.670+0800: [GC (Allocation Failure) [PSYoungGen: 26121K->14227K(29184K)] 89156K->78945K(116736K), 0.0029676 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.675+0800: [GC (Allocation Failure) [PSYoungGen: 29075K->8688K(29184K)] 93793K->82884K(116736K), 0.0039064 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.680+0800: [Full GC (Ergonomics) [PSYoungGen: 8688K->0K(29184K)] [ParOldGen: 74196K->76327K(87552K)] 82884K->76327K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0122681 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.695+0800: [Full GC (Ergonomics) [PSYoungGen: 14409K->0K(29184K)] [ParOldGen: 76327K->80049K(87552K)] 90736K->80049K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0115978 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.710+0800: [Full GC (Ergonomics) [PSYoungGen: 14742K->0K(29184K)] [ParOldGen: 80049K->85992K(87552K)] 94792K->85992K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0186401 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T20:44:04.731+0800: [Full GC (Ergonomics) [PSYoungGen: 14791K->2348K(29184K)] [ParOldGen: 85992K->87498K(87552K)] 100783K->89847K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0191839 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T20:44:04.754+0800: [Full GC (Ergonomics) [PSYoungGen: 14554K->5889K(29184K)] [ParOldGen: 87498K->87031K(87552K)] 102053K->92920K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0139700 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.770+0800: [Full GC (Ergonomics) [PSYoungGen: 14668K->7397K(29184K)] [ParOldGen: 87031K->86940K(87552K)] 101699K->94337K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0045482 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.777+0800: [Full GC (Ergonomics) [PSYoungGen: 14827K->9313K(29184K)] [ParOldGen: 86940K->86940K(87552K)] 101767K->96253K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0123706 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.790+0800: [Full GC (Ergonomics) [PSYoungGen: 14574K->10457K(29184K)] [ParOldGen: 86940K->86940K(87552K)] 101515K->97398K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0029662 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.801+0800: [Full GC (Ergonomics) [PSYoungGen: 14817K->11171K(29184K)] [ParOldGen: 86940K->87549K(87552K)] 101757K->98720K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0138359 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.819+0800: [Full GC (Ergonomics) [PSYoungGen: 14348K->12117K(29184K)] [ParOldGen: 87549K->87149K(87552K)] 101897K->99266K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0131457 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.838+0800: [Full GC (Ergonomics) [PSYoungGen: 14806K->13295K(29184K)] [ParOldGen: 87149K->87125K(87552K)] 101955K->100420K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0093091 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.851+0800: [Full GC (Ergonomics) [PSYoungGen: 14812K->12943K(29184K)] [ParOldGen: 87125K->87339K(87552K)] 101937K->100282K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0144937 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.869+0800: [Full GC (Ergonomics) [PSYoungGen: 14756K->13008K(29184K)] [ParOldGen: 87339K->87339K(87552K)] 102096K->100348K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0043438 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.874+0800: [Full GC (Ergonomics) [PSYoungGen: 14736K->13462K(29184K)] [ParOldGen: 87339K->86962K(87552K)] 102076K->100424K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0169945 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T20:44:04.892+0800: [Full GC (Ergonomics) [PSYoungGen: 14675K->13915K(29184K)] [ParOldGen: 86962K->86954K(87552K)] 101637K->100870K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0142694 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T20:44:04.908+0800: [Full GC (Ergonomics) [PSYoungGen: 14758K->13771K(29184K)] [ParOldGen: 86954K->86954K(87552K)] 101712K->100726K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0125956 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.921+0800: [Full GC (Ergonomics) [PSYoungGen: 14841K->14233K(29184K)] [ParOldGen: 86954K->86954K(87552K)] 101795K->101188K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0119433 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.934+0800: [Full GC (Ergonomics) [PSYoungGen: 14609K->14283K(29184K)] [ParOldGen: 86954K->86954K(87552K)] 101563K->101238K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0114888 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.953+0800: [Full GC (Ergonomics) [PSYoungGen: 14589K->14589K(29184K)] [ParOldGen: 86954K->86941K(87552K)] 101543K->101530K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0155872 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T20:44:04.970+0800: [Full GC (Ergonomics) [PSYoungGen: 14736K->14589K(29184K)] [ParOldGen: 87439K->87085K(87552K)] 102176K->101674K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0120762 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.985+0800: [Full GC (Ergonomics) [PSYoungGen: 14709K->14709K(29184K)] [ParOldGen: 87085K->86941K(87552K)] 101795K->101651K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0038778 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:44:04.989+0800: [Full GC (Ergonomics) [PSYoungGen: 14833K->14796K(29184K)] [ParOldGen: 87530K->87387K(87552K)] 102364K->102184K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0146044 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:44:05.005+0800: [Full GC (Ergonomics) [PSYoungGen: 14841K->14796K(29184K)] [ParOldGen: 87501K->87501K(87552K)] 102342K->102298K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0119091 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:05.018+0800: [Full GC (Allocation Failure) [PSYoungGen: 14796K->14796K(29184K)] [ParOldGen: 87501K->87482K(87552K)] 102298K->102279K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0188583 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
        at java.lang.AbstractStringBuilder.append(Unknown Source)
        at java.lang.StringBuilder.append(Unknown Source)
        at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:56)
        at GCLogAnalysis.main(GCLogAnalysis.java:25)
Heap
 PSYoungGen      total 29184K, used 14848K [0x00000000fd580000, 0x0000000100000000, 0x0000000100000000)
  eden space 14848K, 100% used [0x00000000fd580000,0x00000000fe400000,0x00000000fe400000)
  from space 14336K, 0% used [0x00000000ff200000,0x00000000ff200000,0x0000000100000000)
  to   space 14336K, 0% used [0x00000000fe400000,0x00000000fe400000,0x00000000ff200000)
 ParOldGen       total 87552K, used 87482K [0x00000000f8000000, 0x00000000fd580000, 0x00000000fd580000)
  object space 87552K, 99% used [0x00000000f8000000,0x00000000fd56e900,0x00000000fd580000)
 Metaspace       used 2662K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 294K, capacity 386K, committed 512K, reserved 1048576K
```

分析：

```
2021-01-19T20:44:04.608+0800: [GC (Allocation Failure) [PSYoungGen: 32833K->5118K(38400K)] 32833K->10850K(125952K), 0.0030887 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
```

 第一次创建 youngGC， young区总共 38M左右 ， young区从32M 变为 5M， 总共堆大小从32M 变为 10M ， 说明其中有 5M 进入了 老年区 总共花了 0.00s 。

```
2021-01-19T20:44:04.675+0800: [GC (Allocation Failure) [PSYoungGen: 29075K->8688K(29184K)] 93793K->82884K(116736K), 0.0039064 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:44:04.680+0800: [Full GC (Ergonomics) [PSYoungGen: 8688K->0K(29184K)] [ParOldGen: 74196K->76327K(87552K)] 82884K->76327K(116736K), [Metaspace: 2632K->2632K(1056768K)], 0.0122681 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

进入 FullGC，fullGC=yoingGC+OldGC，因为young区 并无变化，由于young区 无法回收掉， 就做了Old区的 GC，内存得不到释放，导致内存用光

###  环境：-Xmx512m -Xms512m

java -Xmx512m -Xms512m -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:52:05.946+0800: [GC (Allocation Failure) [PSYoungGen: 131220K->21502K(153088K)] 131220K->47317K(502784K), 0.0071570 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:05.969+0800: [GC (Allocation Failure) [PSYoungGen: 153086K->21503K(153088K)] 178901K->85412K(502784K), 0.0084343 secs] [Times: user=0.03 sys=0.13, real=0.01 secs]
2021-01-19T20:52:05.991+0800: [GC (Allocation Failure) [PSYoungGen: 153087K->21496K(153088K)] 216996K->129302K(502784K), 0.0106816 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
2021-01-19T20:52:06.016+0800: [GC (Allocation Failure) [PSYoungGen: 153080K->21496K(153088K)] 260886K->168028K(502784K), 0.0086657 secs] [Times: user=0.01 sys=0.14, real=0.01 secs]
2021-01-19T20:52:06.038+0800: [GC (Allocation Failure) [PSYoungGen: 152584K->21503K(153088K)] 299116K->212527K(502784K), 0.0092992 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.063+0800: [GC (Allocation Failure) [PSYoungGen: 152378K->21498K(80384K)] 343402K->253169K(430080K), 0.0087472 secs] [Times: user=0.06 sys=0.09, real=0.01 secs]
2021-01-19T20:52:06.079+0800: [GC (Allocation Failure) [PSYoungGen: 80378K->38099K(116736K)] 312049K->275160K(466432K), 0.0058974 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.092+0800: [GC (Allocation Failure) [PSYoungGen: 96979K->46345K(116736K)] 334040K->291094K(466432K), 0.0072814 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.105+0800: [GC (Allocation Failure) [PSYoungGen: 104945K->53339K(116736K)] 349694K->305549K(466432K), 0.0075998 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.120+0800: [GC (Allocation Failure) [PSYoungGen: 112127K->37632K(116736K)] 364337K->320081K(466432K), 0.0085304 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.135+0800: [GC (Allocation Failure) [PSYoungGen: 96371K->21803K(116736K)] 378820K->340550K(466432K), 0.0077011 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.143+0800: [Full GC (Ergonomics) [PSYoungGen: 21803K->0K(116736K)] [ParOldGen: 318747K->233149K(349696K)] 340550K->233149K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0292953 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
2021-01-19T20:52:06.180+0800: [GC (Allocation Failure) [PSYoungGen: 58419K->18793K(116736K)] 291569K->251943K(466432K), 0.0034770 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.191+0800: [GC (Allocation Failure) [PSYoungGen: 77673K->14670K(116736K)] 310823K->266317K(466432K), 0.0048581 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.203+0800: [GC (Allocation Failure) [PSYoungGen: 73550K->16693K(116736K)] 325197K->281412K(466432K), 0.0043109 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.214+0800: [GC (Allocation Failure) [PSYoungGen: 75504K->20916K(116736K)] 340222K->301693K(466432K), 0.0045020 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.225+0800: [GC (Allocation Failure) [PSYoungGen: 79796K->23225K(116736K)] 360573K->322583K(466432K), 0.0057411 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.236+0800: [GC (Allocation Failure) [PSYoungGen: 81981K->23884K(116736K)] 381339K->345327K(466432K), 0.0062575 secs] [Times: user=0.08 sys=0.08, real=0.01 secs]
2021-01-19T20:52:06.242+0800: [Full GC (Ergonomics) [PSYoungGen: 23884K->0K(116736K)] [ParOldGen: 321442K->270453K(349696K)] 345327K->270453K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0301837 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
2021-01-19T20:52:06.279+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->18130K(116736K)] 329333K->288584K(466432K), 0.0031545 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.289+0800: [GC (Allocation Failure) [PSYoungGen: 76995K->18009K(116736K)] 347448K->304366K(466432K), 0.0050810 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.301+0800: [GC (Allocation Failure) [PSYoungGen: 76889K->23300K(116736K)] 363246K->326508K(466432K), 0.0052644 secs] [Times: user=0.16 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.312+0800: [GC (Allocation Failure) [PSYoungGen: 82026K->21485K(116736K)] 385233K->346677K(466432K), 0.0058733 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.318+0800: [Full GC (Ergonomics) [PSYoungGen: 21485K->0K(116736K)] [ParOldGen: 325192K->288390K(349696K)] 346677K->288390K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0304512 secs] [Times: user=0.17 sys=0.00, real=0.03 secs]
2021-01-19T20:52:06.355+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->20754K(116736K)] 347270K->309145K(466432K), 0.0031014 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.364+0800: [GC (Allocation Failure) [PSYoungGen: 79360K->20556K(116736K)] 367751K->329299K(466432K), 0.0048568 secs] [Times: user=0.16 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.375+0800: [GC (Allocation Failure) [PSYoungGen: 79407K->22899K(116736K)] 388150K->351572K(466432K), 0.0053108 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.381+0800: [Full GC (Ergonomics) [PSYoungGen: 22899K->0K(116736K)] [ParOldGen: 328673K->302911K(349696K)] 351572K->302911K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0315603 secs] [Times: user=0.28 sys=0.02, real=0.03 secs]
2021-01-19T20:52:06.418+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->20253K(116736K)] 361791K->323164K(466432K), 0.0031040 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.427+0800: [GC (Allocation Failure) [PSYoungGen: 79133K->19242K(116736K)] 382044K->341072K(466432K), 0.0052647 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.433+0800: [Full GC (Ergonomics) [PSYoungGen: 19242K->0K(116736K)] [ParOldGen: 321830K->308182K(349696K)] 341072K->308182K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0324724 secs] [Times: user=0.31 sys=0.00, real=0.03 secs]
2021-01-19T20:52:06.472+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->22836K(116736K)] 367062K->331019K(466432K), 0.0039832 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2021-01-19T20:52:06.483+0800: [GC (Allocation Failure) [PSYoungGen: 81456K->42583K(116224K)] 389639K->350766K(465920K), 0.0056152 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.496+0800: [GC (Allocation Failure) [PSYoungGen: 101463K->22337K(116736K)] 409646K->371269K(466432K), 0.0084963 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:52:06.505+0800: [Full GC (Ergonomics) [PSYoungGen: 22337K->0K(116736K)] [ParOldGen: 348931K->314076K(349696K)] 371269K->314076K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0420612 secs] [Times: user=0.33 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.555+0800: [Full GC (Ergonomics) [PSYoungGen: 58640K->0K(116736K)] [ParOldGen: 314076K->316426K(349696K)] 372716K->316426K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0394805 secs] [Times: user=0.31 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.606+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 316426K->314265K(349696K)] 375306K->314265K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0377558 secs] [Times: user=0.28 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.651+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 314265K->320660K(349696K)] 373145K->320660K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0370874 secs] [Times: user=0.30 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.695+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 320660K->322894K(349696K)] 379540K->322894K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0374518 secs] [Times: user=0.31 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.739+0800: [Full GC (Ergonomics) [PSYoungGen: 58692K->0K(116736K)] [ParOldGen: 322894K->331569K(349696K)] 381587K->331569K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0397304 secs] [Times: user=0.33 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.785+0800: [Full GC (Ergonomics) [PSYoungGen: 58753K->0K(116736K)] [ParOldGen: 331569K->334566K(349696K)] 390322K->334566K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0383886 secs] [Times: user=0.45 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.830+0800: [Full GC (Ergonomics) [PSYoungGen: 58814K->0K(116736K)] [ParOldGen: 334566K->338559K(349696K)] 393380K->338559K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0392306 secs] [Times: user=0.45 sys=0.00, real=0.04 secs]
2021-01-19T20:52:06.877+0800: [Full GC (Ergonomics) [PSYoungGen: 58609K->0K(116736K)] [ParOldGen: 338559K->335857K(349696K)] 397169K->335857K(466432K), [Metaspace: 2632K->2632K(1056768K)], 0.0378411 secs] [Times: user=0.45 sys=0.00, real=0.04 secs]
执行结束!共生成对象次数:9938
Heap
 PSYoungGen      total 116736K, used 3001K [0x00000000f5580000, 0x0000000100000000, 0x0000000100000000)
  eden space 58880K, 5% used [0x00000000f5580000,0x00000000f586e788,0x00000000f8f00000)
  from space 57856K, 0% used [0x00000000f8f00000,0x00000000f8f00000,0x00000000fc780000)
  to   space 57856K, 0% used [0x00000000fc780000,0x00000000fc780000,0x0000000100000000)
 ParOldGen       total 349696K, used 335857K [0x00000000e0000000, 0x00000000f5580000, 0x00000000f5580000)
  object space 349696K, 96% used [0x00000000e0000000,0x00000000f47fc620,0x00000000f5580000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成9938次，发生49次GC

###  环境：-Xmx1g -Xms1g

java -Xmx1g -Xms1g -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:56:41.461+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43512K(305664K)] 262144K->75081K(1005056K), 0.0117823 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.502+0800: [GC (Allocation Failure) [PSYoungGen: 305429K->43517K(305664K)] 336998K->151627K(1005056K), 0.0156875 secs] [Times: user=0.05 sys=0.11, real=0.02 secs]
2021-01-19T20:56:41.549+0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43511K(305664K)] 413771K->229578K(1005056K), 0.0159772 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T20:56:41.591+0800: [GC (Allocation Failure) [PSYoungGen: 305655K->43519K(305664K)] 491722K->305009K(1005056K), 0.0146608 secs] [Times: user=0.05 sys=0.11, real=0.01 secs]
2021-01-19T20:56:41.633+0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43505K(305664K)] 567153K->376954K(1005056K), 0.0142845 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.674+0800: [GC (Allocation Failure) [PSYoungGen: 305649K->43518K(160256K)] 639098K->447245K(859648K), 0.0138467 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.699+0800: [GC (Allocation Failure) [PSYoungGen: 160254K->71663K(232960K)] 563981K->482600K(932352K), 0.0090622 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.721+0800: [GC (Allocation Failure) [PSYoungGen: 188399K->85832K(232960K)] 599336K->506722K(932352K), 0.0112473 secs] [Times: user=0.14 sys=0.01, real=0.01 secs]
2021-01-19T20:56:41.744+0800: [GC (Allocation Failure) [PSYoungGen: 202568K->101979K(232960K)] 623458K->537603K(932352K), 0.0129302 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.768+0800: [GC (Allocation Failure) [PSYoungGen: 218715K->76343K(232960K)] 654339K->568271K(932352K), 0.0141542 secs] [Times: user=0.11 sys=0.05, real=0.02 secs]
2021-01-19T20:56:41.794+0800: [GC (Allocation Failure) [PSYoungGen: 193079K->43354K(232960K)] 685007K->603636K(932352K), 0.0131753 secs] [Times: user=0.08 sys=0.08, real=0.01 secs]
2021-01-19T20:56:41.820+0800: [GC (Allocation Failure) [PSYoungGen: 160090K->40729K(232960K)] 720372K->640375K(932352K), 0.0111699 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.832+0800: [Full GC (Ergonomics) [PSYoungGen: 40729K->0K(232960K)] [ParOldGen: 599645K->324578K(699392K)] 640375K->324578K(932352K), [Metaspace: 2632K->2632K(1056768K)], 0.0414787 secs] [Times: user=0.42 sys=0.02, real=0.04 secs]
2021-01-19T20:56:41.885+0800: [GC (Allocation Failure) [PSYoungGen: 116736K->38358K(232960K)] 441314K->362937K(932352K), 0.0051015 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.905+0800: [GC (Allocation Failure) [PSYoungGen: 155074K->40108K(232960K)] 479653K->396070K(932352K), 0.0081050 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.926+0800: [GC (Allocation Failure) [PSYoungGen: 156844K->36504K(232960K)] 512806K->429031K(932352K), 0.0103186 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.949+0800: [GC (Allocation Failure) [PSYoungGen: 153240K->43017K(232960K)] 545767K->467113K(932352K), 0.0111436 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:41.974+0800: [GC (Allocation Failure) [PSYoungGen: 159753K->45767K(232960K)] 583849K->507869K(932352K), 0.0110115 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.000+0800: [GC (Allocation Failure) [PSYoungGen: 162437K->34189K(232960K)] 624539K->539317K(932352K), 0.0113738 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.025+0800: [GC (Allocation Failure) [PSYoungGen: 150925K->42590K(232960K)] 656053K->577959K(932352K), 0.0087382 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.045+0800: [GC (Allocation Failure) [PSYoungGen: 159167K->37320K(232960K)] 694537K->612265K(932352K), 0.0114983 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.071+0800: [GC (Allocation Failure) [PSYoungGen: 153899K->38730K(232960K)] 728844K->647953K(932352K), 0.0090308 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.091+0800: [GC (Allocation Failure) [PSYoungGen: 155466K->49403K(232960K)] 764689K->693762K(932352K), 0.0116570 secs] [Times: user=0.11 sys=0.05, real=0.01 secs]
2021-01-19T20:56:42.103+0800: [Full GC (Ergonomics) [PSYoungGen: 49403K->0K(232960K)] [ParOldGen: 644358K->358357K(699392K)] 693762K->358357K(932352K), [Metaspace: 2632K->2632K(1056768K)], 0.0477453 secs] [Times: user=0.44 sys=0.00, real=0.05 secs]
2021-01-19T20:56:42.164+0800: [GC (Allocation Failure) [PSYoungGen: 116736K->37180K(232960K)] 475093K->395537K(932352K), 0.0070833 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.184+0800: [GC (Allocation Failure) [PSYoungGen: 153916K->41746K(232960K)] 512273K->432624K(932352K), 0.0101120 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.209+0800: [GC (Allocation Failure) [PSYoungGen: 158482K->40609K(232960K)] 549360K->469110K(932352K), 0.0133106 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.236+0800: [GC (Allocation Failure) [PSYoungGen: 157345K->35527K(236544K)] 585846K->498831K(935936K), 0.0091287 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.259+0800: [GC (Allocation Failure) [PSYoungGen: 155789K->42385K(232960K)] 619093K->535938K(932352K), 0.0110441 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.283+0800: [GC (Allocation Failure) [PSYoungGen: 162165K->42090K(245248K)] 655718K->574220K(944640K), 0.0090875 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.306+0800: [GC (Allocation Failure) [PSYoungGen: 179306K->49357K(241152K)] 711436K->618432K(940544K), 0.0099073 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T20:56:42.330+0800: [GC (Allocation Failure) [PSYoungGen: 186573K->46305K(254976K)] 755648K->658221K(954368K), 0.0096560 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
执行结束!共生成对象次数:17031
Heap
 PSYoungGen      total 254976K, used 121403K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 156672K, 47% used [0x00000000eab00000,0x00000000ef4569e8,0x00000000f4400000)
  from space 98304K, 47% used [0x00000000fa000000,0x00000000fcd38400,0x0000000100000000)
  to   space 94208K, 0% used [0x00000000f4400000,0x00000000f4400000,0x00000000fa000000)
 ParOldGen       total 699392K, used 611916K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 87% used [0x00000000c0000000,0x00000000e5593368,0x00000000eab00000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成17031次，发生34次GC

###  环境：-Xmx2g -Xms2g

java -Xmx2g -Xms2g -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T20:59:31.296+0800: [GC (Allocation Failure) [PSYoungGen: 524800K->87029K(611840K)] 524800K->157038K(2010112K), 0.0188850 secs] [Times: user=0.06 sys=0.09, real=0.02 secs]
2021-01-19T20:59:31.372+0800: [GC (Allocation Failure) [PSYoungGen: 611740K->87033K(611840K)] 681749K->271580K(2010112K), 0.0246027 secs] [Times: user=0.08 sys=0.08, real=0.02 secs]
2021-01-19T20:59:31.449+0800: [GC (Allocation Failure) [PSYoungGen: 611833K->87036K(611840K)] 796380K->385439K(2010112K), 0.0230547 secs] [Times: user=0.02 sys=0.14, real=0.02 secs]
2021-01-19T20:59:31.523+0800: [GC (Allocation Failure) [PSYoungGen: 611836K->87024K(611840K)] 910239K->510183K(2010112K), 0.0253653 secs] [Times: user=0.03 sys=0.13, real=0.03 secs]
2021-01-19T20:59:31.601+0800: [GC (Allocation Failure) [PSYoungGen: 611824K->87028K(611840K)] 1034983K->624915K(2010112K), 0.0285264 secs] [Times: user=0.03 sys=0.11, real=0.03 secs]
2021-01-19T20:59:31.683+0800: [GC (Allocation Failure) [PSYoungGen: 611828K->87037K(323072K)] 1149715K->741156K(1721344K), 0.0279627 secs] [Times: user=0.05 sys=0.13, real=0.03 secs]
2021-01-19T20:59:31.735+0800: [GC (Allocation Failure) [PSYoungGen: 323069K->141598K(377856K)] 977188K->802875K(1776128K), 0.0160436 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T20:59:31.774+0800: [GC (Allocation Failure) [PSYoungGen: 377599K->166994K(465920K)] 1038876K->843575K(1864192K), 0.0198174 secs] [Times: user=0.14 sys=0.02, real=0.02 secs]
2021-01-19T20:59:31.818+0800: [GC (Allocation Failure) [PSYoungGen: 399954K->184113K(465920K)] 1076535K->891529K(1864192K), 0.0236754 secs] [Times: user=0.25 sys=0.06, real=0.02 secs]
2021-01-19T20:59:31.867+0800: [GC (Allocation Failure) [PSYoungGen: 417073K->132820K(464384K)] 1124489K->925918K(1862656K), 0.0260501 secs] [Times: user=0.11 sys=0.03, real=0.03 secs]
2021-01-19T20:59:31.917+0800: [GC (Allocation Failure) [PSYoungGen: 365780K->73507K(465920K)] 1158878K->974995K(1864192K), 0.0249671 secs] [Times: user=0.09 sys=0.06, real=0.02 secs]
2021-01-19T20:59:31.966+0800: [GC (Allocation Failure) [PSYoungGen: 306467K->71304K(465920K)] 1207955K->1031138K(1864192K), 0.0173647 secs] [Times: user=0.09 sys=0.06, real=0.02 secs]
2021-01-19T20:59:32.007+0800: [GC (Allocation Failure) [PSYoungGen: 304264K->77644K(465920K)] 1264098K->1095510K(1864192K), 0.0191514 secs] [Times: user=0.09 sys=0.06, real=0.02 secs]
2021-01-19T20:59:32.051+0800: [GC (Allocation Failure) [PSYoungGen: 310604K->66788K(465920K)] 1328470K->1151471K(1864192K), 0.0185733 secs] [Times: user=0.16 sys=0.16, real=0.02 secs]
执行结束!共生成对象次数:19412
Heap
 PSYoungGen      total 465920K, used 213683K [0x00000000d5580000, 0x0000000100000000, 0x0000000100000000)
  eden space 232960K, 63% used [0x00000000d5580000,0x00000000de4f3b48,0x00000000e3900000)
  from space 232960K, 28% used [0x00000000f1c80000,0x00000000f5db90d8,0x0000000100000000)
  to   space 232960K, 0% used [0x00000000e3900000,0x00000000e3900000,0x00000000f1c80000)
 ParOldGen       total 1398272K, used 1084683K [0x0000000080000000, 0x00000000d5580000, 0x00000000d5580000)
  object space 1398272K, 77% used [0x0000000080000000,0x00000000c2342d10,0x00000000d5580000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成19412次，发生14次GC

### 环境：-Xmx4g -Xms4g

java -Xmx4g -Xms4g -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T21:00:35.569+0800: [GC (Allocation Failure) [PSYoungGen: 1048576K->174590K(1223168K)] 1048576K->234740K(4019712K), 0.0276134 secs] [Times: user=0.03 sys=0.13, real=0.03 secs]
2021-01-19T21:00:35.707+0800: [GC (Allocation Failure) [PSYoungGen: 1223166K->174578K(1223168K)] 1283316K->368223K(4019712K), 0.0350379 secs] [Times: user=0.16 sys=0.31, real=0.04 secs]
2021-01-19T21:00:35.841+0800: [GC (Allocation Failure) [PSYoungGen: 1223154K->174591K(1223168K)] 1416799K->501257K(4019712K), 0.0322066 secs] [Times: user=0.17 sys=0.14, real=0.03 secs]
2021-01-19T21:00:35.977+0800: [GC (Allocation Failure) [PSYoungGen: 1223167K->174577K(1223168K)] 1549833K->641350K(4019712K), 0.0375976 secs] [Times: user=0.20 sys=0.11, real=0.04 secs]
2021-01-19T21:00:36.118+0800: [GC (Allocation Failure) [PSYoungGen: 1223153K->174590K(1223168K)] 1689926K->748356K(4019712K), 0.0346951 secs] [Times: user=0.19 sys=0.08, real=0.03 secs]
执行结束!共生成对象次数:19991
Heap
 PSYoungGen      total 1223168K, used 216715K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 1048576K, 4% used [0x000000076ab00000,0x000000076d423440,0x00000007aab00000)
  from space 174592K, 99% used [0x00000007aab00000,0x00000007b557fa08,0x00000007b5580000)
  to   space 174592K, 0% used [0x00000007b5580000,0x00000007b5580000,0x00000007c0000000)
 ParOldGen       total 2796544K, used 573766K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)
  object space 2796544K, 20% used [0x00000006c0000000,0x00000006e30518d8,0x000000076ab00000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成19991次，发生5次GC

### 结论：并行GC,使用的堆内存越大，GC频率越低，但每次耗时却越多，反之堆内存越小，GC越活跃，每次GC耗时小，与串行GC使用差别不大。

------

## CMSGC>>CMSGC

###  环境：-Xmx128m -Xms128m

java -Xmx128m -Xms128m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T21:04:37.632+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.634+0800: [ParNew: 34812K->4352K(39296K), 0.0030113 secs] 34812K->12170K(126720K), 0.0049658 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.646+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.646+0800: [ParNew: 39275K->4352K(39296K), 0.0048982 secs] 47094K->22639K(126720K), 0.0056799 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.656+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.657+0800: [ParNew: 39214K->4351K(39296K), 0.0080016 secs] 57501K->37375K(126720K), 0.0088220 secs] [Times: user=0.14 sys=0.02, real=0.01 secs]
2021-01-19T21:04:37.671+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.671+0800: [ParNew: 39295K->4346K(39296K), 0.0073794 secs] 72319K->51220K(126720K), 0.0092271 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.681+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 46873K(87424K)] 54579K(126720K), 0.0069385 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.689+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.692+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:37.692+0800: [CMS-concurrent-preclean-start]
2021-01-19T21:04:37.699+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.701+0800: [ParNew: 39273K->4341K(39296K), 0.0064805 secs] 86147K->63666K(126720K), 0.0145530 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.709+0800: [CMS-concurrent-preclean: 0.000/0.010 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
2021-01-19T21:04:37.717+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.718+0800: [ParNew: 39262K->4350K(39296K), 0.0088574 secs] 98586K->79031K(126720K), 0.0138393 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.730+0800: [GC (CMS Final Remark) [YG occupancy: 4508 K (39296 K)]2021-01-19T21:04:37.738+0800: [Rescan (parallel) , 0.0006970 secs]2021-01-19T21:04:37.739+0800: [weak refs processing, 0.0003158 secs]2021-01-19T21:04:37.740+0800: [class unloading, 0.0003843 secs]2021-01-19T21:04:37.740+0800: [scrub symbol table, 0.0004411 secs]2021-01-19T21:04:37.741+0800: [scrub string table, 0.0002722 secs][1 CMS-remark: 74681K(87424K)] 79189K(126720K), 0.0169657 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.748+0800: [CMS-concurrent-sweep-start]
2021-01-19T21:04:37.756+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.757+0800: [ParNew: 39284K->39284K(39296K), 0.0024471 secs]2021-01-19T21:04:37.759+0800: [CMS2021-01-19T21:04:37.760+0800: [CMS-concurrent-sweep: 0.004/0.004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 74681K->83443K(87424K), 0.0213410 secs] 113965K->83443K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0287879 secs] [Times: user=0.01 sys=0.00, real=0.03 secs]
2021-01-19T21:04:37.793+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.793+0800: [ParNew: 34944K->34944K(39296K), 0.0004076 secs]2021-01-19T21:04:37.794+0800: [CMS: 83443K->87083K(87424K), 0.0134037 secs] 118387K->93026K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0157848 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.810+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87083K(87424K)] 94656K(126720K), 0.0011362 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:37.811+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.822+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.822+0800: [CMS2021-01-19T21:04:37.824+0800: [CMS-concurrent-mark: 0.000/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87083K->86973K(87424K), 0.0237182 secs] 125734K->98979K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0249585 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.851+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.852+0800: [CMS: 86973K->87385K(87424K), 0.0125794 secs] 125786K->106469K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0202207 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.872+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87385K(87424K)] 108490K(126720K), 0.0015090 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:37.874+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.880+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.884+0800: [CMS2021-01-19T21:04:37.885+0800: [CMS-concurrent-mark: 0.001/0.005 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87385K->86943K(87424K), 0.0147084 secs] 126666K->108904K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0190962 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.903+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.906+0800: [CMS: 87366K->87350K(87424K), 0.0146000 secs] 126655K->114205K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0185710 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.922+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87350K(87424K)] 114841K(126720K), 0.0024647 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:37.925+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.927+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.935+0800: [CMS2021-01-19T21:04:37.936+0800: [CMS-concurrent-mark: 0.001/0.010 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87350K->87094K(87424K), 0.0205003 secs] 126564K->117178K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0294924 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
2021-01-19T21:04:37.958+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.959+0800: [CMS: 87094K->87322K(87424K), 0.0135336 secs] 126181K->118754K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0150490 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:37.974+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87322K(87424K)] 119883K(126720K), 0.0080084 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.983+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.989+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:37.990+0800: [CMS2021-01-19T21:04:37.991+0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87322K->87220K(87424K), 0.0144868 secs] 126527K->121317K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0156610 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.007+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.014+0800: [CMS: 87220K->87181K(87424K), 0.0125012 secs] 125915K->121230K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0207079 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.028+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87181K(87424K)] 122024K(126720K), 0.0014252 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.030+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:38.032+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.033+0800: [CMS2021-01-19T21:04:38.034+0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87181K->87351K(87424K), 0.0247794 secs] 126285K->122014K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0261080 secs] [Times: user=0.01 sys=0.00, real=0.03 secs]
2021-01-19T21:04:38.060+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.062+0800: [CMS: 87351K->87351K(87424K), 0.0050068 secs] 126370K->123245K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0106926 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.073+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87351K(87424K)] 123670K(126720K), 0.0013657 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.075+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:38.083+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.084+0800: [CMS2021-01-19T21:04:38.085+0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87351K->87381K(87424K), 0.0173539 secs] 126365K->123033K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0187186 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.107+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.107+0800: [CMS: 87381K->87287K(87424K), 0.0145737 secs] 126487K->123286K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0159266 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.124+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87287K(87424K)] 123997K(126720K), 0.0015371 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.126+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:38.126+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.127+0800: [CMS2021-01-19T21:04:38.128+0800: [CMS-concurrent-mark: 0.000/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 87402K->87335K(87424K), 0.0103932 secs] 126684K->124501K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0114124 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.139+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.140+0800: [CMS: 87389K->87279K(87424K), 0.0075950 secs] 126672K->125206K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0150468 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.155+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87279K(87424K)] 125279K(126720K), 0.0018002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.157+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:38.158+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.168+0800: [CMS2021-01-19T21:04:38.169+0800: [CMS-concurrent-mark: 0.000/0.011 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87279K->87243K(87424K), 0.0112894 secs] 126464K->125170K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0228233 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.182+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.190+0800: [CMS: 87243K->87243K(87424K), 0.0020992 secs] 126377K->125232K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0111167 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.193+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87243K(87424K)] 125975K(126720K), 0.0094788 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.203+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:38.204+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.214+0800: [CMS2021-01-19T21:04:38.215+0800: [CMS-concurrent-mark: 0.001/0.011 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 87351K->87315K(87424K), 0.0099892 secs] 126626K->126465K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0201299 secs] [Times: user=0.00 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.226+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.233+0800: [CMS: 87315K->87224K(87424K), 0.0053299 secs] 126569K->126439K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0148925 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.240+0800: [Full GC (Allocation Failure) 2021-01-19T21:04:38.248+0800: [CMS: 87224K->87205K(87424K), 0.0118149 secs] 126439K->126420K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0206141 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
2021-01-19T21:04:38.262+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 87205K(87424K)] 126420K(126720K), 0.0015436 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.264+0800Exception in thread "main" : [CMS-concurrent-mark-start]
java.lang.OutOfMemoryError: Java heap space2021-01-19T21:04:38.265+0800
:       at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:48)[CMS-concurrent-mark: 0.001/0.001 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T21:04:38.274+0800    at GCLogAnalysis.main(GCLogAnalysis.java:25): [CMS-concurrent-preclean-start]

2021-01-19T21:04:38.276+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:38.286+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T21:04:38.288+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
Heap
 par new generation   total 39296K, used 39275K [0x00000000f8000000, 0x00000000faaa0000, 0x00000000faaa0000)
  eden space 34944K, 100% used [0x00000000f8000000, 0x00000000fa220000, 0x00000000fa220000)
  from space 4352K,  99% used [0x00000000fa220000, 0x00000000fa65ae48, 0x00000000fa660000)
  to   space 4352K,   0% used [0x00000000fa660000, 0x00000000fa660000, 0x00000000faaa0000)
 concurrent mark-sweep generation total 87424K, used 87205K [0x00000000faaa0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2662K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 294K, capacity 386K, committed 512K, reserved 1048576K
2021-01-19T21:04:38.324+0800: [GC (CMS Final Remark) [YG occupancy: 39275 K (39296 K)]2021-01-19T21:04:38.325+0800: [Rescan (parallel) , 0.0017593 secs]2021-01-19T21:04:38.326+0800: [weak refs processing, 0.0003546 secs]2021-01-19T21:04:38.327+0800: [class unloading, 0.0004727 secs]2021-01-19T21:04:38.328+0800: [scrub symbol table, 0.0005564 secs]2021-01-19T21:04:38.329+0800: [scrub string table, 0.0072561 secs][1 CMS-remark: 87205K(87424K)] 126480K(126720K), 0.0144966 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

分析：

```
2021-01-19T21:04:37.632+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.634+0800: [ParNew: 34812K->4352K(39296K), 0.0030113 secs] 34812K->12170K(126720K), 0.0049658 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

 第一次创建 youngGC， young区总共 38M左右 ， young区从34M 变为 4M， 总共堆大小从34M 变为 12M ， 说明其中有 8M 进入了 老年区 总共花了 0.01s 。

进入FULL GC

```
2021-01-19T21:04:37.681+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 46873K(87424K)] 54579K(126720K), 0.0069385 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

即将进入STW

(CMS Initial Mark)：进入STW前的初始标记  ， 老年代代用了46M，老年代总共87M，堆用了54M，总共128M

```
2021-01-19T21:04:37.689+0800: [CMS-concurrent-mark-start]
2021-01-19T21:04:37.692+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
```

CMS 开始并发标记，这阶段持续了0.001s

```
2021-01-19T21:04:37.692+0800: [CMS-concurrent-preclean-start]
2021-01-19T21:04:37.699+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.701+0800: [ParNew: 39273K->4341K(39296K), 0.0064805 secs] 86147K->63666K(126720K), 0.0145530 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T21:04:37.709+0800: [CMS-concurrent-preclean: 0.000/0.010 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
```

CMS 开始并发预清理，统计前面 并发标记阶段 执行过程中发送了改变的对象。

```
2021-01-19T21:04:37.730+0800: [GC (CMS Final Remark) [YG occupancy: 4508 K (39296 K)]2021-01-19T21:04:37.738+0800: [Rescan (parallel) , 0.0006970 secs]2021-01-19T21:04:37.739+0800: [weak refs processing, 0.0003158 secs]2021-01-19T21:04:37.740+0800: [class unloading, 0.0003843 secs]2021-01-19T21:04:37.740+0800: [scrub symbol table, 0.0004411 secs]2021-01-19T21:04:37.741+0800: [scrub string table, 0.0002722 secs][1 CMS-remark: 74681K(87424K)] 79189K(126720K), 0.0169657 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
```

CMS 即将开始最终标记 ，需要开始执行STW， 用来标记所有老年代中的标记。 当前年轻代4M，总共38M， 重新扫描花了0.0007s，处理弱引用用了0.0003s，卸载不使用的类，用了0.0004s， 清理符号表花了0.0004s， 清理字符串花了0.00027s， 此阶段完成后 老年的内存为74M，总共87M， 堆内存79M，总共126M，用时0.017s

```
2021-01-19T21:04:37.748+0800: [CMS-concurrent-sweep-start]
```

CMS 开始并发清除标记

```
2021-01-19T21:04:37.756+0800: [GC (Allocation Failure) 2021-01-19T21:04:37.757+0800: [ParNew: 39284K->39284K(39296K), 0.0024471 secs]2021-01-19T21:04:37.759+0800: [CMS2021-01-19T21:04:37.760+0800: [CMS-concurrent-sweep: 0.004/0.004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
```

CMS 开始并发清除老年代中所有未被标记的对象、释放内存

```
 (concurrent mode failure): 86056K->87390K(87424K), 0.0257230 secs] 125286K->90431K(126720K), [Metaspace: 2632K->2632K(1056768K)], 0.0318100 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
```

　CMS垃圾收集器特有的错误，CMS的垃圾清理和引用线程是并行进行的，如果在并行清理的过程中老年代的空间不足以容纳应用产生的垃圾（**也就是老年代正在清理，从年轻代晋升了新的对象，或者直接分配大对象年轻代放不下导致直接在老年代生成，这时候老年代也放不下**），则会抛出“concurrent mode failure”。

重新进入STW循环

# concurrent mode failure影响

https://blog.csdn.net/muzhixi/article/details/105274542

老年代的垃圾收集器从CMS退化为Serial Old，所有应用线程被暂停，停顿时间变长。

###  环境：-Xmx512m -Xms512m

java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC   -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T22:46:31.387+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.388+0800: [ParNew: 139515K->17470K(157248K), 0.0083557 secs] 139515K->45596K(506816K), 0.0092070 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.414+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.414+0800: [ParNew: 157246K->17471K(157248K), 0.0126683 secs] 185372K->89686K(506816K), 0.0133329 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.444+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.444+0800: [ParNew: 157190K->17471K(157248K), 0.0224562 secs] 229405K->134098K(506816K), 0.0231132 secs] [Times: user=0.14 sys=0.02, real=0.02 secs]
2021-01-19T22:46:31.482+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.483+0800: [ParNew: 157247K->17472K(157248K), 0.0213552 secs] 273874K->174878K(506816K), 0.0221144 secs] [Times: user=0.14 sys=0.01, real=0.02 secs]
2021-01-19T22:46:31.520+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.521+0800: [ParNew: 157248K->17471K(157248K), 0.0228049 secs] 314654K->219267K(506816K), 0.0237550 secs] [Times: user=0.26 sys=0.05, real=0.02 secs]
2021-01-19T22:46:31.545+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 201796K(349568K)] 222119K(506816K), 0.0011482 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.546+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:31.548+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.549+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:31.550+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.550+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:46:31.563+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.563+0800: [ParNew: 157247K->17471K(157248K), 0.0210316 secs] 359043K->260281K(506816K), 0.0216876 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:46:31.600+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.601+0800: [ParNew: 157098K->17469K(157248K), 0.0207716 secs] 399908K->299979K(506816K), 0.0214111 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:46:31.638+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.638+0800: [ParNew: 157245K->17471K(157248K), 0.0218945 secs] 439755K->340399K(506816K), 0.0225517 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:46:31.678+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.678+0800: [ParNew: 157247K->157247K(157248K), 0.0006685 secs]2021-01-19T22:46:31.679+0800: [CMS2021-01-19T22:46:31.680+0800: [CMS-concurrent-abortable-preclean: 0.004/0.128 secs] [Times: user=0.52 sys=0.00, real=0.13 secs]
 (concurrent mode failure): 322928K->252642K(349568K), 0.0375221 secs] 480175K->252642K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0396323 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T22:46:31.736+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.736+0800: [ParNew: 139776K->17466K(157248K), 0.0072318 secs] 392418K->299710K(506816K), 0.0077266 secs] [Times: user=0.16 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.743+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 282243K(349568K)] 299847K(506816K), 0.0036617 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.747+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:31.748+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.750+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:31.750+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.759+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:46:31.764+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.765+0800: [ParNew: 157242K->17465K(157248K), 0.0090532 secs] 439486K->339927K(506816K), 0.0096785 secs] [Times: user=0.13 sys=0.02, real=0.01 secs]
2021-01-19T22:46:31.790+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.790+0800: [ParNew: 157241K->157241K(157248K), 0.0005072 secs]2021-01-19T22:46:31.791+0800: [CMS2021-01-19T22:46:31.791+0800: [CMS-concurrent-abortable-preclean: 0.002/0.032 secs] [Times: user=0.14 sys=0.02, real=0.04 secs]
 (concurrent mode failure): 322461K->293289K(349568K), 0.0426691 secs] 479703K->293289K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0441928 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T22:46:31.849+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.849+0800: [ParNew: 139776K->17471K(157248K), 0.0064295 secs] 433065K->339828K(506816K), 0.0069239 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.856+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 322356K(349568K)] 343112K(506816K), 0.0071947 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.864+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:31.866+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.03 sys=0.03, real=0.01 secs]
2021-01-19T22:46:31.874+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:31.882+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.883+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.885+0800: [ParNew: 157247K->157247K(157248K), 0.0004716 secs]2021-01-19T22:46:31.886+0800: [CMS (concurrent mode failure): 322356K->315730K(349568K), 0.0405318 secs] 479604K->315730K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0442540 secs] [Times: user=0.03 sys=0.00, real=0.05 secs]
2021-01-19T22:46:31.941+0800: [GC (Allocation Failure) 2021-01-19T22:46:31.941+0800: [ParNew: 139679K->17471K(157248K), 0.0169605 secs] 455409K->365254K(506816K), 0.0176362 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:46:31.959+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 347782K(349568K)] 368308K(506816K), 0.0013703 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.961+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:31.963+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.963+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:31.964+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.964+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:46:31.965+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:31.966+0800: [GC (CMS Final Remark) [YG occupancy: 66219 K (157248 K)]2021-01-19T22:46:31.966+0800: [Rescan (parallel) , 0.0022229 secs]2021-01-19T22:46:31.969+0800: [weak refs processing, 0.0003572 secs]2021-01-19T22:46:31.976+0800: [class unloading, 0.0004506 secs]2021-01-19T22:46:31.976+0800: [scrub symbol table, 0.0016261 secs]2021-01-19T22:46:31.978+0800: [scrub string table, 0.0003900 secs][1 CMS-remark: 347782K(349568K)] 414001K(506816K), 0.0135954 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.980+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:46:31.989+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:31.990+0800: [CMS-concurrent-reset-start]
2021-01-19T22:46:31.999+0800: [GC (Allocation Failure) 2021-01-19T22:46:32.000+0800: [ParNew (promotion failed): 157247K->157246K(157248K), 0.0118491 secs]2021-01-19T22:46:32.012+0800: [CMS2021-01-19T22:46:32.012+0800: [CMS-concurrent-reset: 0.000/0.013 secs] [Times: user=0.17 sys=0.00, real=0.02 secs]
: 345823K->333746K(349568K), 0.0421551 secs] 459166K->333746K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0552587 secs] [Times: user=0.19 sys=0.00, real=0.05 secs]
2021-01-19T22:46:32.069+0800: [GC (Allocation Failure) 2021-01-19T22:46:32.069+0800: [ParNew: 139776K->139776K(157248K), 0.0004112 secs]2021-01-19T22:46:32.070+0800: [CMS: 333746K->342329K(349568K), 0.0401951 secs] 473522K->342329K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0423810 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
2021-01-19T22:46:32.112+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 342329K(349568K)] 345628K(506816K), 0.0011166 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.113+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:32.115+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.116+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:32.117+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.117+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:46:32.117+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.117+0800: [GC (CMS Final Remark) [YG occupancy: 50407 K (157248 K)]2021-01-19T22:46:32.119+0800: [Rescan (parallel) , 0.0029346 secs]2021-01-19T22:46:32.121+0800: [weak refs processing, 0.0008348 secs]2021-01-19T22:46:32.122+0800: [class unloading, 0.0004753 secs]2021-01-19T22:46:32.127+0800: [scrub symbol table, 0.0004499 secs]2021-01-19T22:46:32.128+0800: [scrub string table, 0.0004162 secs][1 CMS-remark: 342329K(349568K)] 392736K(506816K), 0.0126871 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:32.130+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:46:32.132+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T22:46:32.138+0800: [CMS-concurrent-reset-start]
2021-01-19T22:46:32.142+0800: [GC (Allocation Failure) 2021-01-19T22:46:32.143+0800: [ParNew: 139776K->139776K(157248K), 0.0004510 secs]2021-01-19T22:46:32.143+0800: [CMS2021-01-19T22:46:32.144+0800: [CMS-concurrent-reset: 0.000/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
: 340526K->345130K(349568K), 0.0471641 secs] 480302K->345130K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0488084 secs] [Times: user=0.03 sys=0.00, real=0.05 secs]
2021-01-19T22:46:32.206+0800: [GC (Allocation Failure) 2021-01-19T22:46:32.206+0800: [ParNew: 139145K->139145K(157248K), 0.0004538 secs]2021-01-19T22:46:32.207+0800: [CMS: 345130K->344862K(349568K), 0.0402541 secs] 484275K->344862K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0424410 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
2021-01-19T22:46:32.249+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 344862K(349568K)] 345647K(506816K), 0.0013853 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.250+0800: [CMS-concurrent-mark-start]
2021-01-19T22:46:32.252+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.253+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:46:32.254+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.255+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:46:32.256+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2021-01-19T22:46:32.265+0800: [GC (CMS Final Remark) [YG occupancy: 120458 K (157248 K)]2021-01-19T22:46:32.266+0800: [Rescan (parallel) , 0.0009447 secs]2021-01-19T22:46:32.268+0800: [weak refs processing, 0.0004231 secs]2021-01-19T22:46:32.269+0800: [class unloading, 0.0004912 secs]2021-01-19T22:46:32.269+0800: [scrub symbol table, 0.0005103 secs]2021-01-19T22:46:32.270+0800: [scrub string table, 0.0004627 secs][1 CMS-remark: 344862K(349568K)] 465320K(506816K), 0.0151203 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:46:32.281+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:46:32.282+0800: [CMS-concurrent-sweep: 0.001/0.001 secs]2021-01-19T22:46:32.288+0800: [GC (Allocation Failure) 2021-01-19T22:46:32.290+0800: [ParNew: 139776K->139776K(157248K), 0.0009150 secs]2021-01-19T22:46:32.292+0800: [CMS [Times: user=0.00 sys=0.00, real=0.01 secs]
: 342712K->347395K(349568K), 0.0424438 secs] 482488K->347395K(506816K), [Metaspace: 2632K->2632K(1056768K)], 0.0518848 secs] [Times: user=0.03 sys=0.00, real=0.05 secs]
执行结束!共生成对象次数:10497
Heap
 par new generation   total 157248K, used 5616K [0x00000000e0000000, 0x00000000eaaa0000, 0x00000000eaaa0000)
  eden space 139776K,   4% used [0x00000000e0000000, 0x00000000e057c1e0, 0x00000000e8880000)
  from space 17472K,   0% used [0x00000000e9990000, 0x00000000e9990000, 0x00000000eaaa0000)
  to   space 17472K,   0% used [0x00000000e8880000, 0x00000000e8880000, 0x00000000e9990000)
 concurrent mark-sweep generation total 349568K, used 347395K [0x00000000eaaa0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成10497次

###  环境：-Xmx1g -Xms1g

java -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T22:47:19.996+0800: [GC (Allocation Failure) 2021-01-19T22:47:19.997+0800: [ParNew: 279616K->34944K(314560K), 0.0130008 secs] 279616K->95815K(1013632K), 0.0140849 secs] [Times: user=0.08 sys=0.08, real=0.01 secs]
2021-01-19T22:47:20.043+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.044+0800: [ParNew: 314036K->34940K(314560K), 0.0157900 secs] 374907K->179045K(1013632K), 0.0173036 secs] [Times: user=0.06 sys=0.09, real=0.02 secs]
2021-01-19T22:47:20.089+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.089+0800: [ParNew: 314556K->34942K(314560K), 0.0366885 secs] 458661K->260064K(1013632K), 0.0376440 secs] [Times: user=0.28 sys=0.03, real=0.04 secs]
2021-01-19T22:47:20.154+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.154+0800: [ParNew: 314558K->34943K(314560K), 0.0364833 secs] 539680K->331634K(1013632K), 0.0372851 secs] [Times: user=0.30 sys=0.01, real=0.04 secs]
2021-01-19T22:47:20.219+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.219+0800: [ParNew: 314559K->34944K(314560K), 0.0365415 secs] 611250K->405413K(1013632K), 0.0373025 secs] [Times: user=0.25 sys=0.06, real=0.04 secs]
2021-01-19T22:47:20.257+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 370469K(699072K)] 411224K(1013632K), 0.0010160 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.258+0800: [CMS-concurrent-mark-start]
2021-01-19T22:47:20.260+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.261+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:47:20.262+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.262+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:47:20.286+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.286+0800: [ParNew: 314560K->34944K(314560K), 0.0384450 secs] 685029K->482176K(1013632K), 0.0392823 secs] [Times: user=0.42 sys=0.05, real=0.04 secs]
2021-01-19T22:47:20.353+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.353+0800: [ParNew: 314560K->34940K(314560K), 0.0410808 secs] 761792K->566089K(1013632K), 0.0418772 secs] [Times: user=0.28 sys=0.03, real=0.04 secs]
2021-01-19T22:47:20.423+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.423+0800: [ParNew: 314556K->34943K(314560K), 0.0395087 secs] 845705K->644294K(1013632K), 0.0405829 secs] [Times: user=0.42 sys=0.05, real=0.04 secs]
2021-01-19T22:47:20.494+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.495+0800: [ParNew: 314559K->34941K(314560K), 0.0402595 secs] 923910K->725609K(1013632K), 0.0409465 secs] [Times: user=0.30 sys=0.02, real=0.04 secs]
2021-01-19T22:47:20.536+0800: [CMS-concurrent-abortable-preclean: 0.006/0.274 secs] [Times: user=1.53 sys=0.14, real=0.27 secs]
2021-01-19T22:47:20.537+0800: [GC (CMS Final Remark) [YG occupancy: 47179 K (314560 K)]2021-01-19T22:47:20.538+0800: [Rescan (parallel) , 0.0005085 secs]2021-01-19T22:47:20.538+0800: [weak refs processing, 0.0002822 secs]2021-01-19T22:47:20.539+0800: [class unloading, 0.0004664 secs]2021-01-19T22:47:20.540+0800: [scrub symbol table, 0.0005171 secs]2021-01-19T22:47:20.540+0800: [scrub string table, 0.0007024 secs][1 CMS-remark: 690667K(699072K)] 737847K(1013632K), 0.0040640 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.541+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:47:20.543+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.543+0800: [CMS-concurrent-reset-start]
2021-01-19T22:47:20.548+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:47:20.571+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.572+0800: [ParNew: 314557K->34943K(314560K), 0.0158717 secs] 862401K->658462K(1013632K), 0.0165315 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:47:20.588+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 623519K(699072K)] 659070K(1013632K), 0.0010791 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.590+0800: [CMS-concurrent-mark-start]
2021-01-19T22:47:20.595+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:47:20.600+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:47:20.601+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.603+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:47:20.604+0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.604+0800: [GC (CMS Final Remark) [YG occupancy: 168880 K (314560 K)]2021-01-19T22:47:20.605+0800: [Rescan (parallel) , 0.0005222 secs]2021-01-19T22:47:20.605+0800: [weak refs processing, 0.0003935 secs]2021-01-19T22:47:20.613+0800: [class unloading, 0.0015758 secs]2021-01-19T22:47:20.615+0800: [scrub symbol table, 0.0005239 secs]2021-01-19T22:47:20.615+0800: [scrub string table, 0.0017589 secs][1 CMS-remark: 623519K(699072K)] 792399K(1013632K), 0.0134825 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:47:20.618+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:47:20.620+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.621+0800: [CMS-concurrent-reset-start]
2021-01-19T22:47:20.634+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-01-19T22:47:20.636+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.645+0800: [ParNew: 314559K->34943K(314560K), 0.0173833 secs] 621977K->429320K(1013632K), 0.0269312 secs] [Times: user=0.16 sys=0.02, real=0.03 secs]
2021-01-19T22:47:20.692+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.692+0800: [ParNew: 314559K->34943K(314560K), 0.0179144 secs] 708936K->518984K(1013632K), 0.0187790 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:47:20.711+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 484040K(699072K)] 525193K(1013632K), 0.0019073 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.713+0800: [CMS-concurrent-mark-start]
2021-01-19T22:47:20.715+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.716+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:47:20.718+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:20.718+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:47:20.744+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.744+0800: [ParNew: 314559K->34942K(314560K), 0.0174364 secs] 798600K->597325K(1013632K), 0.0182530 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
2021-01-19T22:47:20.794+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.795+0800: [ParNew: 314558K->34943K(314560K), 0.0153795 secs] 876941K->674699K(1013632K), 0.0163507 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
2021-01-19T22:47:20.840+0800: [GC (Allocation Failure) 2021-01-19T22:47:20.841+0800: [ParNew: 314559K->314559K(314560K), 0.0004143 secs]2021-01-19T22:47:20.842+0800: [CMS2021-01-19T22:47:20.842+0800: [CMS-concurrent-abortable-preclean: 0.005/0.121 secs] [Times: user=0.38 sys=0.00, real=0.13 secs]
 (concurrent mode failure): 639756K->362142K(699072K), 0.0465882 secs] 954315K->362142K(1013632K), [Metaspace: 2632K->2632K(1056768K)], 0.0487086 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
执行结束!共生成对象次数:16059
Heap
 par new generation   total 314560K, used 11601K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,   4% used [0x00000000c0000000, 0x00000000c0b545c0, 0x00000000d1110000)
  from space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
  to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
 concurrent mark-sweep generation total 699072K, used 362142K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成16059次

###  环境：-Xmx2g -Xms2g

java -Xmx2g -Xms2g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T22:47:55.935+0800: [GC (Allocation Failure) 2021-01-19T22:47:55.936+0800: [ParNew: 559232K->69887K(629120K), 0.0206640 secs] 559232K->153375K(2027264K), 0.0216793 secs] [Times: user=0.02 sys=0.14, real=0.02 secs]
2021-01-19T22:47:56.018+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.018+0800: [ParNew: 629119K->69886K(629120K), 0.0258296 secs] 712607K->282475K(2027264K), 0.0268340 secs] [Times: user=0.13 sys=0.19, real=0.03 secs]
2021-01-19T22:47:56.102+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.103+0800: [ParNew: 629118K->69888K(629120K), 0.0524021 secs] 841707K->393885K(2027264K), 0.0535497 secs] [Times: user=0.47 sys=0.00, real=0.05 secs]
2021-01-19T22:47:56.213+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.214+0800: [ParNew: 629120K->69888K(629120K), 0.0612226 secs] 953117K->510379K(2027264K), 0.0625598 secs] [Times: user=0.47 sys=0.05, real=0.06 secs]
2021-01-19T22:47:56.332+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.332+0800: [ParNew: 629120K->69887K(629120K), 0.0651462 secs] 1069611K->640284K(2027264K), 0.0660299 secs] [Times: user=0.72 sys=0.05, real=0.07 secs]
2021-01-19T22:47:56.454+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.455+0800: [ParNew: 629119K->69886K(629120K), 0.0672741 secs] 1199516K->771095K(2027264K), 0.0681043 secs] [Times: user=0.59 sys=0.01, real=0.07 secs]
2021-01-19T22:47:56.523+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 701209K(1398144K)] 771239K(2027264K), 0.0004795 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:56.523+0800: [CMS-concurrent-mark-start]
2021-01-19T22:47:56.527+0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-01-19T22:47:56.528+0800: [CMS-concurrent-preclean-start]
2021-01-19T22:47:56.529+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:56.530+0800: [CMS-concurrent-abortable-preclean-start]
2021-01-19T22:47:56.582+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.583+0800: [ParNew2021-01-19T22:47:56.632+0800: [CMS-concurrent-abortable-preclean: 0.002/0.102 secs] [Times: user=0.58 sys=0.08, real=0.10 secs]
: 629118K->69887K(629120K), 0.0598150 secs] 1330327K->890624K(2027264K), 0.0605529 secs] [Times: user=0.53 sys=0.08, real=0.06 secs]
2021-01-19T22:47:56.642+0800: [GC (CMS Final Remark) [YG occupancy: 69923 K (629120 K)]2021-01-19T22:47:56.643+0800: [Rescan (parallel) , 0.0005837 secs]2021-01-19T22:47:56.643+0800: [weak refs processing, 0.0002263 secs]2021-01-19T22:47:56.643+0800: [class unloading, 0.0003468 secs]2021-01-19T22:47:56.644+0800: [scrub symbol table, 0.0004299 secs]2021-01-19T22:47:56.644+0800: [scrub string table, 0.0002567 secs][1 CMS-remark: 820737K(1398144K)] 890660K(2027264K), 0.0025537 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:56.645+0800: [CMS-concurrent-sweep-start]
2021-01-19T22:47:56.646+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2021-01-19T22:47:56.647+0800: [CMS-concurrent-reset-start]
2021-01-19T22:47:56.652+0800: [CMS-concurrent-reset: 0.005/0.005 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2021-01-19T22:47:56.703+0800: [GC (Allocation Failure) 2021-01-19T22:47:56.703+0800: [ParNew: 629119K->69886K(629120K), 0.0265275 secs] 1040374K->615867K(2027264K), 0.0272316 secs] [Times: user=0.31 sys=0.00, real=0.03 secs]
执行结束!共生成对象次数:16799
Heap
 par new generation   total 629120K, used 92791K [0x0000000080000000, 0x00000000aaaa0000, 0x00000000aaaa0000)
  eden space 559232K,   4% used [0x0000000080000000, 0x000000008165e388, 0x00000000a2220000)
  from space 69888K,  99% used [0x00000000a2220000, 0x00000000a665fbd8, 0x00000000a6660000)
  to   space 69888K,   0% used [0x00000000a6660000, 0x00000000a6660000, 0x00000000aaaa0000)
 concurrent mark-sweep generation total 1398144K, used 545980K [0x00000000aaaa0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成16799次

### 环境：-Xmx4g -Xms4g

java -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```
2021-01-19T22:48:26.894+0800: [GC (Allocation Failure) 2021-01-19T22:48:26.895+0800: [ParNew: 681600K->85184K(766784K), 0.0239613 secs] 681600K->173432K(4109120K), 0.0251021 secs] [Times: user=0.22 sys=0.09, real=0.02 secs]
2021-01-19T22:48:26.990+0800: [GC (Allocation Failure) 2021-01-19T22:48:26.991+0800: [ParNew: 766784K->85184K(766784K), 0.0311238 secs] 855032K->315943K(4109120K), 0.0322897 secs] [Times: user=0.06 sys=0.11, real=0.03 secs]
2021-01-19T22:48:27.090+0800: [GC (Allocation Failure) 2021-01-19T22:48:27.091+0800: [ParNew: 766784K->85184K(766784K), 0.0653829 secs] 997543K->449422K(4109120K), 0.0662170 secs] [Times: user=0.58 sys=0.05, real=0.07 secs]
2021-01-19T22:48:27.225+0800: [GC (Allocation Failure) 2021-01-19T22:48:27.225+0800: [ParNew: 766784K->85184K(766784K), 0.0596588 secs] 1131022K->570182K(4109120K), 0.0604333 secs] [Times: user=0.47 sys=0.02, real=0.06 secs]
2021-01-19T22:48:27.350+0800: [GC (Allocation Failure) 2021-01-19T22:48:27.351+0800: [ParNew: 766784K->85184K(766784K), 0.0687156 secs] 1251782K->711102K(4109120K), 0.0695632 secs] [Times: user=0.59 sys=0.03, real=0.07 secs]
2021-01-19T22:48:27.487+0800: [GC (Allocation Failure) 2021-01-19T22:48:27.488+0800: [ParNew: 766784K->85184K(766784K), 0.0714998 secs] 1392702K->851898K(4109120K), 0.0723451 secs] [Times: user=0.77 sys=0.02, real=0.07 secs]
执行结束!共生成对象次数:17842
Heap
 par new generation   total 766784K, used 756001K [0x00000006c0000000, 0x00000006f4000000, 0x00000006f4000000)
  eden space 681600K,  98% used [0x00000006c0000000, 0x00000006e8f184b8, 0x00000006e99a0000)
  from space 85184K, 100% used [0x00000006e99a0000, 0x00000006eecd0000, 0x00000006eecd0000)
  to   space 85184K,   0% used [0x00000006eecd0000, 0x00000006eecd0000, 0x00000006f4000000)
 concurrent mark-sweep generation total 3342336K, used 766714K [0x00000006f4000000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 291K, capacity 386K, committed 512K, reserved 1048576K
```

运行成功，对象生成17842次

### 结论：虚拟机内存<=3G的情况下完全不要考虑CMS GC，虚拟机内存>3G的情况下也优先选择ParallelOldGC，而不是CMS GC，只有在暂停时间无法接受的情况下才考虑CMS GC（不过当然，一般来说在虚拟机内存>8G后基本上都得选择CMS GC，否则那暂停时间是相当吓人的，除非是完全不在乎响应时间的应用）

------

## G1GC>>G1GC

### Xmx128m Xms128m 环境下

```
java -Xmx128m -Xms128m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

##### youngGC：

```
2021-01-19T23:01:41.018+0800: [GC pause (G1 Evacuation Pause) (young), 0.0039570 secs]
```

这次收集的类型——新生代收集，只回收Eden分区

这次收集花费的时间——0.0039570s，即3ms

```
   [Parallel Time: 1.8 ms, GC Workers: 10]
      [GC Worker Start (ms): Min: 99.4, Avg: 99.5, Max: 99.5, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.2, Diff: 0.1, Sum: 1.1]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Object Copy (ms): Min: 1.1, Avg: 1.1, Max: 1.2, Diff: 0.1, Sum: 11.4]
      [Termination (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.8]
         [Termination Attempts: Min: 1, Avg: 1.6, Max: 3, Diff: 2, Sum: 16]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
      [GC Worker Total (ms): Min: 1.3, Avg: 1.4, Max: 1.5, Diff: 0.1, Sum: 13.5]
      [GC Worker End (ms): Min: 100.8, Avg: 100.9, Max: 100.9, Diff: 0.0]
```

 **Parallel Time**：并行收集任务在运行过程中引发的STW（Stop The World）时间，从新生代垃圾收集开始到最后一个任务结束，共花费1.8ms

**GC Workers**：有10个线程负责垃圾收集，通过参数`-XX:ParallelGCThreads`设置，这个参数的值的设置，跟CPU有关，如果物理CPU支持的线程个数小于8，则最多设置为8；如果物理CPU支持的线程个数大于8，则默认值为number * 5/8

**GC Worker Start**：第一个垃圾收集线程开始工作时JVM启动后经过的时间（min）；最后一个垃圾收集线程开始工作时JVM启动后经过的时间（max）；diff表示min和max之间的差值。理想情况下，你希望他们几乎是同时开始，即diff趋近于0。

**Ext Root Scanning**：扫描root集合（线程栈、JNI、全局变量、系统表等等）花费的时间，扫描root集合是垃圾收集的起点，尝试找到是否有root集合中的节点指向当前的收集集合（CSet）

**Update RS(Remembered Set or RSet)**：每个分区都有自己的RSet，用来记录其他分区指向当前分区的指针，如果RSet有更新，G1中会有一个post-write barrier管理跨分区的引用——新的被引用的card会被标记为dirty，并放入一个日志缓冲区，如果这个日志缓冲区满了会被加入到一个全局的缓冲区，在JVM运行的过程中还有线程在并发处理这个全局日志缓冲区的dirty card。**Update RS**表示允许垃圾收集线程处理本次垃圾收集开始前没有处理好的日志缓冲区，这可以确保当前分区的RSet是最新的。

- **Processed Buffers**，这表示在Update RS这个过程中处理多少个日志缓冲区。

- **Scan RS**：扫描每个新生代分区的RSet，找出有多少指向当前分区的引用来自CSet。

- **Code Root Scanning**：扫描代码中的root节点（局部变量）花费的时间

- **Object Copy**：在疏散暂停期间，所有在CSet中的分区必须被转移疏散，Object Copy就负责将当前分区中存活的对象拷贝到新的分区。

- Termination

  ：当一个垃圾收集线程完成任务时，它就会进入一个临界区，并尝试帮助其他垃圾线程完成任务（steal outstanding tasks），min表示该垃圾收集线程什么时候尝试terminatie，max表示该垃圾收集回收线程什么时候真正terminated。

  - **Termination Attempts**：如果一个垃圾收集线程成功盗取了其他线程的任务，那么它会再次盗取更多的任务或再次尝试terminate，每次重新terminate的时候，这个数值就会增加。

- **GC Worker Other**：垃圾收集线程在完成其他任务的时间

- **GC Worker Total**：展示每个垃圾收集线程的最小、最大、平均、差值和总共时间。

- **GC Worker End**：min表示最早结束的垃圾收集线程结束时该JVM启动后的时间；max表示最晚结束的垃圾收集线程结束时该JVM启动后的时间。理想情况下，你希望它们快速结束，并且最好是同一时间结束。

```
 [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.6 ms]
```

   **Code Root Fixup** ：释放用于管理并行垃圾收集活动的数据结构，应该接近于0，该步骤是线性执行的；

- **Code Root Purge**：清理更多的数据结构，应该很快，耗时接近于0，也是线性执行。
- **Clear CT**：清理card table

```
[Other: 1.5 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.5 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.5 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
```

**Choose CSet**：选择要进行回收的分区放入CSet（G1选择的标准是垃圾最多的分区优先，也就是存活对象率最低的分区优先）

- **Ref Proc**：处理Java中的各种引用——soft、weak、final、phantom、JNI等等。
- **Ref Enq**：遍历所有的引用，将不能回收的放入pending列表
- **Redirty Card**：在回收过程中被修改的card将会被重置为dirty
- **Humongous Register**：JDK8u60提供了一个特性，巨型对象可以在新生代收集的时候被回收——通过`G1ReclaimDeadHumongousObjectsAtYoungGC`设置，默认为true。
- **Humongous Reclaim**：做下列任务的时间：确保巨型对象可以被回收、释放该巨型对象所占的分区，重置分区类型，并将分区还到free列表，并且更新空闲空间大小。
- **Free CSet**：将要释放的分区还回到free列表。

```
   [Eden: 24.0M(24.0M)->0.0B(23.0M) Survivors: 0.0B->3072.0K Heap: 30.4M(128.0M)->13.1M(128.0M)]
```

**Eden:24.0M(24.0M)->0.0B(23.0M)**：（1）当前新生代收集触发的原因是Eden空间满了，分配了24M，使用了24M；（2）所有的Eden分区都被疏散处理了，在新生代结束后Eden分区的使用大小成为了0.0B；（3）Eden分区的大小缩小为23.0M

- **Survivors:0.0b->3072k**：由于年轻代分区的回收处理，survivor的空间从0b涨到3M；
- **Heap:30.4M(128.0M)->13.1M(128.0M)**：（1）在本次垃圾收集活动开始的时候，堆空间整体使用量是30..4M，堆空间的最大值是128M；（2）在本次垃圾收集结束后，堆空间的使用量是13.1M，最大值保持不变。

```
 [Times: user=0.00 sys=0.00, real=0.01 secs]
```

**user=0.8**：垃圾收集线程在新生代垃圾收集过程中消耗的CPU时间，这个时间跟垃圾收集线程的个数有关，可能会比real time大很多；

**sys=0.0**：内核态线程消耗的CPU时间
-**real=0.03**：本次垃圾收集真正消耗的时间；



##### 标记到清理：

```
2021-01-19T23:01:41.132+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0058373 secs]
```

 初始标记，耗时0.0058s

```
 [Parallel Time: 2.9 ms, GC Workers: 10]
```

并行10个进程

```
      [GC Worker Start (ms): Min: 213.9, Avg: 213.9, Max: 214.0, Diff: 0.1]
      [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.1, Sum: 0.9]
```

  每个扫描root的线程耗时

```
    [Update RS (ms): Min: 0.4, Avg: 0.4, Max: 0.5, Diff: 0.0, Sum: 4.4]
```

更新RS的耗时，G1中每块区域都有一个RS与之对应，RS记录了该区域被其他区域引用的对象。回收时，就把RS作为根集的一部分，从而加快回收

```
    [Processed Buffers: Min: 6, Avg: 7.3, Max: 8, Diff: 2, Sum: 73]
```

 Processed Buffers就是记录引用变化的缓存空间

```
   [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
```

  扫描RS

```
    [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
```

​      根扫描耗时

```
[Object Copy (ms): Min: 1.5, Avg: 1.6, Max: 1.7, Diff: 0.3, Sum: 16.0]
```

​      对象拷贝

```
[Termination (ms): Min: 0.0, Avg: 0.1, Max: 0.3, Diff: 0.3, Sum: 1.4]
         [Termination Attempts: Min: 1, Avg: 1.1, Max: 2, Diff: 1, Sum: 11]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 2.2, Avg: 2.3, Max: 2.4, Diff: 0.1, Sum: 22.9]
```

​    GC线程耗时

```
  [GC Worker End (ms): Min: 216.2, Avg: 216.2, Max: 216.2, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.8 ms]
```

清空CardTable耗时，RS是依赖CardTable记录区域存活对象的

```
 [Other: 2.1 ms]
      [Choose CSet: 0.0 ms]
```

选取CSet

```
      [Ref Proc: 0.6 ms]
```

弱引用、软引用的处理耗时

```
      [Ref Enq: 0.0 ms]
```

弱引用、软引用的入队耗时

```
   [Redirty Cards: 0.7 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
   [Free CSet: 0.0 ms]
```

  释放被回收区域的耗时（包含他们的RS）

 [Eden: 37.0M(45.0M)->0.0B(36.0M) Survivors: 5120.0K->7168.0K Heap: 85.8M(128.0M)->54.9M(128.0M)]
 [Times: user=0.00 sys=0.00, real=0.08 secs]

   [Eden: 37.0M(45.0M)->0.0B(36.0M) Survivors: 5120.0K->7168.0K Heap: 85.8M(128.0M)->54.9M(128.0M)]
 [Times: user=0.00 sys=0.00, real=0.08 secs]

并发收集：



```
2021-01-19T23:01:41.208+0800: [GC concurrent-root-region-scan-start]
2021-01-19T23:01:41.218+0800: [GC pause (G1 Evacuation Pause) (young)2021-01-19T23:01:41.219+0800: [GC concurrent-root-region-scan-end, 0.0103172 secs]
```

表示第并发标记阶段做的第一个事情：根分区扫描

- **GC concurrent-root-region-scan-start**：根分区扫描开始，根分区扫描主要扫描的是新的survivor分区，找到这些分区内的对象指向当前分区的引用，如果发现有引用，则做个记录；

- **GC concurrent-root-region-scan-end**：根分区扫描结束，耗时0.0030613s

  ```
  2021-01-19T23:01:41.220+0800: [GC concurrent-mark-start]
  
  2021-01-19T23:01:41.295+0800: [GC concurrent-mark-end, 0.0752384 secs]
  ```

  表示并发标记阶段

  - **GC Concurrent-mark-start**：并发标记阶段开始。（1）并发标记阶段的线程是跟应用线程一起运行的，不会STW，所以称为并发；并发标记阶段的垃圾收集线程，默认值是Parallel Thread个数的25%，这个值也可以用参数`-XX:ConcGCThreads`设置；（2）trace整个堆，并使用位图标记所有存活的对象，因为在top TAMS之前的对象是隐式存活的，所以这里只需要标记出那些在top TAMS之后、阈值之前的；（3）记录在并发标记阶段的变更，G1这里使用了SATB算法，该算法要求在垃圾收集开始的时候给堆做一个快照，在垃圾收集过程中这个快照是不变的，但实际上肯定有些对象的引用会发生变化，这时候G1使用了pre-write barrier记录这种变更，并将这个记录存放在一个SATB缓冲区中，如果该缓冲区满了就会将它加入到一个全局的缓冲区，同时G1有一个线程在并行得处理这个全局缓冲区；（4）在并发标记过程中，会记录每个分区的存活对象占整个分区的大小的比率；
  - **GC Concurrent-mark-end**：并发标记阶段结束，耗时0.3055438s

  ```
  2021-01-19T23:01:41.376+0800: [GC remark 2021-01-19T23:01:41.377+0800: [Finalize Marking, 0.0004121 secs] 2021-01-19T23:01:41.379+0800: [GC ref-proc, 0.0004030 secs] 2021-01-19T23:01:41.379+0800: [Unloading, 0.0009872 secs], 0.0039986 secs]
   [Times: user=0.00 sys=0.00, real=0.01 secs]
  ```

  重新标记阶段，会Stop the World

  - **Finalize Marking**：Finalizer列表里的Finalizer对象处理，耗时0.0014099s；
  - **GC ref-proc**：引用（soft、weak、final、phantom、JNI等等）处理，耗时0.0000480s；
  - **Unloading**：类卸载，耗时0.0025840s；
  - 除了前面这几个事情，这个阶段最关键的结果是：绘制出当前并发周期中整个堆的最后面貌，剩余的SATB缓冲区会在这里被处理，所有存活的对象都会被标记；

  ```
  2021-01-19T23:01:41.388+0800: [GC cleanup 95M->95M(128M), 0.0028016 secs]
   [Times: user=0.00 sys=0.00, real=0.00 secs]
  ```

  清理阶段，也会Stop the World

  - 计算出最后存活的对象：标记出initial-mark阶段后分配的对象；标记出至少有一个存活对象的分区；
  - 为下一个并发标记阶段做准备，previous和next位图会被清理；
  - 没有存活对象的老年代分区和巨型对象分区会被释放和清理；
  - 处理没有任何存活对象的分区的RSet；
  - 所有的老年代分区会按照自己的存活率（存活对象占整个分区大小的比例）进行排序，为后面的CSet选择过程做准备；

##### 混合收集：

```
2021-01-19T23:01:41.758+0800: [GC pause (G1 Evacuation Pause) (mixed), 0.0066247 secs]
```

   表示这是一个混合垃圾收集周期；在混合垃圾收集处理的CSet不仅包括新生代的分区，还包括老年代分区——也就是并发标记阶段标记出来的那些老年代分区。

```
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.3 ms]
```

```
   [Other: 5.1 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.3 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.7 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
```

```
   [Eden: 5120.0K(5120.0K)->0.0B(6144.0K) Survivors: 1024.0K->1024.0K Heap: 101.5M(128.0M)->89.9M(128.0M)]
```

```
 [Times: user=0.00 sys=0.00, real=0.08 secs]
```

##### Full GC：

```
2021-01-20T19:10:53.957+0800: [Full GC (Allocation Failure)  110M->92M(128M), 0.0114223 secs]
   [Eden: 0.0B(6144.0K)->0.0B(6144.0K) Survivors: 0.0B->0.0B Heap: 110.7M(128.0M)->92.1M(128.0M)], [Metaspace: 2632K->2632K(1056768K)]
 [Times: user=0.00 sys=0.00, real=0.01 secs]
```

如果堆内存空间不足以分配新的对象，或者是Metasapce空间使用率达到了设定的阈值，那么就会触发Full GC——你在使用G1的时候应该尽量避免这种情况发生，因为G1的Full Gc是单线程、会Stop The World，代价非常高。Full GC的日志如下图所示，从中你可以看出三类信息

1. Full GC的原因，这个图里是Allocation Failure，还有一个常见的原因是Metadata GC Threshold；

2. Full GC发生的频率，每隔几天发生一次Full GC还可以接受，但是每隔1小时发生一次Full GC则不可接受；

3. Full GC的耗时，这张图里的Full GC耗时150ms（PS：按照我的经验，实际运行中如果发生Full GC，耗时会比这个多很多）

   参考资料：https://www.cnblogs.com/javaadu/p/11220234.html

   执行结束，生成对象次数：1069

### Xmx512m Xms512m 环境下

```
java -Xmx512m -Xms512m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

结果：执行结束!共生成对象次数:4801

### Xmx1g Xms1g 环境下

```
java -Xmx1g -Xms1g -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

结果：执行结束!共生成对象次数:8651

### Xmx2g Xms2g 环境下

```
java -Xmx2g -Xms2g  -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

结果：执行结束!共生成对象次数:9920

### Xmx4g Xms4g 环境下

```
java -Xmx4g -Xms4g -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```

结果：执行结束!共生成对象次数:12041

##### 结论：

 G1 GC的效率 和最大堆内存存在着关系