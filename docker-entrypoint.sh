#!/bin/sh

dockerize -wait tcp://db:3306 -timeout 40s

echo "Start Server"
java -jar app.jar --spring.profiles.active=docker