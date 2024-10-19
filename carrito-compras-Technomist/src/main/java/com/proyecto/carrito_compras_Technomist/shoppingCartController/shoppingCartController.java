package com.proyecto.carrito_compras_Technomist.shoppingCartController;

import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ProductDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ShoppingCartDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartModel.ShoppingCart;
import com.proyecto.carrito_compras_Technomist.shoppingCartRepository.IProductApi;
import com.proyecto.carrito_compras_Technomist.shoppingCartService.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class shoppingCartController {

    @Autowired
    IShoppingCartService cartServ;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return cartServ.getProducts();
    }

    @GetMapping("/product/{cod}")
    public ProductDto getProducts(@PathVariable String cod) {
        return cartServ.getProducts(cod);
    }


    @GetMapping("/{id}")
    public ShoppingCartDto getCart(@PathVariable("id") Long id) {
        return  cartServ.getShoppingCartWithProducts(id);
    }


    @GetMapping("/list")
    public List<ShoppingCart> getCartsList() {
        return cartServ.getShoppingCarts();
    }

    @GetMapping("/list/products")
    public List<ShoppingCartDto> getCartsWithProductsList() {
        return cartServ.getShoppingCartsWithProducts();
    }

    @PostMapping("/create")
    public Long saveCart(@RequestBody ShoppingCart cart) {

        return cartServ.saveShoppingCart(cart);
    }


    @PostMapping("/{id}/add/product/{codP}")
    public ShoppingCart addProduct(@PathVariable("id") Long id,
                                   @PathVariable("codP") String codP) {
        ShoppingCart cart = cartServ.addProduct(id,codP);
        cart.calcularPrecioTotal(getCart(id).getProductos());
        return cart;
    }

    @DeleteMapping("/{id}/delete/product/{codP}")
    public ShoppingCart deleteProduct(@PathVariable("id") Long id,
                                      @PathVariable("codP") String codP) {
        ShoppingCart cart= cartServ.deleteProduct(id, codP);
        cart.calcularPrecioTotal(getCart(id).getProductos());
        return cart;
    }

    @DeleteMapping("/{id}/delete/products/{codP}")
    public ShoppingCart deleteProducts(@PathVariable("id") Long id,
                                      @PathVariable("codP") String codP) {
        ShoppingCart cart= cartServ.deleteProducts(id, codP);
        cart.calcularPrecioTotal(getCart(id).getProductos());
        return cart;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCart(@PathVariable Long id) {

        return cartServ.deleteShoppingCart(id);
    }


}
