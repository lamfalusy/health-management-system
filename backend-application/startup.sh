#!/bin/sh
echo "HMS microservices are starting..."

echo "Start eureka server."
cd ./eureka
nohup java -jar eureka-1.0-SNAPSHOT.jar &
sleep 30
echo "Eureka server started."

echo "Start customer server."
cd ../customer
nohup java -jar customer-rest-api-1.0-SNAPSHOT.jar &
sleep 30
echo "Customer server started."

echo "Start food server."
cd ../food
nohup java -jar food-rest-api-1.0-SNAPSHOT.jar -Dflyway.migration.enabled=false &
sleep 15
echo "Food server started."

echo "Start nutritionist server."
cd ../nutritionist
nohup java -jar nutritionist-rest-api-1.0-SNAPSHOT.jar -Dflyway.migration.enabled=false &
sleep 15
echo "Nutritionist server started."

echo "Start regimen server."
cd ../regimen
nohup java -jar regimen-rest-api-1.0-SNAPSHOT.jar -Dflyway.migration.enabled=false &
sleep 15
echo "Regimen server started."

echo "Start Zuul server."
cd ../zuul
nohup java -jar zuul-1.0-SNAPSHOT.jar &
sleep 10
echo "Zuul server started."