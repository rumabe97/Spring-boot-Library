# Spring

Spring application

[![CircleCI](https://circleci.com/gh/xBidi/spring.svg?style=shield)](https://circleci.com/gh/xBidi/spring)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=xBidi_spring&metric=alert_status)](https://sonarcloud.io/dashboard?id=xBidi_spring)

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/xBidi/spring)

### Requirements
````
java 11 -> https://openjdk.java.net/projects/jdk/11/º
maven -> https://maven.apache.org/
project lombok -> https://projectlombok.org/
docker-compose -> https://docs.docker.com/compose/install/
postgres -> docker run --name postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=database -p 5432:5432 -d postgres
````

### Start application
````
sh ./deploy.sh
````
