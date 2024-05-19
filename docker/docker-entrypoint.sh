#!/bin/bash
# Iniciar el cron
service cron start

# Ejecutar el entrypoint original de MariaDB
exec docker-entrypoint.sh "$@"
