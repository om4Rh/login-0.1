package utils;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {

    public static Connection getConnection() {
        System.out.println("Buscando database.properties...");

        // Intenta cargar el archivo
        try (InputStream input = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("database.properties")) {

            // Verifica si se encontró el archivo
            if (input == null) {
                String errorMsg = "ERROR: database.properties NO encontrado en classpath. ";
                errorMsg += "Buscar en: " + System.getProperty("java.class.path");
                throw new RuntimeException(errorMsg);
            }

            System.out.println("¡Archivo database.properties encontrado!");

            Properties properties = new Properties();
            properties.load(input);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            System.out.println("Conectando a: " + url);
            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
}
