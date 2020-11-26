# IWF Repository

REST API module to manage 5G EVE site information (formerly site-inventory)

## Install

We use `docker-compose` for deployment. Download [docker-compose.yml](docker-compose.yml) and run the following commands:

```shell script
docker-compose pull
docker-compose up
```

You can test the app with:

```shell script
curl --request GET --url http://127.0.0.1:8087/
```

To uninstall, use:

```shell script
docker-compose down --remove-orphans --volumes
```

_Note: This will delete your database!_

## OpenAPI documentation

You can navigate the documentation by visiting http://localhost:8087/swagger-ui.html

You can get OpenAPI documentation in JSON by visiting http://localhost:8087/api-docs

You can also graphically navigate the API with the [HAL Explorer](https://github.com/toedter/hal-explorer).
Just visit http://127.0.0.1:8087/ from your browser.

## Scripts to add data

[scripts](scripts) folder contains some scripts to add data via `curl`.

For example, credentials to access NFVOs are not included in database initialization scripts.
Edit and run [add-credentials.sh](scripts/add-credentials.sh) to add credentials for an existing NFVO.

## Development environment

### With docker-compose:

```shell script
docker-compose -f docker-compose.dev.yml build
docker-compose -f docker-compose.dev.yml up
```

### Manual

Run a postgresql database on your localhost. You can do this manually or with docker:

```shell script
docker run -p 5432:5432 --name iwf-repository-db-dev -e POSTGRES_USER=iwf-repository -e POSTGRES_PASSWORD=iwf-repository -d postgres:12-alpine
```

As you can see from the command above, set a user and password with value `iwf-repository`.

_Note: database is created and destroyed every time you restart the app._

To build the app, run:

```shell script
$ mvn clean package
```

**Note**: The app is written with Java 8. If build fails because you have a more recent version,
switch to Java 8 in your environment.

To run:

```shell script
$ java -Dspring.profiles.active=dev -jar target/iwf-repository-<VERSION>.jar
```
