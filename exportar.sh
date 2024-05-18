#!/bin/bash
docker run --rm        --volume "$(pwd):/data"        --user $(id -u):$(id -g)        pandoc/latex Exportacion.md -o $1.pdf