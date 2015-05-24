package com.ullink.gradle

import groovy.mock.interceptor.MockFor;
import spock.lang.*
import static com.ullink.gradle.JavaAPIVersion.choose_java
import static com.ullink.gradle.JavaAPIVersion.find_java
import org.gradle.tooling.BuildException

class CompatibilityTest extends spock.lang.Specification {

    def "Choose the first jdk 6" () {
        given:
            def java_versions = ["jdk1.6.0_01", "jdk1.6.0_45"]
        expect:
            "jdk1.6.0_01" == choose_java(java_versions)
    }

    def "Choose the first between jre 6 and jdk 6" () {
        given:
            def java_versions = ["jre6",  "jdk1.6.0_01"]
        expect:
            "jre6" == choose_java(java_versions)
    }

    def "When JDK6_HOME is undefined, look at JAVA_HOME" () {
        when:
            String JDK_HOME = null
            String JAVA_HOME_path = find_java(version, JDK_HOME, JAVA_HOME)
        then:
            JAVA_HOME_path == expectedMessage
        where:
            version | JAVA_HOME | expectedMessage
            6 | "jre_for_test/jre6" | new File("jre_for_test/jre6/lib/rt.jar").toString()
            7 | "jre_for_test/jre7" | new File("jre_for_test/jre7/lib/rt.jar").toString()
    }
}
// TODO add some test "when rt.jar is not in jre or jdk" (very unlikely to happen but should raise some exception)
