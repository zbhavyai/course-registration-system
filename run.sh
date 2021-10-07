#!/bin/bash

# clear the screen
clear

# print the commands as they execute
set -o xtrace

# compile the files
javac -cp ".:lib/*" -sourcepath src -d bin src/registrationSystem/controller/*java src/registrationSystem/view/*java src/registrationSystem/model/*java

# run
java -cp ".:lib/*:bin" registrationSystem.controller.AppController
