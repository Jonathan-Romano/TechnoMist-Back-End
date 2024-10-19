package com.proyecto.ventas_Technomist.service;

import com.proyecto.ventas_Technomist.Dto.SaleDto;
import com.proyecto.ventas_Technomist.Dto.ShoppingCartDto;
import com.proyecto.ventas_Technomist.model.Sale;
import com.proyecto.ventas_Technomist.repository.IApiShoppingCart;
import com.proyecto.ventas_Technomist.repository.ISaleRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class saleService implements ISaleService{

    @Autowired
    ISaleRepository saleRepo;

    @Autowired
    IApiShoppingCart cartApi;

    @Override
    public Sale getSale(Long id) {
        return saleRepo.findById(id).orElse(null);
    }

    @Override
    @CircuitBreaker(name="cart-service", fallbackMethod = "fallbackGetSaleWithCart")
    @Retry(name="cart-service")
    public SaleDto getSaleWitCart(Long id){
        Sale sale = this.getSale(id);
        ShoppingCartDto cartDto = cartApi.getCart(sale.getIdCart());

       // createExeption();

        return  new SaleDto(sale.getId(), sale.getDate(), cartDto);
    }

    @Override
    public List<Sale> getSales() {
        return saleRepo.findAll();
    }

    @Override
    public String saveSale(Sale sale) {
        saleRepo.save(sale);
        return "Venta realizada correctamente";
    }

    @Override
    public Sale editSale(Sale sale) {
        Sale saleEdit = this.getSale(sale.getId());
        saleEdit.setDate(sale.getDate());
        saleEdit.setIdCart(sale.getIdCart());
        this.saveSale(saleEdit);
        return saleEdit;
    }

    @Override
    public String deleteSale(Long id) {
        saleRepo.deleteById(id);
        return "Venta eliminada correctamente";
    }

    public SaleDto fallbackGetSaleWithCart(Throwable throwable){
        return new SaleDto(9999L,LocalDate.of(9999,9,9), null);
    }

    public void createExeption(){
        throw new IllegalArgumentException("Prueba Resilence");
    }
}
