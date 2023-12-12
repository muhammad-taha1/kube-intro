#!/usr/bin/env bash

mvn clean install -DskipTests
docker build -t com-example/kube-intro .

