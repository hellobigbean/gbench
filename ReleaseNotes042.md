# GBench 0.4.2 Release Notes #

  * New system properties
```
groovy -Dgbench.warmUpTime=3
groovy -Dgbench.maxWarmUpTime=10
groovy -Dgbench.verbose=true
groovy -Dgbench.quiet=true
```
```
System.setProperty("gbench.warmUpTime", 3)
System.setProperty("gbench.maxWarmUpTime", 10)
System.setProperty("gbench.verbose", true)
System.setProperty("gbench.quiet", true)
```

  * Fixed [Issue 10](https://code.google.com/p/gbench/issues/detail?id=10): There is a case that CPU time is nagative
  * Fixed [Issue 16](https://code.google.com/p/gbench/issues/detail?id=16):The times of benchmarking a closure that does nothing aren't zero
  * Fixed [Issue 17](https://code.google.com/p/gbench/issues/detail?id=17):@Benchmark has same problems with [issue 10](https://code.google.com/p/gbench/issues/detail?id=10) and [issue 16](https://code.google.com/p/gbench/issues/detail?id=16).
  * Fixed [Issue 11](https://code.google.com/p/gbench/issues/detail?id=11):maxWarmUpTime option for BenchmarkBuilder.run() is not written in its Javadoc
  * Fixed [Issue 13](https://code.google.com/p/gbench/issues/detail?id=13):ant javadoc fails