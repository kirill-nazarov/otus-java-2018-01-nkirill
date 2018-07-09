package ru.otus.l41;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/*
-Xmx256m
-Xms256m
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-Xloggc:./logs/serial_gc.log
-XX:GCLogFileSize=1M
======================-XX:+UseSerialGC
-XX:+UseParallelGC
-XX:+UseParallelOldGC
-XX:+UseConcMarkSweepGC
 */

public class Main {
    public static void main(String... args) throws Exception {
        System.out.println("Starting pid: " + ManagementFactory.getRuntimeMXBean().getName());
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ru.otus:type=Benchmark");
        Benchmark mbean = new Benchmark();
        mbs.registerMBean(mbean, name);
        int size = 5000;
        mbean.setSize(size);
        mbean.run();
    }

}
