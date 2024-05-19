docker exec -it docker-db-1 /bin/bash -c "
  cd sql && 
  : > copiaSeguridad.sql && 
  mariadb-dump -u root -psecret MercaDAW > copiaSeguridad.sql
"