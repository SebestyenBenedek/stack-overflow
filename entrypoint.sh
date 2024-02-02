#!/bin/sh

# Check if the .env file exists
if [ ! -f .env ]; then
  # Check if all required arguments are provided
    if [ $# -ne 3 ]; then
      echo "Usage: $0 <username> <password> <database>"
      exit 1
    fi

  # Create the .env file with the necessary credentials
  echo "POSTGRES_DB=$3" > .env
  echo "POSTGRES_USER=$1" >> .env
  echo "POSTGRES_PASSWORD=$2" >> .env
fi

# Start your Spring Boot application
exec java -jar /app.jar
