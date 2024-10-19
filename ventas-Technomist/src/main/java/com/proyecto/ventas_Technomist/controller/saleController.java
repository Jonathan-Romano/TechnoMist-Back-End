package com.proyecto.ventas_Technomist.controller;

import com.proyecto.ventas_Technomist.Dto.SaleDto;
import com.proyecto.ventas_Technomist.Dto.ShoppingCartDto;
import com.proyecto.ventas_Technomist.model.Sale;
import com.proyecto.ventas_Technomist.repository.IApiShoppingCart;
import com.proyecto.ventas_Technomist.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class saleController {
    @Autowired
    ISaleService saleServ;

    @GetMapping("/{id}")
    public Sale getSale(@PathVariable Long id) {
        return saleServ.getSale(id);
    }

    @GetMapping("/{id}/cart")
    public SaleDto getSaleWithCart(@PathVariable Long id) {
        return  saleServ.getSaleWitCart(id);
    }

    @GetMapping("/list")
    public List<Sale> getListSale(){return saleServ.getSales();}


    @GetMapping("/list/cart")
    public List<SaleDto> getListSaleWithCart(){
        List<SaleDto> ListSaleWithCart = new ArrayList<>();
        List<Sale> ListSale =  this.getListSale();

        for (Sale sale: ListSale
             ) {
            ListSaleWithCart.add(this.getSaleWithCart(sale.getId()));
        }
        return ListSaleWithCart;}

    @PostMapping("/create")
    public String createSale(@RequestBody Sale sale){
        return saleServ.saveSale(sale);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSale(@PathVariable Long id){
        return saleServ.deleteSale(id);
    }

    @PutMapping("/edit")
    public Sale editSale(@RequestBody Sale sale){
        return saleServ.editSale(sale);
    }

}
