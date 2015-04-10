# GBench 0.2.1 Release Notes #

  * Added a system property for enabling / disabling CPU time measurement. See javadoc of `@Benchmark` and `BenchmarkBuilder` for details.
  * Added a system property for tracing in `BenchmarkBuilder`. See javadoc of `BenchmarkBuilder` for details.
  * Fixed the "idle" option for warm-up does not work well.
  * Fixed Benchmark AST Transformation fails on a JVM which does not support CPU time measurement.