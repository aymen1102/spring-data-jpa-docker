
* This command will download the alpine version image of postgres : <br/>
`docker pull postgres:alpine`

* Run the postgres image <br/>
`docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:alpine`

* RUN inside the postgres container <br/>
`docker exec -it postgres bash`
