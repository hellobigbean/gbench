### STEP 1: RUN IN AUTO MODE ###

**`BenchmarkBuilder`** class or **`benchmark`** built-in function runs in auto mode by default. In auto mode, the builder warms up your code until JVM finishes optimization and benchmark is stable. Let's run with **`verbose`** option for tracking what the builder does while benchmarking.
```
def r = benchmark(verbose:true) {
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
```

**`BenchmarkBuider`** prints out environment and options at first.
```
Environment
===========
* Groovy: 2.1.1
* JVM: Java HotSpot(TM) 64-Bit Server VM (23.7-b01, Oracle Corporation)
    * JRE: 1.7.0_17
    * Total Memory: 96.9375 MB
    * Maximum Memory: 1141.375 MB
* OS: Mac OS X (10.8.2, x86_64) 

Options
=======
* Warm Up: Auto (- 60 sec) 
* CPU Time Measurement: On
```
Then it starts benchmarking and printing out what it is doing.
```
Warming up "StringBuilder"...
Measuring "StringBuilder"...
Warming up "StringBuffer"...
Measuring "StringBuffer"...
```
After the benchmarking is completed, **`prettyPrint()`** prints out  means (in nanoseconds) of each execution time in table format.
```
               user  system  cpu  real

StringBuilder   200       0  201   201
StringBuffer    234       0  234   235
```

### STEP 2: RUN IN MANUAL MODE ###

**`BenchmarkBuilder`** also has manual mode. In manual mode, the builder warms up for specified time. The following example warms up your code for 3 seconds.
```
def r = benchmark(warmUpTime:3) {
    //
}
```

### STEP 3: LEARN ALL OF THE OPTIONS ###

| **Option and Default Value** | **Deescription** |
|:-----------------------------|:-----------------|
| measureCpuTime=true | Measures CPU time |
| warmUpTime=AUTO | Auto warm up or manual warm up with time in seconds|
| maxWarmUpTime=60 | Maximum time for auto warm up |
| quiet=false | Does not print out anything. |
| verbose=false | Prints out details about the benchmarking process. |