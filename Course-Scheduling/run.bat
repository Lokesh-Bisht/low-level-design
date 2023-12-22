@echo off

mvn clean install -DskipTests assembly:single -q
java -jar target\CourseScheduling.jar  sample_input\input1.txt