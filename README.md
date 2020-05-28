# site-inventory
A REST service to store and retrieve information about trial sites and their resources.

## Install

We use Docker Compose for deployment. Clone this github repository and in the main directory run:

```
docker pull maven:3.6.3-jdk-8
docker pull azul/zulu-openjdk-alpine:8-jre
docker-compose build
docker-compose up
```

You can test the app with:

```
curl --request GET --url http://127.0.0.1:8087/
```

To uninstall, use:

```shell script
docker-compose down --remove-orphans --volumes
```

*Note: This will delete your database!*

## API documentation

You can get swagger documentation in JSON by visiting http://localhost:8087/v2/api-docs

You can navigate the documentation by visiting http://127.0.0.1:8087/swagger-ui.html

You can also graphically navigate the API with the [HAL Explorer](https://github.com/toedter/hal-explorer).
Just visit http://127.0.0.1:8087/ from your browser.

## Scripts to add data

[scripts] folder contains some scripts to add data via `curl`.

For example, credentials to access NFVOs are not included in database initialization scripts.
Edit and run [add-credentials.sh](scripts/add-credentials.sh) to add credentials for an existing NFVO.

## Development environment

Run a postgresql database on your localhost. You can do this manually or with docker:

```shell script
docker run -p 5432:5432 --name siteinventory-postgres -e POSTGRES_USER=siteinventory -e POSTGRES_PASSWORD=siteinventory -d postgres:12-alpine
```

As you can see from the command above, set a user and password with value `siteinventory`.

*Note: database is created and destroyed every time you restart the app.*

To build the app, run:

```shell script
$ mvn clean package
```

**Note**: The app is written with Java 8. If build fails because you have a more recent version,
switch to Java 8 in your environment.

To run:

```shell script
$ java -Dspring.profiles.active=dev -jar target/site-inventory-<VERSION>.jar
```
