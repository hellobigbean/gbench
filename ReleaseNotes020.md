# GBench 0.2.0 Release Notes #

  * Added support for CPU time.
  * Improved the builder API.
  * Added better (Groovier) syntax to add benchmark target code blocks.
```
   // old syntax
   run {
       with 'label', {
       }
   }
   // new syntax
   run {
       label {
       }
   }
```
  * Added new options for run().
    * "average", "idle", "trim". See its javadoc for usage. Thanks to Yasuharu Nakano (author of [GroovyServ](http://kobo.github.com/groovyserv/)) for providing the source code.
    * "repeat". This option is an alternative to "time" option, but "time" option still available for backward compatibility.
  * Added new APIs.
    * sum(), average(), prettyPrint(). See their javadoc for usage.
  * Changed versioning scheme.
    * YY.MM.DD -> Major.Minor.Micro
  * Fixed a bug that the name of the system property to specify @Benchmark's default handling contains the old domain.
    * groovybenchmark.sf.net.defaulthandle => gbench.defaulthandle