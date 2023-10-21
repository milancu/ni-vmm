# Použijte oficiální obraz s Maven pro build
FROM maven:3.8.3-openjdk-17 AS builder

# Naklonujte váš zdrojový kód a zkopírujte do kontejneru
WORKDIR /app
COPY . .

# Spusťte Maven build (toto závisí na struktuře vašeho projektu a konfiguraci)
RUN mvn clean package

# Použijte oficiální obraz s Javou pro běh aplikace
FROM openjdk:17-jdk-slim

# Nastavte pracovní adresář v kontejneru
WORKDIR /app

# Zkopírujte JAR soubor z builder fáze
COPY --from=builder /app/target/project-0.0.1-SNAPSHOT.jar app.jar

# Exponujte port, na kterém bude aplikace běžet (nahraďte 8080, pokud používáte jiný port)
EXPOSE 8080

# Příkaz pro spuštění aplikace
CMD ["java", "-jar", "app.jar"]
