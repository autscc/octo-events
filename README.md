# Octo Events

Octo Events is an application that listens to Github Events via webhooks and expose by an api for later use.

### Main Technologies

- [Kotlin](https://github.com/JetBrains/kotlin)
- [Javalin](https://github.com/tipsy/javalin)
- [Koin](https://github.com/spring-projects)
- [Exposed](https://github.com/JetBrains/Exposed)
- [Apache Maven](https://maven.apache.org/)
- [JUnit](https://junit.org)

## Getting Started

To get started locally, follow the next instructions.

### Prerequisites

* [Github Account](https://github.com/)
* [Java SE Development Kit 8](https://www.oracle.com/)
* [Maven 3.x](https://maven.apache.org/)
* [Ngrok Latest](https://ngrok.com/)

### Installing

After installed all necessary dependencies to run the project in your local environment, you need execute the following steps.

```sh
# clone the repository
$ git clone https://github.com/autscc/octo-events.git
# Now, go to project folder
$ cd octo-events-api
# install project dependencies 
$ mvn clean install
```
## Running the tests

Execute `mvn test` to run the tests.

## Running the Application

First of all, you need provide a public URL to synchronize your application with webhook integration on Github.

For create a public HTTP URL you can use the Ngrok.

```sh
$ ngrok http 8081
```
> **8081** it's the port where the server is available

Now, go to your project root folder and execute:

```sh
# Execute Jar file
$ java -jar target/octo-events-api-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

Basically, The application expose two endpoints.

1. **URL**: /events/, **Method**: Post. Receives events from Github and saves them on the database. You can see more details at https://developer.github.com/webhooks/
2. **URL**: /issues/:number-issue/events, **Method**: GET, **Parameter(:number-issue)**: Number of issue. Retrieve the events stored to specific issue.

> **important:** the application context is **/api/v1/**.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Alysson Tiago S. Cordeiro** - *Development*
