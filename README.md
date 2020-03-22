# Mutant Test
 A rest simple demo to check if a human is mutant by checking its DNA

Se requiere tener instalado Java para ejecutar el proyecto.
 1) Descargar zip del repositorio y extraerlo en un directorio a elección.
 2) Dentro del directorio abrir una terminal de comandos (en Windows 10 escribir "CMD" en la barra de directorios, en sistemas Linux click derecho sobre directorio y seleccionar "Abrir terminal" ).
 3) Ejecutar en el directorio:
     3) a) En Windows mvnw clean package install
        b) En Linux, ./mvnw clean package install
4) Una vez terminado el build del proyecto, ir a la carpeta target del directorio (cd target), una vez dentro ejecutar el comando java -jar demo-0.0.1-SNAPSHOT.jar  
5) Una vez levantado el proyecto, ejecutar Postman(instalarlo en caso de no tenerlo):
   5) a) Crear nuevo request de tipo POST, colocarle el nombre que se prefiera.
      b) Copiar la URL http://localhost:8080/mutant con el payload:
          { 
              “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
          }
       c) Ejecutar   
