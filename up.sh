#!/bin/bash

while getopts ":b:" opt; do
  case $opt in
    b)
      ;;

    \?)
      echo "Invalid option: -$OPTARG" >&2
      exit 1
      ;;

    :)
      echo "Building application" >&2
      mvn clean install docker:build
      
      ;;
  esac
done


echo "Starting docker"
docker-compose up -d
sleep 60

echo "Update AuthDB"
(cd modules/authorization/authorization-liquibase; mvn liquibase:update)

echo "Update FinanceDB"
(cd liquibase; mvn liquibase:update);

echo "Done, enjoy ;)"