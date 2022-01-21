docker build -t spring-data-jpa-docker .

docker run -p 8080:8081 --name spring-data-jpa-docker spring-da

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
`create DATABASE springjpa;`
* Display the database list
`\l`
* Connect to the database
`\c springjpa`
* Display tables list
`\dt`
* Exit psql
`\q`
