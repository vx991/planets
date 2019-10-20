# Planets Service

A data service that provides access to the Open Exoplanet Catalogue. Using this service API you can,

* Get a list of all exoplanets
* Get a count of exoplanets by planet type
* Find the exoplanet with the hottest host star
* Get a timeline summary of exoplanets by size for each year

## Getting Started

Follow these steps to run this service on your local machine
```
1. git clone https://github.com/vx991/planets.git
2. cd service
3. mvn clean package
4. java -jar ./target/planets-1.0.0.jar
```
 
This service is also available as a Docker image on Docker Hub which you can run with,
```
docker run -p 8080:8080 vx991/planet-service
```

### Prerequisites

If you are running locally, you will need to have Java JDK 8 or higher


## API 

```
GET /planet
GET /planet/type/{id}
GET /planet/host/hottest
GET /planet/summary
```
## Running the Tests

The unit tests can be run by executing a maven build
```
mvn clean package
```

## Deployment



## Built With

* Java JDK 8
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Steve Oliver** 

## License


## Acknowledgments

