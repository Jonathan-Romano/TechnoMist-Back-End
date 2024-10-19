package com.proyecto.carrito_compras_Technomist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarritoComprasTechnomistApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarritoComprasTechnomistApplication.class, args);
	}

}
