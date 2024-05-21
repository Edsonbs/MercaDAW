# TRABAJO TERCERA EVALUACION

## INTEGRANTES:

- JORGE ALCALDE
- EDDYSON BUENO
- ADRIAN NUÑEZ
- SERGIO CUMBREÑO
- MATEO MAJE

## ENTORNOS DE DESARROLLO

### DIAGRAMA DE CASOS DE USO

```plantuml
@startuml Diagrama casos de uso 
title Casos de Uso MercaDaw
left to right direction
actor "Trabajador" as t

rectangle MercaDaw{
    usecase "Gestionar" as gp
    usecase "Productos" as prod
    usecase "Empleados" as emple
    usecase "Calcular nomina trabajador" as c
    usecase "Visualizar informacion" as ed
    usecase "Exportar datos" as edat
    usecase "Imprimir etiqueta producto" as ie

}

t -- c
t -- gp
gp <|-- prod
gp <|-- emple
t -- ed
ed <.. edat: extends
t -- ie
c <.. edat: extends
ie <.. edat: extends
@enduml
```

Este diagrama ha sido realizado mediante los siguientes requisitos funcionales y no funcionales:

**Requisitos funcionales:**  

- Dar de alta producto.  
- Dar de alta empleados.  
- Visualizar datos de productos.  
- Visualizar listado de empleados.  
- Imprimir etiqueta de un producto.  
- Calcular nómina de trabajadores.  
- Exportar datos.   

**Requisitos no funcionales:**

  - El sistema se iniciará con la carga de datos desde un fichero a la base de datos _(productos y trabajadores)_.
  - El alta de productos y empleados se guardará desde java en la base de datos.
  - El listado de empleados se cargará desde la base de datos a nuestro sistema.
  - Precio de venta obtenido en euros/dólares.
  - El cálculo de nóminas generará un fichero con las nóminas de los trabajadores.
  - La copia de seguridad debe realizarse con un script que copie los datos a un fichero y lo mueva a la carpeta `backups`.
  - Los datos exportados pueden pasarse a formato `excel`, `pdf`, etc.

Con todo esto hemos llegado a la solucion correspondiente que se va a usar para el proyecto.


### DIAGRAMA DE COMPONENTES

```plantuml
@startuml Modelo-Vista-Controlador
title Modelo-Vista-Controlador
left to right direction
package view{
    component InicioViewController <<java>> as inicioController
    component GestionProductoViewController <<java>> as gestionProdController
    component GestionEmpleadoViewController <<java>> as gestionEmpController

    component inicioView <<FXML file>> as inicioView
    component gestionProductoView <<FXML file>> as gestionProdView
    component gestionEmpleadoView <<FXML file>> as gestionEmpView
}

package controller{
    component MercaDawController as mdc
}

package model{
    component MercaDaw
    component Dao 
    component LectorImp

    () "MercadoDAO" as dao
    () "Gestionable" as gestion
    () "Lector" as lectorif

    MercaDaw -() gestion
    Dao -() dao
    LectorImp -() lectorif

}

mdc ..> gestion : use
MercaDaw ..> dao : use

    inicioController ..> inicioView: use
    gestionProdController ..> gestionProdView: use
    gestionEmpController ..> gestionEmpView: use

    gestionProdController ..> mdc: use
    gestionEmpController ..> mdc: use
    inicioController ..> mdc: use

dao ..> lectorif

@enduml
```

Este diagrama ha sido efectuado mediante el enunciado aportado, los controladores, interfaces y componentes que van a ser requeridos para su implementacion codificada en java.

### DIAGRAMA DE DESPLIEGUE

```plantuml
@startuml Diagrama despliegue MercaDaw

left to right direction
'top to bottom direction


node "PC Usuario" <<device>>   { 

    node "Java Runtime Environment"{
        artifact "mercaDaw.jar" as app
    }

    node "Servidor Base de Datos" <<docker>>{
        node "MariaDB" as db
    }
    
artifact "cargaDatos.sql" as cargdat 

}

app -- db : "puerto:3306"
app -- cargdat
@enduml
```

En este diagrama muestra como funciona nuestra carga de datos del proyecto, todo en local y estando conectado a un servidor de base de datos que en este caso es MariaDB atraves del puerto: 3306.

### DIAGRAMA DE CLASES

```plantuml
@startuml Diagrama clases Mercado
set separator none
allow_mixing
left to right direction
package es.etg.programacion.mercadaw{
    package mercado{
        class Supermercado{
            -provincia: String
            -municipio: String
            -nombre: String
            -productos: ListArray<Productos>
            -empleados: ListArray<Empleados>
        }       

        class Cliente{
            -codigoPostal: int;
            -correoElectronico: String;
            -nombre: String;
            -fechaCompra: String;
        }

        interface Gestionable{
            +darAlta(empleado Empleado)
            +darAlta(producto Producto)
        }

        Supermercado o-- Cliente
    }
    package producto{
        abstract Producto{
            +{static} PORCENTAJE_5: double = 0.05
            +{static} PORCENTAJE_10: double = 0.1
            +{static} AUMENTO_VENTA: double = 0.25
            +{static} DOLAR: double = 1.11
            +{static} MAX_ALTURA_ANCHURA: double = 0.5
            -{static} numInstancias: int = 1;
            #iva: double 
            -nombre: String
            -marca: String
            -precioEnEuros: double
            -alturaEnMetros: double
            -anchuraEnMetros: double
            -pesoEnKg: double
            -numElementos: int
            -descripcion: String
            -categoria: String
            -precioVenta: double
            +toString(): String
            +imprimirEtiqueta(): String
            +calcularPrecioNumElementos(): double
            +calcularPrecioAltura(): double
            +calcularPrecioAnchura(): double
            +calcularPrecioPeso(): double

        }
        class ProductoFactory{

            +{static}crearProducto(): Producto

        }
        interface IProducto{
            +calcularPrecioVenta(): double
            +calcularPrecioDolar(): double
            +calcularPrecioTotal(): double
        }
            
        enum categoria{
            ALIMENTACION(0.04)
            DROGUERIA(0.1)
            COSMETICA(0.21)
            -iva: double
        }
        class Alimentacion{

        }
        class Drogueria{

        }

        class Cosmetica{
        }
    
    }
    package trabajador{
        package fol{
            class Nomina{
                +DIAS_ANYO: double = 365
                +ANYOS_ANTIG: double = 2
                +CONTRATO_INDEFINIDO: double = 20
                -nombreEmpleado: String
                -salario: double
                -salarioBruto: double
                -salarioNeto: double
                -salarioAnualBruto: double
                -costeLaboral: double
                -indemnizacion: double

                +calcularCosteLaboral(): double
                +calcularSalarioNeto(): double
                +sumarDeduccionesEmpresa(): double
                +sumarDeducciones(): double
                +calcularSalarioAnual(): double
                +calcularPPE(): double
                +calcularIndemnizacion(): double

            }

            enum Deducciones{
                IRPF(14)
                BCCC8(4.7)
                MEI(0.12)
                DESEMPLEO(0.1)
                -porcentaje: double
            }
        }
        enum Trabajador{
            REPONEDOR(1200)
            CAJERO(1300)
            ENCARGADO(1500)
            OTRO(1000)
            -salario: double
        }
        class Empleado{
            +OTRO: double = 1000
            -{static} id: int
            -nombre: String
            -apellido: String
            -categoria: String
            #salario: OTRO
            +calcularNomina(): Nomina
        }
        class Reponedor{

        }
        class Cajero{

        }
        class Encargado{

        }
    }
    
    package util{
        interface Documento{
            +getContenido():LinkedHashMap<String,String>
            +getTitulo():String
            +getPie():String
        }
        package print{
            class Impresora{
                +imprimir(fichero:String)
            }
        }
        package writer{
            class WriterMarkDown{
                +transformarProductos(productos List<Productos>): List<Documento>
                +transformarEmpleados(productos List<Empleados>): List<Documento>
                +escribir(doc:Documento)
                +escribirEtiqueta(Producto)
                +escribir(docs:List<Documento>)
            }
        }
    Documento <|.. Producto
    Documento <|.. Empleado
    }
    package dao{
        interface MercadoDAO{

            +listarEmpleados(): list<Empleado>
            +listarProductos(): list<Producto>
            +anadir(producto: Producto): int
            +anadir(empleado: Empleado): int 
            +eliminar(empleado: Empleado): int
            +eliminar(producto: Producto): int


        }
        class MercadoMariadbDAOImp{
            -URL: String = "jdbc:mariadb://localhost:3306/%s?user=%s&password=%s"
            -DATABASE_NAME = "MercaDAW"
            -DATABASE_USER = "root"
            -DATABASE_PASS = "secret"
            -connection: Connection
            +MercadoMariadbDAOImp()
        }
    
    MercadoDAO <|.. MercadoMariadbDAOImp
    MercadoDAO <|.. MercadoMockDAOImp
    }
    
}
component "org.mariadb.jdbc"<<jdbc driver>> 

"org.mariadb.jdbc" <.. MercadoMariadbDAOImp




Supermercado o-- Producto
Supermercado o-- Empleado
IProducto <|.. Producto
Producto <|-- Alimentacion
Producto <|-- Drogueria
Producto <|-- Cosmetica
Empleado <|-- Reponedor
Empleado <|-- Cajero
Empleado <|-- Encargado
Gestionable <|.. Supermercado
Documento <|.. Nomina

@enduml
```

Este diagrama es el mas largo, y el que mas nos ha costado, pero hemos llegado a su solucion tras mucho trabajo, se compone de las carpetas mercado, trabajador, producto y DAO donde estaran dentro sus diferentes clases, interfaces y enumeraciones, tambien podemos observar arriba del todo que esta conectada a la base de datos MariaDB.  

## SISTEMAS INFORMATICOS

EL SCRIPT SERÁ EXPLICADO EN UNA TAREA QUE NOS HA ABIERTO EVA EN EL AULA VIRTUAL

## PROGRAMACION

Para la codificacion, hemos implementado nuestros diagramas, dividiendo en carpetas partes del codigo _(Trabajador, Producto, Mercado, Util, DAO)_, han habido varios problemas en distintas partes del codigo, sobretodo con compatibilidad, en la forma que se efectuaban los datos, ya que uno ponia la salida de una forma y entraban por otra.

En producto hemos hecho la clase con sus hijas y una enumeracion con cada una de sus categorias, aparte una factoria que los creara. Tambien su interfaz donde calculara los diferentes importes de cada producto.
En empleado tmb hemos creado la clase con su herencia correspondiente y su enumeracion con cada cargo, tambien su factoria para añadir empleados y calculara su correspondientenomina con la interfaz Doumento.

## FOL

Para la parte de FOL hemos creado 2 clases una donde estara la Nomina con los datos de los calculos y el nombre de los empleados y en la otra las Deducciones es decir los porcentajes del FOGASA, IRPF, BCCC, DESEMPLEO Y MEI.

Al hacer los calculos aparecera en la aplicacion el empleado con su correspondiente nomina.

## BASE DE DATOS

La base de datos que hemos utilizado es Mariadb, la cual ha sido docketizada. Hemos creado un script que se encarga de:
- lanzar el docker de mariadb e iniciarlo, el cual crea a su vez la base de datos _(MercaDAW)_.
- insertar datos en la base de datos a través de un fichero _(ficheroCargaDatos.sql)_.
- crear copia de seguridad instalando crontab en el contenedor e iniciar sus servicios, el cual en este caso es obtener los datos de la base de datos y volcarlos en un fichero llamado copiaSeguridad.sql _(situado en carpeta "docker" del proyecto)_. Respecto a la tarea de crontab, se realiza cada 1 minuto.

Los métodos creados respecto a base de datos son de listado productos-empleados, de adición y de eliminación de estos, los cuales han sido probados con Junit _(Y DEBUGEADOS UNO A UNO)_.
