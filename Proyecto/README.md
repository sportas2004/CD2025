sudo apt update
sudo apt install wget tar openjdk-21-jdk
wget https://download.jetbrains.com/idea/ideaIC-2025.2.6.tar.gz
tar -xzf ideaIC-2025.2.6.tar.gz
sudo mv idea-IC-* /opt/intellij
sudo ln -s /opt/intellij/bin/idea.sh /usr/local/bin/idea

## Funciones de Maven
- `mvn clean`: Limpia el proyecto.
- `mvn compile`: Compila fuentes.
- `mvn test`: Ejecuta tests.
- `mvn package`: Crea el JAR ejecutable.
- `mvn javadoc:javadoc`: Genera Javadoc.
- `mvn dokka:dokka`: Genera documentación Kotlin.
- `mvn install`: Instala en repositorio local.
- `mvn deploy`: Despliega (requiere configuración).

