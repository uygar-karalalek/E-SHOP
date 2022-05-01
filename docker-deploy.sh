cd ./Back-End
gradle clean build
sleep 10
cd ../CMS
npm run-script magic &
sleep 10
cd ../Back-End
gradle build
docker image rm eshop-back-end
docker build --tag eshop-back-end --build-arg JAR_FILE=rest-1.0-SNAPSHOT.jar .
sleep 10
cd ..
docker image rm eshop-reverse-proxy
docker docker build --tag eshop-reverse-proxy ./Reverse-Proxy
docker-compose down
docker-compose up