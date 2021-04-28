.DEFAULT_GOAL := build-run

setup:
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.3

clean:
	./mvnw clean

compile:
	./mvnw compiler:compile

build: 
	./mvnw package

run:
	java -jar ./target/JmCalcTask.jar
	
build-run: clean build run

