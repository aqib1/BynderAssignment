docker build -t byndercontainer .
### we can connect from host with port 8081 and docker map/redirect
### this traffic to 8080 where our container is exposed
docker run -p8081:8080 byndercontainer