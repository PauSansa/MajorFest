#!/bin/zsh

# Script para iniciar el backend y el frontend de Major Fest

current_directory=$(pwd)

# Ruta al directorio del backend
backend_dir="$current_directory/major-fest-api"

# Ruta al directorio del frontend
frontend_dir="$current_directory/major-fest-client"

# Función para iniciar el backend en una nueva terminal en macOS
start_backend() {
  osascript <<EOD
    tell application "Terminal"
      activate
      do script with command "cd \"$backend_dir\" && source .env &&  ./gradlew bootRun"
    end tell
EOD
}

start_frontend() {
  cd $frontend_dir
  npx expo start
}

# Función para limpiar y detener los procesos antes de salir
cleanup() {
  echo "Deteniendo los procesos..."
  # Detener procesos de las funciones si están en ejecución
  kill $(lsof -t -i:8080)
}

# Configurar la acción de limpieza al recibir SIGINT (Ctrl+C)
trap cleanup SIGINT

# Llamada a la función de inicio del backend en una nueva terminal en macOS
start_backend &

# Esperar un poco para asegurarse de que el backend se haya iniciado
sleep 3

# Iniciar el frontend
start_frontend 

cleanup

# Esperar a que ambos procesos terminen

