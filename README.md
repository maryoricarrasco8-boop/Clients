# ClientMS – Entrega Final 🚀

Microservicio de **gestión de clientes** desarrollado en **Spring Boot** como parte del sistema **Banking Manager**. 
Incluye pruebas automatizadas (JUnit/Mockito), calidad de código (JaCoCo/Checkstyle), integración con **Kafka** y **Redis**, despliegue con **Docker/Compose**, documentación **Swagger/OpenAPI**, y artefactos de **Postman**.

> Este entregable está alineado con los requisitos del *Proyecto Final BTGP* (Junit + Mockito, pruebas reactivas si aplica, coverage Jacoco/Sonar, Checkstyle, SOLID, patrones, Redis/Kafka – parte teórica y aplicación) fileciteturn2file0

---

## 📦 Contenidos del repo
- `clientms/` → código fuente del microservicio ClientMS.
- `docs/` → diagramas (Mermaid) y documento **Aporte Redis-Kafka (.docx)**.
- `postman/` → colección y ambiente para pruebas.
- `docker-compose.yml` → stack local (MySQL, Redis, Kafka/Zookeeper, ClientMS).
- `README.md` → este documento.

---

## ⚙️ Tecnologías
Java 17 • Spring Boot 3 • Maven • MySQL • Redis • Apache Kafka • Docker/Compose • Swagger/OpenAPI • JUnit 5 • Mockito • JaCoCo • Checkstyle



## 🔗 Endpoints principales
| Método | Endpoint            | Descripción                 |
|-------:|---------------------|-----------------------------|
| GET    | `/api/clients`      | Listar clientes             |
| GET    | `/api/clients/{id}` | Obtener cliente por ID      |
| POST   | `/api/clients`      | Crear cliente               |
| PUT    | `/api/clients/{id}` | Actualizar cliente          |
| DELETE | `/api/clients/{id}` | Eliminar cliente            |

**Swagger UI:** `http://localhost:8080/swagger-ui.html`

---

## ▶️ Ejecución local
1) Variables (por `.env` o `application.yml`):
```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=clients
DB_USER=root
DB_PASS=secret

REDIS_HOST=localhost
REDIS_PORT=6379

KAFKA_BROKER=localhost:9092
```
2) Levantar:
```bash
mvn clean verify
mvn spring-boot:run
```

---

## 🐳 Docker / Compose
```bash
docker build -t client-service ./clientms
docker compose up -d --build
```

**Servicios**: MySQL, Redis, Zookeeper, Kafka, ClientMS.

---

## 🧪 Tests y cobertura
```bash
mvn test
# Reporte coverage: clientms/target/site/jacoco/index.html
```

---

## ✅ Calidad de código
- **Checkstyle**: `mvn validate` (usa `checkstyle/checkstyle.xml`)
- **SOLID y patrones**: desacoplamiento Service/Repository, DTOs, DI con Spring, Strategy para validaciones.

---

## 📂 Estructura
```
clientms/
├─ src/main/java/com/bootcamp/clientservice
│  ├─ controller/ClientController.java
│  ├─ service/ClientService.java
│  ├─ service/impl/ClientServiceImpl.java
│  ├─ repository/ClientRepository.java
│  ├─ model/Client.java
│  ├─ config/{KafkaConfig.java, RedisConfig.java, SwaggerConfig.java}
│  └─ ClientServiceApplication.java
├─ src/main/resources/application.yml
├─ pom.xml
├─ Dockerfile
└─ checkstyle/checkstyle.xml
```
flowchart LR
  A[Client / Postman] --> B[ClientMS (Spring Boot)]
  B --> K[(Kafka)]
  B --> R[(Redis)]
  B --> D[(MySQL)]

---
