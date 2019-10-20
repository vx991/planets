# Planets UI

A simple Node web application to produce a report using the Planets Service. There is currently only one report available that will display the following,

* Show the number of orphan exoplanets
* Show the name of the exoplanet that is orbiting the hottest star
* Display a timeline summary of exoplanets by size for each year

## Getting Started

Follow these steps to run this service on your local machine
```
1. git clone https://github.com/vx991/planets.git
2. cd ui
3. npm start
```
 
This service is also available as a Docker image on Docker Hub which you can run with,
```
docker run -p 8081:8081 vx991/planet-ui
```

Note: This UI component is currently configured to run using Docker Compose. As such, the host name for the service component is set as the docker service name. If you want to run the two component separatly, you'll have to either modify the planet-service host name configuration of add an entry to your host file make sure the host name will resolve.   

### Prerequisites

1. If you are running locally, you will need to have a current version of Node.js and npm installed.
2. A running Planet Service instance

## Get a Report
View the [report](http://localhost:8081/report)


## Deployment



## Built With

* JavaScript ES6
* Node.js

## Authors

* **Steve Oliver** 

## License


## Acknowledgments

