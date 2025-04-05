# Manual para poder restaurar la base de datos de Control Escolar

### **Importante:**
La estructura de la base de datos esta definida y no se piede cambiar, sin embargo, los datos de la base de datos podrían variar, sobre todo en el orden de ejecuación de los scripts que generan la base de datos en su totalidad.

### **Los Datos:**
Los datos tambien pueden estar sujetos a cambios, así como la generacíon de datos como el número de cuenta y el correo institucional.

## **Generación de la base de datos:**
Para poder generar la base de datos, se deben ejecutar los scripts en el siguiente orden:
#### 1.- **Script-Create-ControlEscolar.sql**
#### 2.- **Script-DataCatalogos-ControlEscoalr.sql**
#### 3.- **Script-DataPersonas-ControlEscolar.sql**
#### 4.- **Script-DataAcademicosProf-ControlEscolar.sql**
#### 5.- **Script-DataInscripciones-horario-ControlEscolar.sql**

### **Importante:**
Nuevamente hago la aclaración sobre futuras inclusiones de scripts para el resto de la base de datos, así como los scripts para generar "Procedimientos almacenados".
