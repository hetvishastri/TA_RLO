#!/usr/bin/env bash

mkdir -p classes
# Find all java files in src directory
#change finally while for gradescope
#java_files=$(find src -name "*.java")
java_files=$(find . -name "*.java")
javac -cp lib/*:. -d classes $java_files