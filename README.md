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

We can't generate OpenAPI documentation since endpoints are created dynamically by `spring-data-rest`
You can graphically navigate the API with the [HAL Explorer](https://github.com/toedter/hal-explorer).
Just visit http://127.0.0.1:8087/ from your browser.

