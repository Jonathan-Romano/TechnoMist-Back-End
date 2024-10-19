package com.proyecto.carrito_compras_Technomist.shoppingCartRepository;

import com.proyecto.carrito_compras_Technomist.shoppingCartModel.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
