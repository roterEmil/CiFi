#!/bin/sh
./clean.sh
docker build -f Docker/Dockerfile Docker -t cifiimage

