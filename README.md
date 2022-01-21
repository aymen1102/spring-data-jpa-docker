
This command will download the alpine version image of postgres :
`docker pull postgres:alpine`

Run the postgres image 
docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:alpine

RUN inside the postgres container
docker exec -it postgres bash
