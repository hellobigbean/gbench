# GBench 0.3.0 Release Notes #

  * New BenchmarkBuilder that allows automated and accurate micro-benchmark. Groovy is a difficult language to accurately benchmark. Method caching, Reflection inflation (Groovy implicitly uses Reflection API) and other dynamic optimization, garbage collection... there are many factors that interfere measurement. You can resolve the issues by using BenchmarkBuilder. See also my entry ["Right Groovy Benchmarking"](http://nagaimasato.blogspot.jp/2012/03/right-groovy-benchmarking.html)

```
import gbench.*

new BenchmarkBuilder().run {
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
}.prettyPrint()

/* Output:
Environment
===========
* Groovy: 1.8.6
* JVM: Java HotSpot(TM) 64-Bit Server VM (23.0-b15, Oracle Corporation)
    * JRE: 1.7.0_04-ea
    * Total Memory: 99.4375 MB
    * Maximum Memory: 1169.8125 MB
* OS: Mac OS X (10.7.3, amd64) 

Options
=======
* Warm Up: Auto 
* CPU Time Measurement: On

	       user  system  cpu  real

StringBuilder   236       0  236   237
StringBuffer    263       0  263   267
*/
```
  * Change system properties for @Benchmark. Now two properties are available: gbench.defaultHandler, gbench.measureCpuTime