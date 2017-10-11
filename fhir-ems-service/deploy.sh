#!/bin/bash
sudo mvn clean install

sudo docker build -t fhirio .
sudo docker rm fhirio

sudo docker run -it --name fhirio -p 8080:8080 fhirio
