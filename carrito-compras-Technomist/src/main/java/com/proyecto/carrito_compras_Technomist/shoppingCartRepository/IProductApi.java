package com.proyecto.carrito_compras_Technomist.shoppingCartRepository;

import com.proyecto.carrito_compras_Technomist.shoppingCartDto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="productApi", url = "http://api-gateway-Technomist:443/products-service/product")
public interface IProductApi {
    @GetMapping("/list")
    public List<ProductDto> getListProduct();
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") Long id);

    @GetMapping
    public ProductDto getProductByCod(@RequestParam String codigo);

    @GetMapping("/listCod")
    public List<ProductDto> getProductsListByCod(@RequestBody List<String> codList);

}
