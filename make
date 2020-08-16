#!/bin/bash
shopt -s globstar &&
javac -d out/ src/**/*.java &&
java -cp out/ main.com.lindx.calc.Main &&

