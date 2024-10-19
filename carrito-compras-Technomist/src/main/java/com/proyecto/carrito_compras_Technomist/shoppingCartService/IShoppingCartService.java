package com.proyecto.carrito_compras_Technomist.shoppingCartService;

import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ProductDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ShoppingCartDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartModel.ShoppingCart;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IShoppingCartService {
    public ShoppingCart getShoppingCart(Long id);
    public ShoppingCartDto getShoppingCartWithProducts(Long id);

    public List<ShoppingCart> getShoppingCarts();
    public List<ShoppingCartDto> getShoppingCartsWithProducts();

    public Long saveShoppingCart(ShoppingCart shoppingCart);
    public String priceShoppingCart(Long id,List<ProductDto> products);

    public ShoppingCart addProduct(Long id, String codP);

    public ShoppingCart deleteProduct(Long id, String codP);
    public ShoppingCart deleteProducts(Long id, String codP);

    public String deleteShoppingCart(Long id);


    //---------------------PRODUCTOS---------------------------
    public ProductDto getProducts(String codigo);
    public List<ProductDto> getProducts();
}
