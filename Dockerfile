# Utiliser une image OpenJDK 17 slim comme base
FROM openjdk:17-jdk-slim

# Ajouter des métadonnées d'auteur
LABEL maintainer="HP"

# Définir un répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré dans le conteneur
COPY target/calculator-0.0.1-SNAPSHOT.jar /app/calculator.jar

# Exposer le port sur lequel l'application Spring Boot écoute (par défaut 8080)
EXPOSE 8081

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/calculator.jar"]
