# Planets

An exoplanet information service. The service is comprised of two componenets,

1. A data service for retrieving data from the Open Exoplanet Catalogue. (See the service component README file for details)
2. A simple report service that consolidates the information gathered by the data service into a predefined report format. (See the ui component README file for details) 

## Getting Started

These two components may be run in several ways,
1. As standalone applications on your local machine
2. As separate Docker containers
3. In a Docker multi-container environment
4. In a Kubernetes node
 
To run using option 1 or 2, follow the directions in the component README

### Running with docker-compose

Open a terminal in the root directory of the repository you cloned from GitHub. From there, execute the following commands,

```
cd docker
docker-compose up
```

Once the containers are running, you can click here to view the [report](http://localhost:8081/report) 

To shut down, execute 

```
docker-compose down
```

### Running with Kubernetes

Open a terminal in the root directory of the repository you cloned from GitHub. 

```
minikube start
kubectl apply -f k8s
```

Once the node is runnings and pods have been deployed, you can view the report here,
http://your-node-ip:30081/report 

The data service is also exposed at port 30080 if you want to access the data API directly.
