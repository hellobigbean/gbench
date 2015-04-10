# GBench 0.4.1 Release Notes #

  * Added `maxWarmUpTime` option for `BenchmarkBuilder` to limit the time of warm up in auto mode. It is set 60 secs by default.
  * Fixed [issue 8](https://code.google.com/p/gbench/issues/detail?id=8): BenchmarkWarumUp#run may loop very long or even forever