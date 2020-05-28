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

## API documentation

You can get swagger documentation in JSON by visiting http://localhost:8087/v2/api-docs

You can navigate the documentation by visiting http://127.0.0.1:8087/swagger-ui.html

You can also graphically navigate the API with the [HAL Explorer](https://github.com/toedter/hal-explorer).
Just visit http://127.0.0.1:8087/ from your browser.

## Add NFVO credentials

Credentials to access NFVOs are not included in database initialization scripts.
Edit and run [add-credentials.sh](scripts/add-credentials.sh) to add credentials for an existing NFVO.

