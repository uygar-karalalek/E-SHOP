cd ./Back-End
gradle clean build
sleep 10
cd ../CMS
npm run-script magic &
sleep 10
cd ../Back-End
gradle build
docker stop eshop-reverse-proxy eshop-database eshop-back-end
docker image rm eshop-reverse-proxy eshop-database eshop-back-end
docker build --tag eshop-back-end --build-arg JAR_FILE=rest-1.0-SNAPSHOT.jar .
sleep 10
cd ..
docker-compose down
docker-compose up