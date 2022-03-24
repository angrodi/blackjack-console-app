## Aplicación de consola Blackjack
### Iniciar aplicación
- Crear imagen de la BD, dentro de la carpeta `/database` ejecutar: `docker build -t angrodi/blackjackdb .`
- Iniciar contenedor: ` docker run -d -p 3306:3306 --name mysql_server angrodi/blackjackdb``
- Para iniciar aplicacion ubicarse en la carpeta `/blackjack-console-app/target`, y ejecutar: `java -jar blackjack-console-app-0.0.1-SNAPSHOT.jar`