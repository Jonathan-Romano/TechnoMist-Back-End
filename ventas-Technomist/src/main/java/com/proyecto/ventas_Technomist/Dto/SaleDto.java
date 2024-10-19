package com.proyecto.ventas_Technomist.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
    private Long id;
    private LocalDate date;
    ShoppingCartDto cart;
}
