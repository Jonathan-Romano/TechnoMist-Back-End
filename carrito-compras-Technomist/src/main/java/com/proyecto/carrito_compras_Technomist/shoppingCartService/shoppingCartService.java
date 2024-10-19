package com.proyecto.carrito_compras_Technomist.shoppingCartService;

import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ProductDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ShoppingCartDto;
import com.proyecto.carrito_compras_Technomist.shoppingCartModel.ShoppingCart;
import com.proyecto.carrito_compras_Technomist.shoppingCartRepository.IProductApi;
import com.proyecto.carrito_compras_Technomist.shoppingCartRepository.IShoppingCartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class shoppingCartService implements IShoppingCartService {

    @Autowired
    IShoppingCartRepository cartServ;

    @Autowired
    IProductApi productApi;
    @Override
    public ShoppingCart getShoppingCart(Long id) {
        return cartServ.findById(id).orElse(null);
    }

    @Override
    @CircuitBreaker(name="products-service", fallbackMethod = "fallbackGetCarWithProducts")
    @Retry(name="products-service")
    public ShoppingCartDto getShoppingCartWithProducts(Long id) {
        ShoppingCart shoppingCart = this.getShoppingCart(id);
        ShoppingCartDto shoppingCartDtoWithProducts = new ShoppingCartDto();
        List<ProductDto> products = new ArrayList<>();

        for (String codP: shoppingCart.getCodProducts()
        ) {
            for (ProductDto product: productApi.getListProduct()) {

                if (product.getCodigo().equals(codP)){
                    products.add(product);
                }
            }
        }
        shoppingCartDtoWithProducts.setId(shoppingCart.getId());
        shoppingCartDtoWithProducts.setProductos(products);
        shoppingCartDtoWithProducts.recalcularPrecioTotal();
        this.priceShoppingCart(id, products);

        //createExeption();
        return shoppingCartDtoWithProducts;
    }

    @Override
    public List<ShoppingCart> getShoppingCarts() {
        return cartServ.findAll();
    }
    @Override
    @CircuitBreaker(name="products-service", fallbackMethod = "fallbackGetListCarWithProducts")
    @Retry(name="products-service")
    public List<ShoppingCartDto> getShoppingCartsWithProducts() {
        List<ShoppingCartDto> shoppingCartWithProductList = new ArrayList<>();
        for (ShoppingCart cart: this.getShoppingCarts()
        ) {
            shoppingCartWithProductList.add(this.getShoppingCartWithProducts(cart.getId()));
        }
        return shoppingCartWithProductList;
    }


    @Override
    public Long saveShoppingCart(ShoppingCart shoppingCart) {
        System.out.println(shoppingCart.getCodProducts());

        List<ProductDto> products = new ArrayList<>();

        for (String codP: shoppingCart.getCodProducts()
        ) {
            for (ProductDto product: productApi.getListProduct()) {

                if (product.getCodigo().equals(codP)){
                    products.add(product);
                }
            }
        }
        shoppingCart.calcularPrecioTotal(products);
        return cartServ.save(shoppingCart).getId();
    }

    @Override
    public String priceShoppingCart(Long id,List<ProductDto> products) {
        ShoppingCart shoppingCart = this.getShoppingCart(id);
        shoppingCart.calcularPrecioTotal(products);
        cartServ.save(shoppingCart);
        return "Precio actualizado correctamente";
    }


    @Override
    public ShoppingCart addProduct(Long id, String codP) {
        ShoppingCart cart = this.getShoppingCart(id);
        cart.agregarProducto(codP);
        this.saveShoppingCart(cart);
        return cart;
    }

    @Override
    public ShoppingCart deleteProduct(Long id, String codP) {
        ShoppingCart cart = this.getShoppingCart(id);
        cart.quitarUnProducto(codP);

        this.saveShoppingCart(cart);
        return cart;
    }

    @Override
    public ShoppingCart deleteProducts(Long id, String codP) {
        ShoppingCart cart = this.getShoppingCart(id);
        cart.quitarProducto(codP);

        this.saveShoppingCart(cart);
        return cart;
    }

    @Override
    public String deleteShoppingCart(Long id) {
        cartServ.deleteById(id);
        return "Se borro el carrito correctamente";
    }

    @Override
    public ProductDto getProducts(String codigo) {
        return  productApi.getProductByCod(codigo);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productApi.getListProduct();
    }


    public ShoppingCartDto fallbackGetCarWithProducts (Throwable throwable){
        return new ShoppingCartDto(99999L, null, 99999);
    }

    public List<ShoppingCartDto>fallbackGetListCarWithProducts(Throwable throwable){
        List<ShoppingCartDto> shoppingCartDtoList = new ArrayList<>();
        shoppingCartDtoList.add(new ShoppingCartDto(99999L, null, 99999));

        return shoppingCartDtoList;
    }

     public void createExeption(){
        throw new IllegalArgumentException("Prueba Resilence");
    }
}
