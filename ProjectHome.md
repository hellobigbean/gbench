### OVERVIEW ###

**GBench** is a benchmarking module for [Groovy](http://groovy.codehaus.org/). It allows you to compare the performance of programs. GBench is a sub-project of **[GPerfUtils](http://gperfutils.org)**.

GBench has two features: Benchmark Builder and Benchmark Transformation.

Benchmark Builder allows you to correctly benchmark programs. Groovy is a difficult language to accurately benchmark. Method caching, dynamic optimization and garbage collection by JVM, there are many factors that interfere measurement. You can resolve the issues by using Benchmark Builder. See also _["Right Groovy Benchmarking"](http://nagaimasato.blogspot.com/2012/03/right-groovy-benchmarking.html)_ for understanding what the "correctly" means.

Benchmark Transformation allows you to measure methods’ execution time without additional code.

### VERSIONING ###

GBench has different versions for different Groovy versions.
```
  [major].[minor].[maintenance]-groovy-[groovy_major].[groovy_minor]
```

For example, the versions of GBench 0.4.3 that supports from Groovy 1.7
to Groovy 2.4 are:
```
  0.4.3-groovy-1.7, 0.4.3-groovy-1.8, 0.4.3-groovy-2.0, 0.4.3-groovy-2.1,
  0.4.3-groovy-2.2, 0.4.3-groovy-2.3, 0.4.3-groovy-2.4
```


---


### DOWNLOADING ###

Download a distribution from the Maven Central repository using a
dependency manager of your choice.

Groovy Grape
```
  @Grab(group='org.gperfutils', module='gbench', version='[version]')
```

Apache Maven
```
  <dependency>
    <groupId>org.gperfutils</groupId>
    <artifactId>gbench</artifactId>
    <version>[version]</version>
  </dependency>
```

Apache Ivy
```
  <dependency org="org.gperfutils" name="gbench" rev="[version]" />
```

### BUILDING ###

Download the source from [the repository](https://github.com/gperfutils/gbench) and build using Ant.

Distribution
```
  ant dist -Dskip.test=true
```

Binary jar for a specific Groovy version
```
  ant binary -Dgroovy.version=[groovy_version] -Dskip.test=true
```


---


### EXAMPLES ###

Compare the performance of `StringBuilder` and `StringBuffer` using Benchmark Builder:
```
  def r = benchmark {   // or new groovyx.gbench.BenchmarkBuilder().run {
      'StringBuilder' {
          def sb = new StringBuilder()
          sb.append('foo')
          sb.append('bar')
          sb.append('baz')
          sb.toString()
      }
      'StringBuffer' {
          def sb = new StringBuffer()
          sb.append('foo')
          sb.append('bar')
          sb.append('baz')
          sb.toString()
      }
  }
  r.prettyPrint()

  /* stdout:
  Environment
  ===========
  * Groovy: 2.4.0
  * JVM: Java HotSpot(TM) 64-Bit Server VM (24.75-b04, Oracle Corporation)
      * JRE: 1.7.0_75
      * Total Memory: 491.5 MB
      * Maximum Memory: 910.5 MB
  * OS: Mac OS X (10.10.1, x86_64)

  Options
  =======
  * Warm Up: Auto (- 60 sec)
  * CPU Time Measurement: On

                 user  system  cpu  real

  StringBuilder   115       0  115   117
  StringBuffer    132       0  132   133
  */
```
Measure the execution time of a method using Benchmark Transformation:
```
  import groovyx.gbench.Benchmark

  class Task {
      @Benchmark void run() {
          // task
      }
  }

  /* stdout:
  Task  void run()  user:847000 system:1777000 cpu:2624000 real:4918000
  */
```

Other examples are available [here](https://github.com/gperfutils/gbench/tree/master/src/demo).


---


### NEWS ###

  * 2015-02-14 GBench 0.4.3 released [ReleaseNotes043](ReleaseNotes043.md)
  * 2013-03-26 GBench 0.4.2 released [ReleaseNotes042](ReleaseNotes042.md)
  * 2013-03-08 GBench 0.4.1 released [ReleaseNotes041](ReleaseNotes041.md)
  * 2012-11-03 GBench 0.4.0 released [ReleaseNotes040](ReleaseNotes040.md)
  * 2012-07-07 GBench 0.3.1 released [ReleaseNotes031](ReleaseNotes031.md)
  * 2012-03-17 GBench 0.3.0 released [ReleaseNotes030](ReleaseNotes030.md)
  * 2011-09-09 GBench 0.2.2 released [ReleaseNotes022](ReleaseNotes022.md)
  * 2011-09-09 GBench 0.2.1 released [ReleaseNotes021](ReleaseNotes021.md)
  * 2011-07-20 GBench 0.2.0 released [ReleaseNotes020](ReleaseNotes020.md)
  * 2011-06-25 GBench was born!


---


### THANKS ###

> [![](https://www.jetbrains.com/idea/docs/logo_intellij_idea.png)](https://www.jetbrains.com/idea/)