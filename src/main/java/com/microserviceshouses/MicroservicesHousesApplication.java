package com.microserviceshouses;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
public class MicroservicesHousesApplication {



    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()  // No falla si el archivo .env no existe
                .ignoreIfMalformed() // Ignora líneas mal formateadas en .env
                .systemProperties()  // Carga las variables en System.getProperty()
                .load();


        SpringApplication.run(MicroservicesHousesApplication.class, args);
    }

}
