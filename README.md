# 🎥 **Clubes Autónomo**  
Una aplicación web desarrollada con **Spring Boot** que permite a los estudiantes acceder a una serie de videos recientes, además de contar con funcionalidades avanzadas como gestión de usuarios y comunicación en tiempo real.

## ✨ **Características**
- **Gestión de Usuarios**:  
  El administrador puede visualizar y gestionar a los usuarios registrados en el sistema.  
- **Comunicación en Tiempo Real**:  
  Permite la comunicación bidireccional entre usuarios mediante **WebSockets**.  
- **Interfaz Intuitiva**:  
  Diseñada para ser fácil de usar, con una experiencia fluida.

## 🌟 **Vista Previa**

### Administración de Usuarios  
Gestión completa de los usuarios desde el panel administrativo.  
![Administración de Usuarios](https://i.postimg.cc/3wmyBLfg/Administraci-n-de-usuarios.png)

---

### Comunicación en Tiempo Real  
Chat bidireccional entre usuarios utilizando **WebSockets**.  
![Chat WebSockets](https://i.postimg.cc/QC4VtvVr/chatwebs.png)

---

## 🛠️ **Pasos para Configuración**
Sigue estos pasos para ejecutar la aplicación en tu entorno local:


### 1. **Configuración del Entorno**
Edita el archivo `application.properties` para configurar la base de datos y otros ajustes:  
```properties
# GENERAL
server.port=8087

# DATABASE
spring.datasource.url=jdbc:mysql://localhost/<TuBaseDatos>?serverTimezone=America/Lima
spring.datasource.username=<TuUsuario>
spring.datasource.password=<TuPassword>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.database=mysql

# JWT
security.jwt.secret=ghk45jgherogho834go3h4g
security.jwt.issuer=Main
security.jwt.ttlMillis=604800000
```


---

## 📋 **Requisitos Previos**
- **Java**: JDK 11 o superior.  
- **Maven**: Para gestionar las dependencias.  
- **Base de Datos MySQL**: Configurada y en ejecución.
- **IDE:** IntelliJIDEA

---
