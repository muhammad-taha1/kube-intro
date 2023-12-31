# Intro to kubernetes (what is it)

> kubernetes is a container orchestration framework. Helps to manage apps in different envs running on many containers

## Architecture
https://kubernetes.io/docs/concepts/architecture/

- master node with many worker nodes. Each node has a kubelet process running on it
- kubelet allows communication within cluster and allows to run tasks on the nodes
- Each node can have docker containers running on it relating to app
- master node (control plane) runs processes to manage the cluster, such as:
  - api server - allows communication from external tools to cluster (openshift UI, kubectl command line )
  - controller manager - keeps track of cluster health 
  - scheduler - decides which node should run the process based on container resources and requirements
  - etcd - backing store (holds current status)

## Key terms
### Pod:
  - Smallest unit in kubernetes. Wrapper over container(s). This is done to abstract container specific technology.
  - Recommended to run a main application in a pod, along with side/helper services 
  - Pods can communicate with each other (internally)

### Node:
- contains pods

### Service:
  - Mechanism to expose an application running on pod(s) within cluster
  - **External service** - opens service outside cluster

### Ingress:
  - maps incoming traffic to a pod
  - ingress allows several properties to be defined for accessing service, such as http path, ssl etc

### Config Map:
- configure properties accessible in cluster
- should house non-confidential properties such as dbUrl or some properties in application.properties file
- can be accessed in application as an env variable

### Secrets:
- a place to store confidential data, such as credentials, certificates etc
- should be encrypted before persisting in kubernetes - kubernetes default encryption is base64
- can be accessed in application as an env variable

### Volume:
- attaches a physical storage to pod (can be outside cluster, remote, or on-prem)
- Allows permanent storage

### Deployments
- defines blueprint of pods and how they should behave e.g. number of replicas, scaling factors 
- Allows replication of nodes, connected to its corresponding service
- In this case, the service acts as load balancer between nodes
- If a pod dies, service will forward requests to the other pod
- kubernetes control plane checks the health of pods by comparing their current state against their requirements (as defined in deployment) and accordingly makes adjustments.

### StatefulSet
- Like deployment for pods but with state, such as db pods
- manages the shared backing data storage (volume)


## Config files
In config file (yaml) we declare the apiVersion we are going to use for that component, the  kind of component and then the following 3 parts:

### metadata:
- name of component
### specification:
- put all config for that component
- attributes specific to kind
### status:
- automatically generated by kubernetes (used for state comparison by control plane)
- not required to be written




