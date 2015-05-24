./gradlew install && ls -l ~/.m2/repository/com/ullink/gradle/java-compatibility/0.9/
cd example/java-6
./gradlew clean
printf "\n*** Test with JDK6_HOME "
JDK6_HOME="C:\Program Files\Java\jdk1.6.0_45" ./gradlew compileJava
./gradlew clean
printf "\n*** Test with JAVA_HOME "
./gradlew compileJava
./gradlew clean
