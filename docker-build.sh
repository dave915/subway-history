#!/bin/bash 

./gradlew clean build
docker build --no-cache -t htaehyun/subwayhistory-backend .
docker push htaehyun/subwayhistory-backend:latest
