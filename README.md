# Tutorial to make the project work locally :<br />
1 - Import the projet on your IDE<br />
2 - Build the project to generate `springboot-docker-0.0.1-SNAPSHOT.jar` in the target file<br />
3 - Build Docker compose : `docker-compose up` <br />


# Some useful commands<br />

* This command will download the alpine version image of postgres :
`docker pull postgres:alpine`
* Run the postgres image
`docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:alpine`
* RUN inside the postgres container
`docker exec -it postgres bash`
* Display all Postgres command : 
`psql --help`
* Connect to Postgres with the user postgres :
`psql -U postgres`
* Display postgres users :
`\du`
* Create a database 
`create DATABASE springjpadocker;`
* Display the database list
`\l`
* Connect to the database
`\c springjpadocker`
* Display tables list
`\dt`
* Exit psql
`\q`

* Generate image from the dockerfile : `docker build -t spring-data-jpa-docker .`
* Run the app image `docker run -p 8080:8080 --name spring-data-jpa-docker spring-data-jpa-docker`

* Display network list : `docker network ls`
* Create a network : `docker network create spring-docker-network`
* Connect the network with postgres : `docker network connect spring-docker-network postgres`
* Inspect the postgres container to verify the network connection :`docker container inspect postgres`
