#!/bin/bash 

CWD="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"

docker compose -f "${CWD}/cell/docker-compose.yml" up --build -d
docker compose -f "${CWD}/conveyor/docker-compose.yml" up --build -d
docker compose -f "${CWD}/digger/docker-compose.yml" up --build -d
docker compose -f "${CWD}/goldarn/docker-compose.yml" up --build -d
docker compose -f "${CWD}/nugget/docker-compose.yml" up --build -d
