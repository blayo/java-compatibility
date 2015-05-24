package com.ullink.gradle

import org.gradle.api.JavaVersion;
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import static com.ullink.gradle.JavaAPIVersion.choose_java6
import static com.ullink.gradle.JavaAPIVersion.find_java


class JavaCompatibility implements Plugin<Project> {

    void apply(Project project) {
        project.tasks.withType(JavaCompile) { // Implicitly in afterEvaluate
            doFirst { // Necessary to take into account sourceCompatibility = verion
                String java_rt;
                switch (project.sourceCompatibility) {
                    case JavaVersion.VERSION_1_5:
                        java_rt = find_java(5, System.env.JDK5_HOME, System.env.JAVA_HOME)
                        break
                    case JavaVersion.VERSION_1_6:
                        java_rt = find_java(6, System.env.JDK6_HOME, System.env.JAVA_HOME)
                        break
                    case JavaVersion.VERSION_1_7:
                        java_rt = find_java(7, System.env.JDK7_HOME, System.env.JAVA_HOME)
                        break
                }
                if (java_rt != null && !java_rt.isEmpty()) {
                    options.bootClasspath = java_rt
                }
            }
        }
    }
}