### Version Numbering Scheme ###
```
[major].[minor].[maintenance]-groovy-[groovy_major].[groovy_minor]
```


---

### Install from Maven Central ###
Grape:
```
@Grab('com.googlecode.gbench:gbench:0.3.1-groovy-2.0')
// @Grab('com.googlecode.gbench:gbench:0.3.1-groovy-1.8')
// @Grab('com.googlecode.gbench:gbench:0.3.1-groovy-1.7')
```
Maven:
```
<dependency>
  <groupId>com.googlecode.gbench</groupId>
  <artifactId>gbench</artifactId>
  <version>0.3.1-groovy-2.0</version>
  <!-- <version>0.3.1-groovy-1.8</version> -->
  <!-- <version>0.3.1-groovy-1.7</version> -->
</dependency>
```
Ivy:
```
<dependency org="com.googlecode.gbench" 
  name="gbench" 
  rev="0.3.1-groovy-2.0" />
<!--   rev="0.3.1-groovy-1.8" /> -->
<!--   rev="0.3.1-groovy-1.7" /> -->
```

---

### Install from source ###
```
git clone https://code.google.com/p/gbench/ gbench
cd gbench
git checkout refs/tags/v0.3.1
ant dist -Dgroovy.version.major=2.0 -Dgroovy.version.minor=0
# ant dist -Dgroovy.version.major=1.8 -Dgroovy.version.minor=6
# ant dist -Dgroovy.version.major=1.7 -Dgroovy.version.minor=10
cp dist/*.jar /path/to/lib
```