#!/bin/bash

# Levantar el contenedor
docker compose up -d

# Esperar unos segundos para asegurarse de que el contenedor esté listo
sleep 15

# Ejecutar los comandos para ir a la carpeta "sql" y que me inserte el script en la base de datos
docker exec -it docker-db-1 /bin/bash -c "
  cd sql && 
  mariadb -u root -psecret MercaDAW < ficheroCargaDatos.sql
"

