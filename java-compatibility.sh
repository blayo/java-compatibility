./gradlew install && ls -l ~/.m2/repository/com/ullink/gradle/java-compatibility/0.9/

cd examples/java-6
./gradlew clean >/dev/null
printf "\n*** Test with JDK6_HOME "
JDK6_HOME="C:\Program Files\Java\jdk1.6.0_45" ./gradlew compileJava
./gradlew clean >/dev/null
printf "\n*** Test with JAVA_HOME "
./gradlew compileJava
./gradlew clean >/dev/null


cd ../java-6-with-warning
./gradlew clean >/dev/null
printf "\n*** Test with JDK6_HOME to see warning "
JDK6_HOME="C:\Program Files\Java\jdk1.6.0_45" ./gradlew compileJava
./gradlew clean >/dev/null
printf "\n*** Test with JAVA_HOME to see warning "
./gradlew compileJava
./gradlew clean >/dev/null


cd ../java-7-with-error
./gradlew clean >/dev/null
printf "\n*** Test with JDK6_HOME to see error "
JDK6_HOME="C:\Program Files\Java\jdk1.6.0_45" ./gradlew compileJava
./gradlew clean >/dev/null
printf "\n*** Test with JAVA_HOME to see error "
./gradlew compileJava
./gradlew clean >/dev/null

cd ../java-7
./gradlew clean >/dev/null
printf "\n*** Test with JAVA_HOME  "
./gradlew compileJava
./gradlew clean >/dev/null
