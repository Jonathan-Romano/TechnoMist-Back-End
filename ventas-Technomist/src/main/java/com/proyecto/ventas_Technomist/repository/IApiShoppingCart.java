package com.proyecto.ventas_Technomist.repository;

import com.proyecto.ventas_Technomist.Dto.ShoppingCartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="productApi", url = "http://api-gateway-Technomist:443/cart-service/cart")
public interface IApiShoppingCart {
    @GetMapping("/{id}")
    public ShoppingCartDto getCart(@PathVariable("id") Long id);
}

