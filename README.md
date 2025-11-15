# SPAIN API

Github action configured for CI/CD when merged to main.


## PROMETHEUS Y GRAFANA ANADIDOS

http://localhost:9090 -> prometheus
http://localhost:3000 -> graphana

Hay que configurar un docker-compose para prometheus y graphana en la raspberry pi para tener métricas y estadísticas de "prod"

## GITHUB ACTIONS

Hay un github actions para cuando se suben cambios a cualquier rama que empiece por `feature/` para que se ejecuten los tests
Hay otro github actions para cuando se suben/mergean cambios a main -> Sube una nueva imagen docker a docker hub para que se pueda 
desplegar en la raspberry pi.

sudo docker compose -f docker-compose.app.yml pull
sudo docker compose -f docker-compose.app.yml up -d

