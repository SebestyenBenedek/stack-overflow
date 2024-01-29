#!/bin/sh

# Check if the .env file exists
if [ ! -f .env ]; then
  # Create the .env file with the necessary credentials
  echo "POSTGRES_DB=${POSTGRES_DB}" > .env
  echo "POSTGRES_USER=${POSTGRES_USER}" >> .env
  echo "POSTGRES_PASSWORD=${POSTGRES_PASSWORD}" >> .env
fi

# Start your Spring Boot application
exec java -jar /app.jar
