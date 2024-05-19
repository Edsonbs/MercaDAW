#!/bin/bash

# Levanto el contenedor
docker compose up -d

# Esperar 16 segundos  para asegurarse de que el contenedor esté listo
sleep 15

# Abre la terminal del contenedor y pasa los datos de ficheroCargaDatos.sql a la base de de datos MercaDAW
docker exec -it docker-db-1 /bin/bash -c "
  cd sql &&
  mariadb -u root -psecret MercaDAW < ficheroCargaDatos.sql
"

# Crea una tarea crontab en el contenedor, la cual copia los datos de la base de datos en el fichero copiaSeguridad.sh cada 1 minuto
docker exec -it docker-db-1 /bin/bash -c 'echo "* * * * * cd /sql && mariadb-dump -u root -psecret MercaDAW > copiaSeguridad.sql" | crontab -'

# Inicio los servicios crontab del contenedor 
docker exec -it docker-db-1 /bin/bash -c "service cron start"

