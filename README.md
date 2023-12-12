# Intro to kube and docker
Note: You will need to install docker desktop on your machine and enable kubernetes to run this project


### Docker
 - Run `./build/buildImage.sh` script to build docker image
 - `docker image ls` to see all images in your machine - should see image for com-example/kube-intro
 - `./build/runImage.sh` to run image on docker desktop
 - `docker ps` see running containers on your  machine, their status etc 
 - inspect container in docker desktop - see the tabs etc
 - try calling sample APIs of project

### kubernetes
- to create namespace (for mongo) run: kubectl create namespace mongo-database
 - to apply a deployment run `kubectl apply -f ./deployments/{file}.yaml`
 - to check for applied deployments, run `kubectl get deployments`
 - to check for applied secrets, run `kubectl get secrets`
 - to check for applied and running pods, run `kubectl get pods`
 - to delete all running deployments, `kubectl delete deployment --all`
 - for debugging run `kubectl describe pod`
 - highlevel overview of services `kubectl get all -o wide`
