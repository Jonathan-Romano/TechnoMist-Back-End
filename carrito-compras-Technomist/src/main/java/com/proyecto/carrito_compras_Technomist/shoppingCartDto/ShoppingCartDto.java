package com.proyecto.carrito_compras_Technomist.shoppingCartDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
    private Long id;
    private List<ProductDto> productos =  new ArrayList<>();
    private double precioTotal;


    // Método para agregar producto al carrito
    public void agregarProductos(List<ProductDto> products) {
        productos = products;
        recalcularPrecioTotal();
    }

    // Método para quitar producto del carrito
    public void quitarProducto(String codP) {

        productos.removeIf(product -> product.getCodigo().equals(codP));
        recalcularPrecioTotal();
    }

    // Método para recalcular el precio total del carrito
    public void recalcularPrecioTotal() {
        precioTotal = 0.0;
        for (ProductDto producto : productos) {
            precioTotal += producto.getPrecio();
        }
    }
}
