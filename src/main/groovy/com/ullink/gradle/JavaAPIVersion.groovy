package com.ullink.gradle

import org.gradle.tooling.BuildException

class JavaAPIVersion {

    def static String find_java(int version, String jdk_home, String java_home) {
        boolean jdk6_home_undefined = jdk_home == null || jdk_home.isEmpty()
        if (jdk6_home_undefined && java_home.isEmpty()) {
            throw new BuildException("To ensure java $version compatibility, JDK${version}_HOME or JAVA_HOME should be defined")
        }
        if (! jdk6_home_undefined) {
            return [jdk_home, "jre", "lib", "rt.jar"].iterator().join(File.separator)
        }
        File javaHomeDir = new File(java_home)
        List<String> java_versions = []
        javaHomeDir.parentFile.eachDirMatch(~/.*jdk1.$version.*/) {path -> java_versions.add(path)}
        if (! java_versions.empty) {
            return [choose_java(java_versions), "jre", "lib", "rt.jar"].iterator().join(File.separator)
        }

        javaHomeDir.parentFile.eachDirMatch(~/.*jre$version.*/) {path -> java_versions.add(path)}
        if (java_versions == null || java_versions.isEmpty()) {
            System.err.println "No jdk or jre $version found: api compatibility can't be enforced"
        } else {
            return [choose_java(java_versions), "lib", "rt.jar"].iterator().join(File.separator)
        }
    }

    def static choose_java(java_versions) {
        return java_versions.first()
    }
}