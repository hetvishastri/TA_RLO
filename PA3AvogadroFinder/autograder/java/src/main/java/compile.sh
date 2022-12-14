#!/usr/bin/env bash

# Find all java files in src directory
java_files=$(find ./com/gradescope -name "*.java")
javac -cp lib/*:. $java_files