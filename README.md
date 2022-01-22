# Tutorial to make the project work locally :<br />
1 - Import the projet on your IDE<br />
2 - Build the project to generate `springboot-docker-0.0.1-SNAPSHOT.jar` in the target file<br />
3 - Build Docker compose : `docker-compose up -d` <br />
4 - Go inside the container `docker exec -it <CONATINER_ID> bash`<br />
5 - Connect to Postgres with the user postgres : `psql -U postgres`<br />
6 - Display the database list : `\l`<br />
7 - Connect to the database : `\c springjpadocker`<br />
8 - Display tables list : `\dt`<br />
9 - Display data in a table : `SELECT * FROM COURSE;`


# Some useful commands<br />
* This command will download the alpine version image of postgres :
`docker pull postgres:alpine`
* Run the postgres image
`docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:alpine`
* RUN inside the postgres container
`docker exec -it postgres bash`
* Display all Postgres command : 
`psql --help`
* Display postgres users :
`\du`
* Create a database 
`create DATABASE springjpadocker;`
* Exit psql
`\q`
  <br /><br />
* Generate image from the dockerfile : `docker build -t spring-data-jpa-docker .`
* Run the app image `docker run -p 8080:8080 --name spring-data-jpa-docker spring-data-jpa-docker`
  <br /><br />
* Display network list : `docker network ls`
* Create a network : `docker network create spring-docker-network`
* Connect the network with postgres : `docker network connect spring-docker-network postgres`
* Inspect the postgres container to verify the network connection :`docker container inspect postgres`
