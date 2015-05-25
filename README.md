# java-compatibility
Add java api classes to bootclasspath when sourceCompatibility is set.

# usage

apply plugin: java-compatibility

sourceCompatibility = 1.6

# how it works

* The plugin search for rt.jar based on JAVA_HOME parent directory. In most distributions it contains all jdk and jre versions.
* If JDK*_HOME is defined, it's taken in the first place.

# tests

Tested with java 7 and 8 compilers on java 6, 7 and 8 compatibility.
