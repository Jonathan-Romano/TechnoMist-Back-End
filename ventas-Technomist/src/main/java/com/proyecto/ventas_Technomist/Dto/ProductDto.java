package com.proyecto.ventas_Technomist.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String codigo;
    private String nombre;
    private String marca;
    private double precio;
}
