package com.proyecto.ventas_Technomist.service;

import com.proyecto.ventas_Technomist.Dto.SaleDto;
import com.proyecto.ventas_Technomist.model.Sale;

import java.util.List;

public interface ISaleService {
    public Sale getSale(Long id);
    public SaleDto getSaleWitCart(Long id);

    public List<Sale> getSales();

    public String saveSale(Sale sale);

    public Sale editSale(Sale sale);

    public String deleteSale(Long id);

}
