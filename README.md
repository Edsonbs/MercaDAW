Trabajo de final del tercer trimestre de Programación, Entornos de Desarrollo, Sistemas Informáticos, Bases de Datos y FOL.

Equipo:
- Eddyson
- Jorge Alfonso Alcalde
- Adrián Núñez
- Sergio 
- Mateo
  
# ELEMENTOS REALIZADOS EN ESTE TRABAJO
- crear base de datos con docker (mariadb).
- insertar datos en ella mediante script (scriptInsercionDatos.sh).
- realizar copia de seguridad cada minuto a un fichero a través del mismo script (scriptInsercionDatos.sh).
- implementado generar nómina de los empleados
- implementado imprimir etiqueta del producto (crea fichero en markdown y pdf a través de pandoc)
- implementado imprimir etiqueta detallada del producto (crea fichero en markdown y pdf a través de pandoc) 
- creada carpeta "basedatos" para PILAR, RECOMENADBLE LEER LEEME.MD ANTES DE NADA.
- creada carpeta "sistemas" para EVA, en la cual tiene todos los archivos del script y relacionados. NO FUNCIONA EL SCRIPT EN ESA CARPETA, SOLO ESTÁ AHÍ POR SEPARARLO.
- creada la interfaz visual a través de varias vistas y pestañas, ambas combinadas.
- probados los métodos susceptibles de errores con Junit.
- 
# PASOS A SEGUIR PARA EJECUTAR EL PROGRAMA:
1. Antes de ejecutar el programa debes situarte en la carpeta "docker" del proyecto a través de la terminal (desde la raiz ejecutar "cd docker" en la terminal), y una vez ahí ejecutar "bash scripInsercionDatos.sh". Este comando te crea el docker y lo inicia, inserta en la base datos los datos de ficheroCargaDatos.sql , y te genera una "tarea" con crontab en el propio contenedor, el cual coge los datos de la base de datos y los escribe cada minuto en el fichero "copiaSeguridad.sql". Todos estos archivos se encuentran dentro del repositorio "docker". 
2. Tras esto ejecutar en la terminal, desde la raiz del proyecto "mvn javafx:run", o situarse en la clase "App" y pulsar el icono de play.
3. Una vez realizado esto, se abrirá la interfaz de usuario, la cual tiene dos botones:
   1. Gestionar empleados: tiene todos los elementos de gestión de empleados, como el añadir, eliminar, una tabla con toda la lista de empleados, posibilidad de generar nómina, etc.
   2. Gestionar productos: lo mismo que empleados, tiene todas las opciones relacionadas con productos. Aquí también se puede imprimir etiqueta del producto y ver más información acerca de él.
**NOTA: al iniciar el contenedor la máquina virtual se queda sin internet, por lo que es posible que "generar nómina" y "generar etiqueta" de problema puesto que si no tienes previamente la imagen del contenedor pandoc no se va a poder descargar por falta de conexión.**
