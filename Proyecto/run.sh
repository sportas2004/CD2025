#!/bin/bash

# Script para ejecutar el JAR en cualquier entorno Unix-like (incluyendo Ubuntu)

# Verificar si Java está instalado
if ! command -v java &> /dev/null; then
    echo "Java no está instalado. Instálalo con: sudo apt update && sudo apt install openjdk-17-jdk"
    exit 1
fi

# Verificar versión de Java (mínimo 8)
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 8 ]; then
    echo "Se requiere Java 8 o superior. Versión actual: $JAVA_VERSION"
    exit 1
fi

# Ejecutar el JAR
echo "Ejecutando aplicación..."
java -jar target/mi-plantilla-1.0-SNAPSHOT.jar