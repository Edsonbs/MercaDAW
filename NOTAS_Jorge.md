1. ejecutar docker compose up
2. ir a "docker", clic derecho y abrir shell de mariadb
3. hacer "cd sql" en esa shell
4. ejecutar comando: mariadb -u root -p MercaDAW  < ficheroCargaDatos.sql
5. fin
mariadb -u root -p MercaDAW  < ficheroCargaDatos.sql
- ejecutar este comando en la shell del contenedor, sive para cargar datos inicialmente. el script debe estar en la misma carpeta que el docker, y se puede ejectuar este comando porque hemos mapeado el repositorio crendo el volumen sql (mirar docker-compose.yml, lo ha hecho el profe)

Comando para los conflictos:
git config pull.rebase false