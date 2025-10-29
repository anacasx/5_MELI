#!/bin/bash
echo "Starting MELI Orders API..."

# Set default profile to dev if not specified
PROFILE=${1:-dev}

# Set environment variables for production
if [ "$PROFILE" = "prod" ]; then
  export DB_URL=jdbc:postgresql://localhost:5432/ordersdb_prod
  export DB_USERNAME=meli_user
  export DB_PASSWORD=meli2025
fi

./mvnw clean spring-boot:run -Dspring-boot.run.profiles=$PROFILE