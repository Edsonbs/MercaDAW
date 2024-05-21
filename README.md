Trabajo de final del tercer trimestre de Programación, Entornos de Desarrollo, Sistemas Informáticos, Bases de Datos y FOL.

Equipo:
- Eddyson
- Jorge Alfonso Alcalde
- Adrián Núñez
- Sergio 
- Mateo

# ELEMENTOS REALIZADOS EN ESTE TRABAJO

- Crear base de datos con **docker** _(mariadb)_.
- Insertar datos en ella mediante script _(scriptInsercionDatos.sh)_.
- Realizar **copia de seguridad** cada minuto a un fichero a través del mismo script _(scriptInsercionDatos.sh)_.
- Implementado generar nómina de los empleados _(crea fichero en markdown y pdf a través de pandoc)_.
- Implementado imprimir etiqueta del producto _(crea fichero en markdown y pdf a través de pandoc)_.
- Implementado imprimir etiqueta detallada del producto _(crea fichero en markdown y pdf a través de pandoc)_.
- Creada carpeta "basedatos" para **PILAR**, RECOMENADBLE LEER LEEME.MD ANTES DE NADA.
- Creada carpeta "sistemas" para **EVA**, en la cual tiene todos los archivos del script y relacionados. NO FUNCIONA EL SCRIPT EN ESA CARPETA, SOLO ESTÁ AHÍ POR SEPARARLO.
- Creada la interfaz visual a través de varias vistas y pestañas, ambas combinadas.
- Probados los métodos susceptibles de errores con Junit.
- Hemos exportado un informe del resultado de los test con `mvn surefire-report:report`

# PASOS A SEGUIR PARA EJECUTAR EL PROGRAMA:

1. Antes de ejecutar el programa debes situarte en la carpeta "docker" del proyecto a través de la terminal:

   ```bash
   # Desde la raiz:
   cd docker
   ```

2. Una vez ahí, ejecutar:

   ```bash
   ./scripInsercionDatos.sh
   ```
   Este script te crea el docker y lo inicia, inserta en la base datos los datos de `ficheroCargaDatos.sql` y te genera una "tarea" con **crontab** en el propio contenedor, el cual coge los datos de la base de datos y los escribe cada minuto en el fichero `copiaSeguridad.sql`. Todos estos archivos se encuentran dentro del repositorio "docker". 

3. Tras esto ejecutar en la terminal:

   ```bash
   # Si aún no te has movido de la carpeta "docker":
   cd ..

   # Finalmente ejecutamos lo siguiente en la raíz del proyecto:
   mvn javafx:run
   ```
   La alternativa es situarse en la clase "App" y pulsar el icono de play.

4. Una vez realizado esto, se abrirá la interfaz de usuario, la cual tiene dos botones:
   1. **Gestionar empleados**: Tiene todos los elementos de gestión de empleados, como el añadir, eliminar, una tabla con toda la lista de empleados, posibilidad de generar nómina, etc.
   2. **Gestionar productos**: Lo mismo que empleados, tiene todas las opciones relacionadas con productos. Aquí también se puede imprimir etiqueta del producto y ver más información acerca de él e imprimir información más detallada.

**NOTA: Al iniciar el contenedor, la máquina virtual se queda sin internet, por lo que es posible que "generar nómina" y "generar etiqueta" de problema puesto que si no tienes previamente la imagen del contenedor pandoc no se va a poder descargar por falta de conexión.**
