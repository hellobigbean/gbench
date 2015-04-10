# GBench 0.4.0 Release Notes #

  * New package name "groovyx.gbench"
  * Extension modules that run `BenchmarkBuilder`
```
benchmark {
    'foo' {
	// code
    }
    'bar' {
	// code
    }
}.prettyPrint()
```
```
{
    'foo' {
	// code
    }
    'bar' {
	// code
    }
}.benchmark().prettyPrint()
```
  * Improve performance both of `@Benchmark` and `BenchmarkBuilder`
  * Reduce the size of jar