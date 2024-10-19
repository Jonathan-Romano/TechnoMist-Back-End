package com.proyecto.carrito_compras_Technomist.shoppingCartModel;

import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> codProducts =  new ArrayList<>();
    private double precioTotal;


    public void agregarProducto(String codP) {
        codProducts.add(codP);
    }

    public void quitarProducto(String codP) {

        codProducts.removeIf(product -> product.equals(codP));
    }

    public void quitarUnProducto(String codP) {
        for (Iterator<String> iterator = codProducts.iterator(); iterator.hasNext();) {
            String product = iterator.next();
            if (product.equals(codP)) {
                iterator.remove();
                break;
            }
        }
    }

    public void calcularPrecioTotal(List<ProductDto> productos) {
        precioTotal = 0.0;
        for (ProductDto producto : productos) {
            precioTotal += producto.getPrecio();
        }
    }

}
