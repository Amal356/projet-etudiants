# Projet Étudiants

## Description
Mini-projet complet : API REST Spring Boot 4 + Docker + Application mobile Flutter.

## Structure
- `api-spring-boot/etudiants/` : API Spring Boot 4
- `mobile_app/` : Application Flutter
- `docker-compose.yml` : Docker Compose

## Partie 1 — Lancer l'API Spring Boot
```bash
cd api-spring-boot/etudiants
mvn spring-boot:run
```
API : http://localhost:8080/api/etudiants

## Partie 2 — Lancer avec Docker
```bash
cd api-spring-boot/etudiants
mvn clean package -DskipTests
docker compose up --build
```

## Partie 3 — Lancer Flutter
```bash
cd mobile_app
flutter run -d web-server --web-port 3000
```
Ouvre : http://localhost:3000